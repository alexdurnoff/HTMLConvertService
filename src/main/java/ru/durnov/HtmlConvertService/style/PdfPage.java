package ru.durnov.HtmlConvertService.style;

/**
 * Параметры старницы документа .pdf.
 * Возвращает ширину и высоту. Возвращаемые значения зависят от ориентации.
 */
public class PdfPage implements Page {
    private final String orientation;

    /**
     * Если в конструктор пришло не "portrait",
     * всегда возвращаеь параметры страницы landscape.
     * @param orientation - ориентация страницы
     */
    public PdfPage(String orientation) {
        this.orientation = orientation;
    }



    @Override
    public int width() {
        if (orientation.equalsIgnoreCase("portrait")) return 1080;//было 842
        return 1920;
    }

    @Override
    public int height() {
        if (orientation.equalsIgnoreCase("portrait")) return 1920;//было 1190
        return 1080;
    }
}
