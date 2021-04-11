package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/**
 * Класс будет поставлять элементы для добавления в ячейку таблицы xslx.
 */
public class CellElementFactory {
    private final Element element;
    private final XSSFCell xssfCell;



    public CellElementFactory(Element element, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
    }


    public CellElementFactory(Node node, XSSFCell xssfCell){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.xssfCell = xssfCell;
    }



    public CellParagraphElement elementByName(){
        if (element.nodeName().equals("p")
                || element.nodeName().equals("label")
                || element.nodeName().equals("th")){
            return new CellTextParagraphElement(element, xssfCell);
        }
        if (element.nodeName().equals("td")) return new CellTdParagraphElement(element, xssfCell);
        if (element.nodeName().equals("span")) return new CellSpanElement(element, xssfCell);
        if (element.nodeName().equals("br")) return new CellBrParagraphElement(element, xssfCell);
        if (element.nodeName().equals("h2")) return new CellH2ParagraphElement(element, xssfCell);
        if (element.nodeName().equals("strong") || element.nodeName().equals("b")) return new CellStrongParargaphElement(element, xssfCell);
        return new CellEmptyParagraphElement();
    }
}
