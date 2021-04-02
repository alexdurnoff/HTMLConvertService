package ru.durnov.HtmlConvertService.altchunk;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/**
 * Класс создает новый PackagePart в OPCPackage с соответствующим именем.
 */
public class PackagePartWithPartName {
    private final String id;
    private final OPCPackage opcPackage;

    public PackagePartWithPartName(String id, OPCPackage opcPackage) {
        this.id = id;
        this.opcPackage = opcPackage;
    }

    /**
     * Возвращает новый PAckagePart
     * @return PackagePart part.
     * @throws InvalidFormatException - кидает исключение при неправильном формате
     */
    PackagePart packagePart() throws InvalidFormatException {
        PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id);
        return opcPackage.createPart(partName, "text/html");
    }
}
