package ru.durnov.HtmlConvertService.exceptions;

import ru.durnov.HtmlConvertService.entity.Request;
import ru.durnov.HtmlConvertService.entity.Response;

import java.time.LocalDateTime;

/**
 * Такой ответ мы возвращаем при некорректном формате входного файла.
 */
public class MailHtmlFormatExceptionRequest extends Response {
    private final Request request;

    public MailHtmlFormatExceptionRequest(String url, Request request) {
        super(url);
        this.request = request;
    }

    @Override
    public String toString() {
        return "timestamp:'\"'" + LocalDateTime.now().toString() + '"'
                + ",\"status\":500," + "error\":\"Internal Server Error\""
                + "message\":\"Некорректный формат html-файла\",\"path:\"/\""
                + ":" + request.toString();
    }
}
