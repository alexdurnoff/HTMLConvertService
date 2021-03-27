package ru.durnov.HtmlConvertService.internet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonRequestConvertioBody {
    @JsonProperty
    private final String apiKey = "46116ded0e9e8591ff483d07aab54d50";
    @JsonProperty
    private final String outPutFormat = "docx";
    @JsonProperty
    private final String fileContent;
    @JsonProperty
    private final OptionsCallBack optionsCallBack;


    public JsonRequestConvertioBody(String fileContent, OptionsCallBack optionsCallBack) {
        this.fileContent = fileContent;
        this.optionsCallBack = optionsCallBack;
    }

    public String body() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("Test/tmp.json"), this);
        String json = Files.readString(Path.of("Test/tmp.json"));
        Files.delete(Path.of("Test/tmp.json"));
        System.out.println(json);
        return json;
    }
}
