package ru.durnov.HtmlConvertService.text;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.StringAttributeValue;

public class CellAllignment extends StringAttributeValue {

    public CellAllignment(Attributes attributes) {
        super("text-align:\\s(.*);", "center", attributes);
    }

    public ParagraphAlignment paragraphAlignment(){
        if (this.value().equals("center")) return ParagraphAlignment.CENTER;
        if (this.value().equals("left")) return ParagraphAlignment.LEFT;
        if (this.value().equals("right")) return ParagraphAlignment.RIGHT;
        return ParagraphAlignment.CENTER;
    }


}
