package ru.durnov.HtmlConvertService.docx;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class TestCellSpan {

    @Test
    public void testCellSpanExample() throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFTable table1 = xwpfDocument.createTable(2,1);
        spancellacross(table1,0,0,6);
        xwpfDocument.write(new FileOutputStream("Test/docx/exampleSpan.docx"));
    }

    private void spancellacross(XWPFTable table, int rowNum, int colNum, int span) {
        XWPFTableCell cell = table.getRow(rowNum).getCell(colNum);
        cell.getCTTc().addNewTcPr().addNewGridSpan();
        cell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf((long)span));
    }
}
