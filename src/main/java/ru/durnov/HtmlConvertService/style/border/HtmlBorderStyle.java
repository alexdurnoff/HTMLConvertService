package ru.durnov.HtmlConvertService.style.border;

import org.apache.poi.ss.usermodel.BorderStyle;

public class HtmlBorderStyle {
    private final String value;
    private int weight;

    public HtmlBorderStyle(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public HtmlBorderStyle(BorderAttribute borderAttribute){
        this.value = borderAttribute.borderStyle();
        String weightString = borderAttribute.weight();
        try {
            this.weight = Integer.parseInt(weightString.substring(0,weightString.length()-2));
        } catch (NumberFormatException e) {
            this.weight = 0;
        }
    }

    public BorderStyle borderStyle() {
        if (value.equals("dotted")) {
            return BorderStyle.DOTTED;
        }
        if (value.equals("solid")){
            if (weight < 2) return BorderStyle.THIN;
            if (weight < 4) return BorderStyle.MEDIUM;
            return BorderStyle.THICK;
        }
        if (value.equals("double")){
            return BorderStyle.DOUBLE;
        }

        if (value.equals("groove")){
            return BorderStyle.MEDIUM;
        }

        if (value.equals("ridge")) return BorderStyle.THIN;

        if (value.equals("inset")) return BorderStyle.MEDIUM;

        if (value.equals("outset")) return BorderStyle.MEDIUM;

        if (weight != 0) {
            if (weight < 2) return BorderStyle.THIN;
            if (weight < 4) return BorderStyle.MEDIUM;
            return BorderStyle.THICK;
        }
        return BorderStyle.NONE;
    }
}
