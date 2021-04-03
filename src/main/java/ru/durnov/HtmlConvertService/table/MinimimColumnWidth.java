package ru.durnov.HtmlConvertService.table;

/**
 * Класс определяет минимальную ширину столбца
 * в xlsx-таблице.
 */
public class MinimimColumnWidth {
    private final String contentText;

    public MinimimColumnWidth(String contentText) {
        this.contentText = contentText;
    }

    public int columnLength() {
        String[] words = contentText.split(" ");
        int length = 15;
        for (String word : words){
            if (word.length() > length) length = words.length;
        }
        return length;
    }
}
