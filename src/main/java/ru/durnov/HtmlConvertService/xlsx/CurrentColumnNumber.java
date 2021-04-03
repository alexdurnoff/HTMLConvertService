package ru.durnov.HtmlConvertService.xlsx;

/***
 * Класс нужен для отслеживание и увеличения
 * текущего номера столбца xlsx-таблицы.
 * Необходим для корректного объединения ячеек.
 */
public class CurrentColumnNumber {
    private int number;

    public void increaseColumnNumber(int value){
        number += value;
    }

    public int columnNumber(){
        return number;
    }

}
