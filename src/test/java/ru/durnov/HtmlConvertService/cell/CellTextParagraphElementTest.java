package ru.durnov.HtmlConvertService.cell;




import org.apache.poi.xssf.usermodel.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTextParagraphElementTest {
    private final String content = "<p>Камышников И.П.<br></p>";

    @Test
    public void testCellTextParagraphElement(){
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet();
        XSSFRow xssfRow = xssfSheet.createRow(1);
        XSSFCell xssfCell = xssfRow.createCell(1);
        Document document = Jsoup.parse(content);
        Elements allElements = document.body().getAllElements();
        allElements.remove(document.body());
        allElements.forEach(element -> {
            if (element.nodeName().equals("p")){
                new CellElementFactory(element, xssfCell).elementByName().addToXSSFCell();
            }
        });
        Assertions.assertEquals(xssfCell.getStringCellValue(), "Камышников И.П." + "\n");
    }

    @Test
    public void testPElementStructure(){
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet();
        XSSFRow xssfRow = xssfSheet.createRow(1);
        XSSFCell xssfCell = xssfRow.createCell(1);
        Document document = Jsoup.parse(content);
        Elements allElements = document.body().getAllElements();
        allElements.remove(document.body());
        allElements.forEach(element -> {
            if (element.nodeName().equals("p")){
                element.childNodes().forEach(node -> {
                    System.out.println(node.nodeName());
                    System.out.println("node is element " + (node.getClass() == Element.class));
                    if (node.nodeName().equals("#text")){
                        node.attributes().forEach(attribute -> {
                            System.out.println(attribute.getKey() + "=" + attribute.getValue());

                        });
                    }
                });
            }
        });
    }

}