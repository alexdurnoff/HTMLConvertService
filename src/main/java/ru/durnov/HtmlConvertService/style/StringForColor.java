package ru.durnov.HtmlConvertService.style;

/**
 * По задумке класс должен преобразовывать значение
 * строки цвета в шестнадцатеричную строку для последующей конкатенации.
 */
public class StringForColor {
    private final int value;

    public StringForColor(int value){
        this.value = value;
    }

    public StringForColor(String stringValue){
        try {
            this.value = Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid string value for StringForColor");
        }
    }

    public String colorString(){
        return String.format("%2s", Integer.toHexString(value)).replace(' ', '0');
    }

}
