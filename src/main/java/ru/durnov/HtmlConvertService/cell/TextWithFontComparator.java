package ru.durnov.HtmlConvertService.cell;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Компаратор для упорядочивания TextWithFont в списке.
 * Смотрит на исходную строку текста и упорядочивает по ней ней
 */
public class TextWithFontComparator implements Comparator<TextWithFont> {
    private final String elementText;
    private final List<Integer> indexList = new ArrayList<>();

    public TextWithFontComparator(String elementText) {
        this.elementText = elementText;
    }

    public TextWithFontComparator(Element element){
        this.elementText = element.text();
    }


    @Override
    public int compare(TextWithFont textWithFont1, TextWithFont textWithFont2) {
        int index1 = indexByTextFont(textWithFont1, elementText);
        int index2 = indexByTextFont(textWithFont2, elementText);
        return Integer.compare(index1, index2);
    }

    private int indexByTextFont(TextWithFont textWithFont, String string) {
        int index = textWithFont.index(elementText);
        if (indexList.contains(index)) {
            try {
                return indexByTextFont(textWithFont, string.substring(index + 1));
            } catch (IndexOutOfBoundsException e) {
                return string.length()-1;
            }
        }
        return index;
    }
}
