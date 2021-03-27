package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.node.StringAttributeValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlAlignment extends StringAttributeValue {
    public HtmlAlignment(Attributes attributes) {
        super("text-align:\\s(.*);", "center", attributes);
    }

    public ParagraphAlignment paragraphAlignment(){
        if (this.value().equals("center")) return ParagraphAlignment.CENTER;
        if (this.value().equals("left")) return ParagraphAlignment.LEFT;
        if (this.value().equals("right")) return ParagraphAlignment.RIGHT;
        if (this.value().equals("")) return ParagraphAlignment.BOTH;
        return ParagraphAlignment.CENTER;
    }
}
