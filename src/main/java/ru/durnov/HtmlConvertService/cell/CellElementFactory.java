package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;

/**
 * Класс будет поставлять элементы для добавления в ячейку таблицы xslx.
 */
public class CellElementFactory {
    private final Element element;
    private final XSSFCell xssfCell;
    private final Style htmlStyle;

    public CellElementFactory(Element element, XSSFCell xssfCell, Style htmlStyle) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.htmlStyle = htmlStyle;
    }

    public CellElementFactory(Node node, XSSFCell xssfCell){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.xssfCell = xssfCell;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public CellElementFactory(Node node, XSSFCell xssfCell, Style htmlStyle){
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.xssfCell = xssfCell;
        this.htmlStyle = htmlStyle.withAttributes(element.attributes());
    }

    public CellElementFactory(Element element, XSSFCell xssfCell){
        this.element = element;
        this.xssfCell = xssfCell;
        this.htmlStyle = new HtmlStyle(element.attributes());
    }

    public CellParagraphElement elementByName(){
        if (element.nodeName().equals("p") || element.nodeName().equals("span") || element.nodeName().equals("label")){
            return new CellTextParagraphElement(element, xssfCell);
        }
        if (element.nodeName().equals("br")) return new CellBrParagraphElement(element, xssfCell);
        if (element.nodeName().equals("h2")) return new CellH2ParagraphElement(element, xssfCell);
        if (element.nodeName().equals("strong") || element.nodeName().equals("b")) return new CellStrongParargaphElement(element, xssfCell);
        return new CellEmptyParagraphElement();
    }
}
