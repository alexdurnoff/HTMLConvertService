package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class XSSFRichTextStringFromElement {
    private final Element element;
    private final XSSFCell xssfCell;
    private final XSSFFont xssfFont;

    public XSSFRichTextStringFromElement(Element element, XSSFCell xssfCell, XSSFFont xssfFont) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfFont = xssfFont;
    }

    public XSSFRichTextStringFromElement(Element element, XSSFCell xssfCell){
        this.element = element;
        this.xssfCell = xssfCell;
        this.xssfFont = xssfCell.getCellStyle().getFont();
    }

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
            log.debug("bold is " + font.getBold());
            if (!element1.ownText().equals("")) {
                xssfRichTextString.append(new OwnTextFromElement(element1).text(), font);
                log.debug("append " + new OwnTextFromElement(element1).text() + "with bold " + font.getBold());
            }
        }
        return xssfRichTextString;
    }
}
