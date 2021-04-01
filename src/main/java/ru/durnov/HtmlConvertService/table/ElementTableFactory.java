package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.style.Style;

public class ElementTableFactory {
    private final Element element;
    private final XWPFRun xwpfRun;
    private final Style style;

    public ElementTableFactory(Element element, XWPFRun xwpfRun, Style style) {
        System.out.println("Вызван коструктор");
        this.element = element;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    public ElementTableFactory(Node node, XWPFRun xwpfRun, Style style) {
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        System.out.println("ElementFactory.element is " + element);
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    public DocxTableCellElement elementByName() {
        if (element.nodeName().equals("p") ||
                element.nodeName().equals("span") ||
                element.nodeName().equals("label") ||
                element.nodeName().equals("td")
        ){
            return new TableTextElement(element,xwpfRun,style);
        }
       /* if (element.nodeName().equals("br")){
            return new TableCellBrElement(element, xwpfRun, style);
        }*/
        /*if (element.nodeName().equals("td")){
            return new TDElement(element,xwpfRun,style);
        }*/
        return new EmptyTableElement();
    }
}
