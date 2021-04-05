package ru.durnov.HtmlConvertService.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.durnov.HtmlConvertService.entity.Record;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DocumentRepository implements ru.durnov.HtmlConvertService.dao.Repository {
    private final Logger logger = LogManager.getLogger(DocumentRepository.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DocumentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Record findContentById(String id) {
        return this.jdbcTemplate.queryForObject(
                "select id, content from checkup_documents where id = ?",
                this::mapRowToRecord
        );
    }

    private Record mapRowToRecord(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Record(
                resultSet.getString("id"),
                resultSet.getString("content")
        );
    }
}
