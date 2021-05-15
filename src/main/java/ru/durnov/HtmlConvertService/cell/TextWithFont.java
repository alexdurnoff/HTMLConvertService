package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;


@Slf4j
public class TextWithFont {
    private final String text;
    private final XSSFFont font;

    public TextWithFont(String text, XSSFFont font) {
        this.text = text;
        this.font = font;
    }

    public void appendToXSSFString(XSSFRichTextString xssfRichTextString){
        xssfRichTextString.append(text, font);
    }

    public int index(String elementText) {
        return elementText.indexOf(text);
    }
}
