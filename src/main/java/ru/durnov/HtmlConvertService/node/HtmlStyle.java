package ru.durnov.HtmlConvertService.node;

import org.jsoup.nodes.Attribute;

public class HtmlStyle implements Style{
    private final Attribute attribute;

    public HtmlStyle(Attribute attribute){
        if (! attribute.getKey().equals("style")) throw new IllegalArgumentException("Attribute must be style");
        this.attribute = attribute;
    }


    @Override
    public HtmlFont font() {
        return new HtmlFont(attribute);
    }

    @Override
    public HtmlAlignment alignment() {
        return new HtmlAlignment(attribute);
    }

    @Override
    public HtmlBackGround backGround() {
        return new HtmlBackGround(attribute);
    }
}
