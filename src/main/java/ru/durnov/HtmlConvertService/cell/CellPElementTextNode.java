package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Node;

@Slf4j
/**
 * Представляет собой ребенка, инкапсулирующего собственный текст p-элемента.
 */
public class CellPElementTextNode implements CellParagraphElement{
    private final Node node;
    private final XSSFCell xssfCell;

    public CellPElementTextNode(Node node, XSSFCell xssfCell) {
        this.node = node;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        node.attributes().forEach(attribute -> {
            if (attribute.getKey().equals("#text")) xssfRichTextString.append(attribute.getValue());
        });
        xssfCell.setCellValue(xssfRichTextString.getString());
    }

    @Override
    public void applyToXSSFCell() {

    }
}
