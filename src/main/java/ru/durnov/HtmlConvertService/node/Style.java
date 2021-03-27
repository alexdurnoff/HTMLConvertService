package ru.durnov.HtmlConvertService.node;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import ru.durnov.HtmlConvertService.style.HtmlAlignment;
import ru.durnov.HtmlConvertService.style.HtmlBackGround;
import ru.durnov.HtmlConvertService.style.HtmlStyle;

public interface Style {
   HtmlStyle withFont(HtmlFont font);

   HtmlStyle withAlignment(HtmlAlignment alignment);

   HtmlStyle withBackGround(HtmlBackGround backGround);

   void applyToRun(XWPFRun xwpfRun);
}
