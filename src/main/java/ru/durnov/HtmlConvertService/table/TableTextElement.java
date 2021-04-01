package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

public class TableTextElement implements DocxTableCellElement{
    protected final Element element;
    protected final XWPFRun xwpfRun;
    protected final Style style;

    public TableTextElement(Element element, XWPFRun xwpfRun, Style style) {
        this.element = element;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }


    @Override
    public void addToXWPFRun() {
        if (!element.ownText().equals("")){
            System.out.println("create SimpleText");
            new SimpleTableTextElement(element, xwpfRun, style).addToXWPFRun();
        }
        element.childNodes().forEach(node -> {
            System.out.println("childNode is " + node);
            if (node.getClass() == Element.class){
                new ElementTableFactory(
                        node,
                        xwpfRun,
                        style
                )
                        .elementByName()
                        .addToXWPFRun();
            }
        });

    }
    /*if (!element.ownText().equals("")){
            new SimpleTableTextElement(element, xwpfRun, style).addToXWPFRun();
        }
        element.childNodes().forEach(node -> {
            if (node.getClass() == Element.class){
                new ElementTableFactory(
                        node,
                        xwpfRun,
                        style
                )
                        .elementByName()
                        .addToXWPFRun();
            }
        });*/
}
