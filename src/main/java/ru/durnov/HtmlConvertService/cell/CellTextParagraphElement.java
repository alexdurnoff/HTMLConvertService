package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;

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
                setFontToXSSFRichTextString();
            }
        });
    }

    protected void setFontToXSSFRichTextString(){
        new XSSFRichStringStyle(element,xssfCell).applyToXSSFRichTextString();
    }

    @Override
    public void applyToXSSFCell() {

    }
}
