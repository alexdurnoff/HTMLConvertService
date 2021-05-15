package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.List;

@Slf4j
public class XSSFRichTextStringFromElement {
    private final Element element;
    private final XSSFCell xssfCell;
    private final XSSFFont xssfFont;

    public XSSFRichTextStringFromElement(Element element, XSSFCell xssfCell){
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfFont = xssfCell.getCellStyle().getFont();
    }

    @Deprecated
    public XSSFRichTextString xssfRichTextString(){
        XSSFFont font = this.xssfFont;
        XSSFRichTextString xssfRichTextString = new XSSFRichTextString();
        Elements allElements = element.getAllElements();
        for (Element element1 : allElements) {
            font = new XSSFFontFromElement(
                    element1,
                    font,
                    xssfCell
            ).xssfFont();
            if (!element1.ownText().equals("")) {
                xssfRichTextString.append(new OwnTextFromElement(element1).text(), font);
            }
        }
        return xssfRichTextString;
    }

    public XSSFRichTextString xssfRichTextStringByOrder(){
        XSSFRichTextString xssfRichTextString = new XSSFRichTextString();
        List<TextWithFont> textWithFontList = new TextWithFonts(element, xssfFont, xssfCell).list();
        textWithFontList.forEach(t->{
            t.appendToXSSFString(xssfRichTextString);
        });
        return xssfRichTextString;
    }
}
