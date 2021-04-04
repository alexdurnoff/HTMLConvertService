package ru.durnov.HtmlConvertService.xlsx;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.StrongAttaributes;
import ru.durnov.HtmlConvertService.style.TableCellCollSpan;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;
import ru.durnov.HtmlConvertService.text.XlxsElement;

/**
 * Класс пишем вместо XlsxTableCell из-за лютой котовасии
 * с тэгами td и tr.
 */
public class XlsxCell {
    private final String content;
    private final Attributes attributes;
    private final boolean isHeader;

    public XlsxCell(String content,
                    Attributes attributes,
                    boolean isHeader) {
        this.content = content;
        this.attributes = attributes;
        this.isHeader = isHeader;
    }


    public void addToXSSFCell(XSSFRow xssfRow, CurrentColumnNumber columnNumber) {
        XSSFCell xssfCell = new NewXSSFtableCell(xssfRow, columnNumber.columnNumber()).createCellByNumber();
        int collspan = new TableCellCollSpan(attributes).collspan();
        if (collspan > 1){
            int firstRow = xssfCell.getRowIndex();
            int firstColumn = xssfCell.getColumnIndex();
            int lastColumn = firstColumn + collspan - 1;
            xssfCell.getRow().getSheet().addMergedRegion(
                    new CellRangeAddress(
                            firstRow,
                            firstRow,
                            firstColumn,
                            lastColumn
                    )
            );
            columnNumber.increaseColumnNumber(collspan);
        } else {
            columnNumber.increaseColumnNumber(1);
        }
        addTextToXSSFCell(xssfCell);

    }

    private void addTextToXSSFCell(XSSFCell xssfCell) {
        XlsxCellStyle xlsxCellStyle = new XlsxCellStyle(
                attributes,
                xssfCell
                .getRow()
                .getSheet()
                .getWorkbook()
        );
        if (isHeader) xlsxCellStyle = xlsxCellStyle.withFontWeight(new FontWeight(new StrongAttaributes().attributes()));
        xlsxCellStyle.applyToXlsxTableCell(xssfCell);
        xssfCell.setCellValue(content);
    }

    /**
     * Метод проверяет наличие атрибута "t" со значенем "z".
     * Нужен для определения назанчения всей строки, содержащей даную ячейку.
     * Если в строке все ячейки окажутся такие, то это строка
     * для изображения границы таблицы, а не данных.
     * @return
     */
    public boolean isBorderCell(){
        for (Attribute attribute : attributes) {
            if (attribute.getKey().equals("t")){
                if (attribute.getValue().equals("z")) return true;
            }
        }
        return false;
    }


}
