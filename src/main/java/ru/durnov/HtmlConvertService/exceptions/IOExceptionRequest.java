package ru.durnov.HtmlConvertService.exceptions;

import ru.durnov.HtmlConvertService.entity.Request;
import ru.durnov.HtmlConvertService.entity.Response;

import java.time.LocalDateTime;

/**
 * Такой ответ мывозвращаем при ошибках чтения-запсии
 */
public class IOExceptionRequest extends Response {
    private final Request request;
    public IOExceptionRequest(Request request) {
        super("timestamp:'\"'" + LocalDateTime.now().toString() + '"'
                + ",\"status\":500," + "error\":\"Internal Server Error\""
                + "message\":\"Ошибка чтения-записи файла\",\"path:\"/\""
                + ":" + request.toString());
        this.request = request;
    }

    @Override
    public String toString() {
        return "timestamp:'\"'" + LocalDateTime.now().toString() + '"'
                + ",\"status\":500," + "error\":\"Internal Server Error\""
                + "message\":\"Ошибка чтения-записи файла\",\"path:\"/\""
                + ":" + request.toString();
    }
}
