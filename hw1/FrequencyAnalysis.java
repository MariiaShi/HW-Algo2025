package hw1;
// Задача частотного анализа строки заключается в подсчете количества вхождений каждого символа в заданной строке. Это полезно во многих областях, например, в криптографии, лингвистике и сжатии данных.
//Формулировка задачи:
//Дана строка s, состоящая из латинских букв. Необходимо определить, сколько раз встречается каждая буква в этой строке.
//Входной формат:
//Строка s, содержащая только символы букв латинского алфавита в любом регистре (a-z A-Z). Строка может быть пустой.
//Выходной формат:
//Выведите встречающиеся символы в строке с указанием их количества.
//Пример:
//"АbraСadabra"
//Результат:
//a - 5
//b - 2
//r - 2
//c - 1
//d - 1
//
//
//Важно! При подсчете не учитывается регистр, a и A - одинаковые.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyAnalysis {
    public static void main(String[] args) {

        String s = "AbraCadabra";

        // Приводим строку к нижнему регистру
        s = s.toLowerCase();

        // Используем HashMap для хранения частоты символов
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Подсчет количества вхождений каждого символа
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Создаем список записей для сортировки по алфавиту
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        // Вывод результата
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}



