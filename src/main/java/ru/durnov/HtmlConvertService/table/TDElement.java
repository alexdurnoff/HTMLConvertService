package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

public class TDElement implements DocxTableCellElement {
    private final Element element;
    private final XWPFRun xwpfRun;
    private final Style style;

    /**
     * Собственно td-элемент.
     * @param element - Element в html
     * @param xwpfRun - Текущий XWPFRun
     * @param style - текузий стиль.
     */
    public TDElement(Element element, XWPFRun xwpfRun, Style style) {
        this.element = element;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    @Override
    public void addToXWPFRun() {
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
        });

    }
}
