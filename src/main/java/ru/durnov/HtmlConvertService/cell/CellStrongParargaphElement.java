package ru.durnov.HtmlConvertService.cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jsoup.nodes.Element;
import ru.durnov.HtmlConvertService.style.HtmlStyle;
import ru.durnov.HtmlConvertService.style.StrongFontStyle;

public class CellStrongParargaphElement extends CellTextParagraphElement{
    public CellStrongParargaphElement(Element element, XSSFCell xssfCell) {
        super(element, new StrongFontStyle(new HtmlStyle(element.attributes())), xssfCell);
    }

    public CellStrongParargaphElement(Element element, HtmlStyle htmlStyle, XSSFCell xssfCell){
        super(element, new StrongFontStyle(htmlStyle), xssfCell);
    }
}
