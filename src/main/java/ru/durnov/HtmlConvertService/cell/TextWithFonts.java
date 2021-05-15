package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

@Slf4j
/**
 * Класс должен изъять из элемента список TextWithFont.
 * Упорядочивается по компаратору.
 */
public class TextWithFonts {
    private final Element element;
    private final XSSFFont font;
    private final XSSFCell xssfCell;
    private final List<TextWithFont> textWithFontList = new ArrayList<>();

    public TextWithFonts(Element element, XSSFFont font, XSSFCell xssfCell) {
        this.element = element;
        this.xssfCell = xssfCell;
        this.font = new XSSFFontFromElement(
                element,
                font,
                xssfCell
        ).xssfFont();
    }

    public List<TextWithFont> list() {
        if (!element.ownText().equals("")) this.textWithFontList.add(new TextWithFont(element.ownText(), font));
        List<Node> nodeList = element.childNodes();//Именно так, иначе не получается рекурсии, почему-то...
        for (Node node : nodeList) {
            if (node instanceof Element){
                Element element1 = (Element) node;
                XSSFFont xssfFont = new XSSFFontFromElement(
                        element1,
                        font,
                        xssfCell
                ).xssfFont();
                this.textWithFontList.addAll(new TextWithFonts(element1, xssfFont, xssfCell).list());
            }
        }
        this.textWithFontList.sort(new TextWithFontComparator(element.text()));
        return this.textWithFontList;
    }
}
