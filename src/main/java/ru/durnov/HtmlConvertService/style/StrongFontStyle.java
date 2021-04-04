package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attributes;

/**
 * Стиль для тэга strong с жирным шрифтом
 */
public class StrongFontStyle implements Style{
    private final Style style;

    public StrongFontStyle(Style style) {
        this.style = style;
    }

    @Override
    public Style withFont(HtmlFont font) {
        return new StrongFontStyle(style.withFont(font));
    }

    @Override
    public Style withAlignment(HtmlAlignment alignment) {
        return new StrongFontStyle(style.withAlignment(alignment));
    }

    @Override
    public Style withBackGround(HtmlBackGround backGround) {
        return new StrongFontStyle(style.withBackGround(backGround));
    }

    @Override
    public Style withAttributes(Attributes attributes) {
        return new StrongFontStyle(style.withAttributes(attributes));
    }

    @Override
    public Style withWidth(HtmlWidth htmlWidth) {
        return new StrongFontStyle(style.withWidth(htmlWidth));
    }

    @Override
    public HtmlFont font() {
        return this.style
                .font()
                .withFontWeight(new FontWeight(
                        new StrongAttaributes().attributes()
                        )
                );
    }

    @Override
    public void applyToRun(XWPFRun xwpfRun) {
        style.applyToRun(xwpfRun);
        xwpfRun.setBold(true);
    }
}
