package ru.durnov.HtmlConvertService.cell;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;

@Slf4j
public class CellStrongParargaphElement extends CellTextParagraphElement{
    public CellStrongParargaphElement(Element element, XSSFCell xssfCell) {
        super(element, xssfCell);
    }

    @Override
    public void addToXSSFCell() {
        log.debug("strong paragraph element is " + element.nodeName());
        log.debug("strong paragraph element text is " + element.ownText());
        super.addToXSSFCell();
        new XSSFRichStringStrongStyle(element,xssfCell).applyToXSSFRichTextString();
    }
}
