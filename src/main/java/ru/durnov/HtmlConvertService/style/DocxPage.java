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
        if (orientation.equalsIgnoreCase("portrait")) return 842;//было 842
        return 1190;
    }

    @Override
    public int heigth() {
        if (orientation.equalsIgnoreCase("portrait")) return 1190;//было 1190
        return 842;
    }
}
