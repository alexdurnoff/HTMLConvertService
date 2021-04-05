package ru.durnov.HtmlConvertService.entity;

public class Request {
    private final String id;
    private final String type;
    private final String orientation;

    public Request(String id, String type, String orientation) {
        this.id = id;
        this.type = type;
        this.orientation = orientation;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getOrientation() {
        return orientation;
    }
}
