package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;
import ru.durnov.HtmlConvertService.style.HtmlFont;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public interface Style {
   Style withFont(HtmlFont font);

   Style withAlignment(HtmlAlignment alignment);

   Style withBackGround(HtmlBackGround backGround);

   Style withAttributes(Attributes attributes);

   Style withWidth(HtmlWidth htmlWidth);

   HtmlFont font();

   void applyToRun(XWPFRun xwpfRun);

}
