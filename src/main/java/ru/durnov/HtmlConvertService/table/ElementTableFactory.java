package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import ru.durnov.HtmlConvertService.docx.DocxParagraphTable;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.Style;
import ru.durnov.HtmlConvertService.text.*;

public class ElementTableFactory {
    private final Element element;
    private final XWPFRun xwpfRun;
    private final Style style;

    public ElementTableFactory(Element element, XWPFRun xwpfRun, Style style) {
        this.element = element;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    public ElementTableFactory(Node node, XWPFRun xwpfRun, Style style) {
        if (node.getClass() != Element.class) throw new IllegalArgumentException("node must be element");
        this.element = (Element) node;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    public DocxTableCellElement elementByName() {
        if (element.nodeName().equals("p") || element.nodeName().equals("span") || element.nodeName().equals("label")){
            return new TableTextElement(element,xwpfRun,style);
        }
        if (element.nodeName().equals("br")) return new TableCellBrElement(element, xwpfRun, style);
        return new EmptyTableElement();
    }
}
