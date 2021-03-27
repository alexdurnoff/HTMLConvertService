package ru.durnov.HtmlConvertService;

import org.junit.jupiter.api.Test;
import ru.durnov.HtmlConvertService.internet.JsonRequest;
import ru.durnov.HtmlConvertService.internet.JsonRequestConvertioBody;
import ru.durnov.HtmlConvertService.internet.OptionsCallBack;

import java.io.IOException;

public class TestConvertioService {

    @Test
    public void testConvertioService1() throws IOException, InterruptedException {
        JsonRequest jsonRequest = new JsonRequest(
                new JsonRequestConvertioBody(
                        "Test/4.html",
                        new OptionsCallBack(
                                "Test/docx/convertio1.docx"
                        )
                )
        );
        jsonRequest.sendRequest();
    }
}
