package ru.durnov.HtmlConvertService.xlsx;

/***
 * Класс нужен для отслеживание и увеличения
 * текущего номера строки xlsx-таблицы.
 * Необходим для корректного объединения ячеек по вертикали.
 */
public class CurrentRowNumber {
    private int number;

    public void increaseRowNumber(int value){
        number += value;
    }

    public int rowNumber(){
        return number;
    }
}
