package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.table.XSSFRichStringStyle;
import ru.durnov.HtmlConvertService.text.ElementFactory;

import java.io.IOException;

@Slf4j
public class CellTextParagraphElement implements CellParagraphElement {
    protected final Element element;
    protected final XSSFCell xssfCell;


    public CellTextParagraphElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }


    @Override
    public void addToXSSFCell() {
        log.debug("cell value before p element is " + xssfCell.getStringCellValue());
        element.childNodes().forEach(node -> {
            log.debug("element childNodes size is " + element.childNodes().size());
            if (node.getClass() == Element.class) {
                Element element1 = (Element) node;
                new CellElementFactory(
                        element1,
                        xssfCell
                ).elementByName().addToXSSFCell();
            }
            if (node.nodeName().equals("#text")) {
                new CellPElementTextNode(node, xssfCell).addToXSSFCell();
                new XSSFRichStringStyle(element,xssfCell).applyToXSSFRichTextString();
            }
        });
        log.debug("cell value after p element is " + xssfCell.getStringCellValue());

    }
}
