package ru.durnov.HtmlConvertService.table;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.Style;

public class TableCellBrElement extends TableTextElement {


    public TableCellBrElement(Element element, XWPFRun xwpfRun, Style style) {
        super(element,xwpfRun,style);
    }

    @Override
    public void addToXWPFRun() {
        this.style.applyToRun(xwpfRun);
        xwpfRun.addBreak();
    }
}
