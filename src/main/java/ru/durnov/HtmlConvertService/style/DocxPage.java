package ru.durnov.HtmlConvertService.style;

/**
 * Параметры старницы документа .docx.
 * Возвращает ширину и высоту. Возвращаемые значения зависят от ориентации.
 */
public class DocxPage implements Page{
    private final String orientation;

    /**
     * Если в конструктор пришло не "portrait",
     * всегда возвращаеь параметры страницы landscape.
     * @param orientation - ориентация страницы
     */
    public DocxPage(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public int width() {
        if (orientation.equals("portrait")) return 1080;//было 842
        return 1920;
    }

    @Override
    public int heigth() {
        if (orientation.equals("portrait")) return 1920;//было 1190
        return 1080;
    }
}
