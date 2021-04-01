package ru.durnov.HtmlConvertService.text;

/**
 * Пустая имплементация, которая ничего не пишет в документ,
 * чтобы не плодить null и NPE.
 */
public class EmptyParagraphElement implements DocxParagraphElement {
    @Override
    public void addToXWPFDocument() {

    }
}
