package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

public class XlsxPackagePartWithPartName extends PackagePartWithPartName{
    public XlsxPackagePartWithPartName(String id, OPCPackage aPackage) {
        super(id, aPackage);
    }

    /**
     * Возвращает новый PackagePart
     *
     * @return PackagePart part.
     * @throws InvalidFormatException - кидает исключение при неправильном формате
     */
    @Override
    PackagePart packagePart() throws InvalidFormatException {
        PackagePartName partName = PackagingURIHelper.createPartName("/excel/" + id);
        return opcPackage.createPart(partName, "text/html");
    }
}
