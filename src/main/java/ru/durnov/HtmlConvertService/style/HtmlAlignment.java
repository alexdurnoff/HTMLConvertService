package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.jsoup.nodes.Attributes;

public class HtmlAlignment extends StringAttributeValue {
    public HtmlAlignment(Attributes attributes) {

        super("text-align:\\s?(.*);", "left", attributes);
    }

    public ParagraphAlignment paragraphAlignment(){
        if (this.value().equals("center")) return ParagraphAlignment.CENTER;
        if (this.value().equals("left")) return ParagraphAlignment.LEFT;
        if (this.value().equals("right")) return ParagraphAlignment.RIGHT;
        if (this.value().equals("")) return ParagraphAlignment.BOTH;
        return ParagraphAlignment.CENTER;
    }

    @Override
    public String toString() {
        return "Alignment is " + this.value();
    }
}
