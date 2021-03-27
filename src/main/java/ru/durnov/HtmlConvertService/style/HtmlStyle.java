package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.docx4j.model.properties.run.HighlightColor;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import ru.durnov.HtmlConvertService.node.HtmlFont;
import ru.durnov.HtmlConvertService.node.Style;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;

public class HtmlStyle implements Style {
    private final HtmlFont htmlFont;
    private final HtmlAlignment htmlAlignment;
    private final HtmlBackGround htmlBackGround;

    public HtmlStyle(Attributes attributes){
        this.htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes)
        );
        this.htmlAlignment = new HtmlAlignment(attributes);
        this.htmlBackGround = new HtmlBackGround(attributes);
    }

    public HtmlStyle(HtmlFont htmlFont, HtmlAlignment htmlAlignment, HtmlBackGround htmlBackGround) {
        this.htmlFont = htmlFont;
        this.htmlAlignment = htmlAlignment;
        this.htmlBackGround = htmlBackGround;
    }

    @Override
    public HtmlStyle withFont(HtmlFont font){
        return new HtmlStyle(font, this.htmlAlignment, this.htmlBackGround);
    }

    @Override
    public HtmlStyle withAlignment(HtmlAlignment alignment){
        return new HtmlStyle(this.htmlFont, alignment, this.htmlBackGround);
    }

    @Override
    public HtmlStyle withBackGround(HtmlBackGround backGround){
        return new HtmlStyle(this.htmlFont, htmlAlignment, backGround);
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {
        xwpfRun.setFontFamily("Times new Roman");
        xwpfRun.setFontSize(this.htmlFont.fontSize().value());
        if (this.htmlFont.fontWeight().value().equals("bolder")) xwpfRun.setBold(true);
        XWPFParagraph xwpfParagraph = (XWPFParagraph) xwpfRun.getParent();
        xwpfParagraph.setAlignment(this.htmlAlignment.paragraphAlignment());
        if (!htmlBackGround.value().equals("auto"))xwpfRun.getCTR().addNewRPr().addNewHighlight().setVal(STHighlightColor.YELLOW);
    }
}
