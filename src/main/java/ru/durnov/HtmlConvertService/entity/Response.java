package ru.durnov.HtmlConvertService.entity;

public class Response {
    protected final String url;

    public Response(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
