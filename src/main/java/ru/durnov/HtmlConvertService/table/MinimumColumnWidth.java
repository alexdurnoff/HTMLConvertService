package ru.durnov.HtmlConvertService.table;

/**
 * Класс определяет минимальную ширину столбца
 * в xlsx-таблице.
 */
public class MinimumColumnWidth {
    private final String contentText;

    public MinimumColumnWidth(String contentText) {
        this.contentText = contentText;
    }

    public int columnLength() {
        String[] lines;
        if (contentText.contains("\n")){
            lines = contentText.split("\n");
        } else {
            lines = contentText.split(" ");
        }
        int length = 15;
        for (String line : lines){
            if (line.length() > length) length = line.length();
        }
        return (length + 2) * 256;
    }
}
