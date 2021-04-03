package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;

public class XlsxCellAlignment {
    private final HtmlAlignment htmlAlignment;

    public XlsxCellAlignment(HtmlAlignment htmlAlignment) {
        this.htmlAlignment = htmlAlignment;
    }


    public HorizontalAlignment horizontalAlignment() {
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.CENTER)) return HorizontalAlignment.CENTER;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.LEFT)) return HorizontalAlignment.LEFT;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.RIGHT)) return HorizontalAlignment.RIGHT;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.BOTH)) return HorizontalAlignment.FILL;
        return HorizontalAlignment.JUSTIFY;
    }
}
