package ru.durnov.HtmlConvertService.text;

import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

public class LabelTest {

    @Test
    public void testStructure(){
        String source = "<p style=\"text-align: center; \">\u200B<variable class=\"variable\" context=\"company_department_name\">\u200B<label>Название\n" +
                "      подразделения</label>\u200B</variable><span style=\"font-size: 18px;\"></span></p>";
        Jsoup.parse(source).body().getAllElements().forEach(element -> {
            System.out.println("nodeName is " + element.nodeName());
            System.out.println("text is " + element.text());
            element.attributes().forEach(attribute -> {
                System.out.println(attribute.getKey() + "=" + attribute.getValue());
            });
            if (element.nodeName().equals("label")) {
                System.out.println("label own text is " + element.ownText());
            }

        });
    }
}
