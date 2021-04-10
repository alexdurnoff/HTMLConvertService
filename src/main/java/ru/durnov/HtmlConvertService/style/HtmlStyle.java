package ru.durnov.HtmlConvertService.style;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import ru.durnov.HtmlConvertService.table.XlsxCellStyle;
import ru.durnov.HtmlConvertService.xlsx.XSSFRichTextStringPart;

import java.util.List;

public class HtmlStyle implements Style {
    protected final HtmlFont htmlFont;
    protected final HtmlAlignment htmlAlignment;
    protected final HtmlBackGround htmlBackGround;
    private final HtmlWidth htmlWidth;

    public HtmlStyle(Attributes attributes){
        this.htmlFont = new HtmlFont(
                new FontSize(attributes),
                new FontWeight(attributes)
        );
        this.htmlAlignment = new HtmlAlignment(attributes);
        this.htmlBackGround = new HtmlBackGround(attributes);
        this.htmlWidth = new HtmlWidth(attributes);
    }

    public HtmlStyle(HtmlFont htmlFont, HtmlAlignment htmlAlignment, HtmlBackGround htmlBackGround, HtmlWidth htmlWidth) {
        this.htmlFont = htmlFont;
        this.htmlAlignment = htmlAlignment;
        this.htmlBackGround = htmlBackGround;
        this.htmlWidth = htmlWidth;
    }

    @Override
    public Style withFont(HtmlFont font){
        return new HtmlStyle(font, this.htmlAlignment, this.htmlBackGround, this.htmlWidth);
    }

    @Override
    public Style withAlignment(HtmlAlignment alignment){
        return new HtmlStyle(this.htmlFont, alignment, this.htmlBackGround, this.htmlWidth);
    }

    @Override
    public Style withBackGround(HtmlBackGround backGround){
        return new HtmlStyle(this.htmlFont, htmlAlignment, backGround, this.htmlWidth);
    }

    @Override
    public Style withWidth(HtmlWidth htmlWidth) {
        return new HtmlStyle(this.htmlFont, this.htmlAlignment, this.htmlBackGround, htmlWidth);
    }

    @Override
    public HtmlFont font() {
        return this.htmlFont;
    }

    @Override
    public Style withAttributes(Attributes attributes) {
        Style htmlStyle1 = this;
        List<Attribute> attributeList = attributes.asList();
        for (Attribute attribute : attributeList) {
            if (attribute.getValue().contains("font-")){
                htmlStyle1 = htmlStyle1.withFont(
                        new HtmlFont(
                                new FontSize(attributes),
                                new FontWeight(attributes)
                        )
                );
            }
            if (attribute.getValue().contains("text-align")){
                htmlStyle1 = htmlStyle1.withAlignment(
                        new HtmlAlignment(attributes)
                );
            }
            if (attribute.getValue().contains("background-color")){
                htmlStyle1 = htmlStyle1.withBackGround(
                        new HtmlBackGround(attributes)
                );
            }
        }
        return htmlStyle1;
    }



    @Override
    public void applyToRun(XWPFRun xwpfRun) {
        xwpfRun.setFontFamily("Times new Roman");
        xwpfRun.setFontSize(this.htmlFont.fontSize().value());
        if (this.htmlFont.fontWeight().value().equals("bolder")) xwpfRun.setBold(true);
        XWPFParagraph xwpfParagraph = (XWPFParagraph) xwpfRun.getParent();
        xwpfParagraph.setAlignment(this.htmlAlignment.paragraphAlignment());
        if (!htmlBackGround.value().equals("auto"))xwpfRun.getCTR().addNewRPr().addNewHighlight().setVal(STHighlightColor.YELLOW);
    }

    @Override
    public void applyToXSSFCell(XSSFCell xssfCell, Element element) {
        XSSFRichTextString xssfRichTextString = xssfCell.getRichStringCellValue();
        int endIndex = xssfRichTextString.getString().length()-1;
        int startIndex= endIndex - element.text().length();
        new XSSFRichTextStringPart(
                element,
                xssfRichTextString
        ).applyStyle(this);
    }

    @Override
    public String toString() {
        return "HtmlStyle{" +
                "htmlFont=" + htmlFont +
                ", htmlAlignment=" + htmlAlignment +
                ", htmlBackGround=" + htmlBackGround +
                ", htmlWidth = " + htmlWidth +
                '}';
    }
}
