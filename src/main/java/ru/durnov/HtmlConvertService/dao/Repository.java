package ru.durnov.HtmlConvertService.dao;

import ru.durnov.HtmlConvertService.entity.Record;

public interface Repository {
    Record findContentById(String id);
}
