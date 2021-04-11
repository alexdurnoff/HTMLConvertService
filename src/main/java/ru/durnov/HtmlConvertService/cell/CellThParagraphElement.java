package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;

@Slf4j
public class CellThParagraphElement implements CellParagraphElement {
    protected  final Element element;
    protected  final XSSFCell xssfCell;


    public CellThParagraphElement(Element element, XSSFCell xssfCell) {
        log.debug("th constructor invoked");
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        log.debug("cell value before th element is " + xssfCell.getStringCellValue());
        log.debug("td element childnodes size is " + element.childNodes().size());
        element.childNodes().forEach(node -> {
            if (node.getClass() == Element.class) {
                Element element1 = (Element) node;
                new CellElementFactory(
                        element1,
                        xssfCell
                ).elementByName().addToXSSFCell();
            }
            if (node.nodeName().equals("#text")) {
                new CellPElementTextNode(node, xssfCell).addToXSSFCell();
                new XSSFRichStringHeaderStyle(element,xssfCell).applyToXSSFRichTextString();
            }
        });
        log.debug("cell value after th element is " + xssfCell.getStringCellValue());
    }

    @Override
    public void applyToXSSFCell() {

    }
}
