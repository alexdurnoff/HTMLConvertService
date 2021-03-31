package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.jsoup.nodes.Element;

/**
 * Пока что класс не дописан.
 */
public class XWPFCellStyle implements CellStyle{
    private final Element element;

    public XWPFCellStyle(Element element) {
        this.element = element;
    }


    @Override
    public void applyToXWPFCell(XWPFTableCell xwpfTableCell) {
        HtmlFont htmlFont = new HtmlFont(
                new FontSize(element.attributes()),
                new FontWeight(element.attributes())
        );
        HtmlAlignment htmlAlignment = new HtmlAlignment(element.attributes());
        HtmlBackGround htmlBackGround = new HtmlBackGround(element.attributes());
    }
}
