package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Element;

/**
 * Настройка стиля текста для тэга small.
 */
public class XSSFRichStringSmallStyle extends XSSFRichStringStyle{
    public XSSFRichStringSmallStyle(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    protected boolean setupFontIsNeeded() {
        return true;
    }

    @Override
    protected boolean elementHtmlContainsFontSettings() {
        String html = element.parent().outerHtml();
        return html.contains("font-size") || html.contains("font-weight");
    }

    @Override
    protected void setFontHeight(XSSFFont xssfFont) {
        if (elementHtmlContainsFontSettings()){
            xssfFont.setFontHeight(this.fontSize.value()-2);
        } else {
            xssfFont.setFontHeight(
                    this.xssfCell
                            .getCellStyle()
                            .getFont()
                            .getFontHeight() - 2
            );
        }
    }



}
