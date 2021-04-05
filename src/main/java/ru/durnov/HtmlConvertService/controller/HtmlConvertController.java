package ru.durnov.HtmlConvertService.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.durnov.HtmlConvertService.docx.OutputDocument;
import ru.durnov.HtmlConvertService.entity.Request;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HtmlConvertController {

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String convertDocument(@RequestBody Request request) throws IOException, InvalidFormatException {
        OutputDocument outputDocument = new OutPutDocumentFromRequest(request).document();
        String filePath = new StringFilePathFromRequest(request).filePath();
        outputDocument.save();
        return filePath;
    }
}
