package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.*;

/**
 * Стиль Html таблицы. Включает в себя html-стиль и добавляет
 * специфические для таблицы параметры.
 */
public class HtmlTableStyle implements Style {
    private final Element element;
    private final Style style;
    private final TableBorder tableBorder;

    public HtmlTableStyle(Element element, Style style) {
        this.element = element;
        this.style = style;
        this.tableBorder = new TableBorder(element);
    }

    public HtmlTableStyle(Element element, Style style, TableBorder tableBorder){
        this.element = element;
        this.style =style;
        this.tableBorder = tableBorder;
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
        return new HtmlTableStyle(element, htmlStyle, tableBorder);
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {
        this.style.applyToRun(xwpfRun);
    }

    public void applyToXWPFTable(XWPFTable xwpfTable){
        xwpfTable.setBottomBorder(this.tableBorder.borderType(), 12, 8, "auto");
        xwpfTable.setLeftBorder(this.tableBorder.borderType(), 12, 8, "auto");
        xwpfTable.setRightBorder(this.tableBorder.borderType(), 12, 8, "auto");
        xwpfTable.setTopBorder(this.tableBorder.borderType(), 12, 8, "auto");
        xwpfTable.setInsideHBorder(this.tableBorder.borderType(), 12, 8, "auto");
        xwpfTable.setInsideVBorder(this.tableBorder.borderType(), 12, 8, "auto");
    }

}
