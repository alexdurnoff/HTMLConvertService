package ru.durnov.HtmlConvertService.table;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;

public class XlsxCellAlignment {
    private final HtmlAlignment htmlAlignment;

    public XlsxCellAlignment(HtmlAlignment htmlAlignment) {
        this.htmlAlignment = htmlAlignment;
    }


    private HorizontalAlignment horizontalAlignment() {
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.CENTER)) return HorizontalAlignment.CENTER;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.LEFT)) return HorizontalAlignment.LEFT;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.RIGHT)) return HorizontalAlignment.RIGHT;
        if (this.htmlAlignment.paragraphAlignment().equals(ParagraphAlignment.BOTH)) return HorizontalAlignment.FILL;
        return HorizontalAlignment.JUSTIFY;
    }

    private VerticalAlignment verticalAlignment(){
        return VerticalAlignment.CENTER;//Пока так
    }

    public void setupXSSFAlignment(XSSFCellStyle xssfCellStyle){
        xssfCellStyle.setAlignment(horizontalAlignment());
        xssfCellStyle.setVerticalAlignment(verticalAlignment());
    }
}
