package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.FontSize;
import ru.durnov.HtmlConvertService.style.FontWeight;

@Slf4j
/**
 * Стиль для части строки в ячейке xlsx-документа.
 */
public class XSSFRichStringStyle {
    protected final Element element;
    private final XSSFRichTextString xssfRichTextString;
    protected final XSSFCell xssfCell;
    protected final FontSize fontSize;
    protected final FontWeight fontWeight;

    /**
     * @param element - элемент, из атрибутов которого создаем стиль.
     * @param xssfRichTextString - строка значения ячейки.
     * @param xssfCell - собственно ячейка. Нужна для создания шрифта. Вот так ее приходится таскать.
     */
    public XSSFRichStringStyle(Element element, XSSFRichTextString xssfRichTextString, XSSFCell xssfCell) {
        this.element = element;
        this.xssfRichTextString = xssfRichTextString;
        this.xssfCell = xssfCell;
        this.fontSize = new FontSize(element.attributes());
        this.fontWeight = new FontWeight(element.attributes());
    }

    public XSSFRichStringStyle(Element element, XSSFCell xssfCell){
        this(element, xssfCell.getRichStringCellValue(), xssfCell);
    }

    public void applyToXSSFRichTextString() {
        if (elementHtmlContainsFontSettings()) setupFont();
    }

    /**
     * Метод определяет, нужна ли настройка шрифта в прринципе.
     * Для разных тэгов логика будет разная, поэтому два boolean-метода
     * разделены.
     * @return - true, если настройка нужна.
     */
    protected boolean setupFontIsNeeded(){
        return elementHtmlContainsFontSettings();
    }

    /**
     * Метод определяет, есть ли в атрибутах элемента настройка шрифта
     * @return true, если настройка шрифта есть в атрибутах элемента.
     */
    protected boolean elementHtmlContainsFontSettings(){
        String html = element.outerHtml();
        return html.contains("font-size") || html.contains("font-weight");
    }


    /**
     * Вынесен в отдельный метод. Будет переопределяться в наследниках.
     */
    protected void setupFont(){
        String elementContent = element.ownText();
        String cellContent = xssfRichTextString.getString();
        if (cellContent.contains(elementContent) && elementContent.length() > 0){
            int startIndex = cellContent.length() - elementContent.length();
            int endIndex = cellContent.length();
            XSSFFont xssfFont = xssfCell.getSheet().getWorkbook().createFont();
            setFontHeight(xssfFont);
            setFontWeight(xssfFont);
            xssfRichTextString.applyFont(startIndex, endIndex, xssfFont);
        }
    }

    /**
     * Вынесен в отдельный метод. Будет переопределяться в наследниках.
     * @param xssfFont - текущий шрифт XSSFRichTextString
     */
    protected void setFontHeight(XSSFFont xssfFont){
        xssfFont.setFontHeight(fontSize.value());
    }

    /**
     * Вынесен в отдельный метод. Будет переопределяться в наследниках.
     * @param xssfFont - текущий шрифт XSSFRichTextString
     */
    protected void setFontWeight(XSSFFont xssfFont){
        if (fontWeight.value().contains("bold")) xssfFont.setBold(true);
    }
}
