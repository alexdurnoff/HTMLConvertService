package ru.durnov.HtmlConvertService.node;

/**
 * Пустая имплементация, которая ничего не пишет в документ,
 * чтобы не плодить null и NPE.
 */
public class EmptyElement implements DocxElement {
    @Override
    public void addToXWPFDocument() {

    }
}
