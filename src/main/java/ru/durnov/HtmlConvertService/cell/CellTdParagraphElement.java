package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.table.XSSFRichStringStyle;

@Slf4j
public class CellTdParagraphElement implements CellParagraphElement {
    protected  final Element element;
    protected  final XSSFCell xssfCell;


    public CellTdParagraphElement(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }

    @Override
    public void addToXSSFCell() {
        log.debug("cell value before td element is " + xssfCell.getStringCellValue());
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
                new XSSFRichStringStyle(element,xssfCell).applyToXSSFRichTextString();
            }
        });
        log.debug("cell value after td element is " + xssfCell.getStringCellValue());

    }
}
