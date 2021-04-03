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
        String[] words = contentText.split(" ");
        int length = 15;
        for (String word : words){
            if (word.length() > length) length = word.length();
        }
        return (length + 2) * 256;
    }
}
