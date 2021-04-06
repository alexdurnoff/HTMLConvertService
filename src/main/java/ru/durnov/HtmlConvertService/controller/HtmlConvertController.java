package ru.durnov.HtmlConvertService.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.durnov.HtmlConvertService.entity.Request;
import ru.durnov.HtmlConvertService.entity.Response;


import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(path = "/", produces = "application/json")
public class HtmlConvertController {

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response convertDocument(@RequestBody Request request) throws ResponseStatusException{
        log.info(request.toString());
        try {
            request.document().save();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка чтения-записи",e);
        } catch (InvalidFormatException e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Некорректный формат html-файла",e);
        }
        return request.response();
    }


}
