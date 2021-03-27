package ru.durnov.HtmlConvertService.internet;


import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionsCallBack {
    @JsonProperty
    private final String callback_url;

    public OptionsCallBack(String callback_url) {
        this.callback_url = callback_url;
    }

}
