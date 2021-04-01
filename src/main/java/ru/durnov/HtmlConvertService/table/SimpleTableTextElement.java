package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

public class SimpleTableTextElement implements DocxTableCellElement{
    private final Element element;
    private final XWPFRun xwpfRun;
    private final Style style;
    public SimpleTableTextElement(Element element, XWPFRun xwpfRun, Style style) {
        this.element = element;
        this.xwpfRun = xwpfRun;
        this.style = style;
    }

    @Override
    public void addToXWPFRun() {
        style.applyToRun(xwpfRun);
        xwpfRun.setText(element.text());
    }
}
