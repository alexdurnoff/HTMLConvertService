package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * XSSFWorkBook с вложенной частью.
 */
public class XSSFBookWithPackagePart {
    private final String content;
    private final String id;
    private final XSSFWorkbook xssfWorkbook;
    private final XSSFSheet xssfSheet;

    public XSSFBookWithPackagePart(String content) {
        this.content = content;
        this.id = "htmlDoc1.html";
        this.xssfWorkbook = new XSSFWorkbook();
        this.xssfSheet = this.xssfWorkbook.createSheet();
    }

    public XSSFBookWithPackagePart(String content, XSSFWorkbook xssfWorkbook){
        this.content = content;
        int number = 1;
        try {
            {
                number = xssfWorkbook.getPackage().getParts().size() + 1;
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        this.id = "htmlDoc" + number + ".html";
        this.xssfWorkbook = xssfWorkbook;
        this.xssfSheet = this.xssfWorkbook.createSheet();
    }

    public XSSFWorkbook xssfWorkbook() throws InvalidFormatException, IOException {
        XWPFHtmlDocumentPart xwpfHtmlDocumentPart =
                new XWPFHtmlDocumentPart(
                        new XlsxPackagePartWithPartName(
                                id,
                                xssfWorkbook.getPackage()
                        ).packagePart(),
                        content,
                        id
                );
        xssfSheet.addRelation(id, new XSSFHtmlRelation(), xwpfHtmlDocumentPart);
        return xssfWorkbook;
    }
}
