package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attributes;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;
import ru.durnov.HtmlConvertService.style.HtmlFont;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public interface Style {
   HtmlStyle withFont(HtmlFont font);

   HtmlStyle withAlignment(HtmlAlignment alignment);

   HtmlStyle withBackGround(HtmlBackGround backGround);

   HtmlStyle withAttributes(Attributes attributes);

   void applyToRun(XWPFRun xwpfRun);
}
