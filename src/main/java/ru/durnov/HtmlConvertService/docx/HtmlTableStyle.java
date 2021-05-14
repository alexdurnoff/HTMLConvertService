package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.*;
import ru.durnov.HtmlConvertService.style.border.HtmlTableBorder;

/**
 * Стиль Html таблицы. Включает в себя html-стиль и добавляет
 * специфические для таблицы параметры.
 */
public class HtmlTableStyle implements Style {
    private final Element element;
    private final Style style;
    private final HtmlTableBorder htmlTableBorder;

    public HtmlTableStyle(Element element, Style style) {
        this.element = element;
        this.style = style;
        this.htmlTableBorder = new HtmlTableBorder(element);
    }

    public HtmlTableStyle(Element element, Style style, HtmlTableBorder htmlTableBorder){
        this.element = element;
        this.style = style;
        this.htmlTableBorder = htmlTableBorder;
    }

    @Override
    public Style withFont(HtmlFont font) {
        return this.style.withFont(font);
    }

    @Override
    public Style withAlignment(HtmlAlignment alignment) {
        return this.style.withAlignment(alignment);
    }

    @Override
    public Style withBackGround(HtmlBackGround backGround) {
        return this.style.withBackGround(backGround);
    }

    @Override
    public Style withAttributes(Attributes attributes) {
        Style htmlStyle = this.style.withAttributes(attributes);
        return new HtmlTableStyle(element, htmlStyle, htmlTableBorder);
    }

    @Override
    public Style withWidth(HtmlWidth htmlWidth) {
        return this.style.withWidth(htmlWidth);
    }

    @Override
    public HtmlFont font() {
        return this.style.font();
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {
        this.style.applyToRun(xwpfRun);
    }

    public void applyToXWPFTable(XWPFTable xwpfTable){
        xwpfTable.setBottomBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
        xwpfTable.setLeftBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
        xwpfTable.setRightBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
        xwpfTable.setTopBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
        xwpfTable.setInsideHBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
        xwpfTable.setInsideVBorder(this.htmlTableBorder.borderType(), 12, 0, "auto");
    }

}
