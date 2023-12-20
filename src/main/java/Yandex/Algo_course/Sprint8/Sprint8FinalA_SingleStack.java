//103435526
//https://contest.yandex.ru/contest/26133/run-report/103435526/

/*
ПРИНЦИП РАБОТЫ
Распаковать первую строку, поместить её в массив символов для сравнения.
Для каждой следующей строки, распаковать её и сравнить посимвольно с массивом сравнений, до позиции окончания совпадений. Если символ не совпал - его позиция является окончанием совпадений.
После обработки всех строк, вывести ответ: массив символов сравнения с 0 до позиции окончания совпадений.

L - максимальная длина строки, N - число строк
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Доказательство поиска общего префикса: если сравнить каждую строку посимвольно с первой, то за N сравнений получим максимальный префикс: это будет
первые M символов массива сравнений (первой строки), где M - минимальная общая позиция символа, который совпадает для массива сравнений и каждой строки.

Основная сложность в распаковке строк, чтобы сравнивать запакованные строки, надо их распаковать.
Важным моментом является то, что множитель - однозначное число, то есть не надо обрабатывать последовательность чисел. Поэтому, открывающие скобки не важны для обработки -
если идут два числа подряд, то они не требуют отдельной обработки, и последовательно перемножают набранный массив символов.

Запакованную строку посимвольно добавляем в стек.
Если это символ - просто добавляем, если число - тоже просто добавляем. Открывающую скобку игнорируем.
В случае встречи закрывающей скобки, начинаем разворачивать стек, записывая символы в промежуточный Лист, пока не достанем из него число.
Достав число (K), K раз возвращаем чары из _перевернутого_ Листа обратно в стек. Так как, по условию, ЗС - корректная, то каждому чару-числу соответствует одна "]".
Таким образом, все числа из стека уйдут, заменившись на повторы символов.
Символы в стеке, в обратном порядке, являются распакованной строкой. Нужно её записать в массив сравнений, если она первая, или сравнить с массивом сравнений.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Для каждой строки, N, необходимо прочитать и распаковать её. Хоть распаковка происходит перезаполнением стека, его число обходов конечно и зависит от длины строки: L
Каждую строку сравнить с массивом сравнений (худший вариант - все строки одинаковые и максимально длинные): N*L
Вывести ответ: L
Итоговая сложность: O(N*L)
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Массив символов-совпадений: L, текущая сравниваемая строка L, её стек распаковки L, вспомогательные структуры аналогичного размера.
Итоговая сложность: O(L)
 */

package Yandex.Algo_course.Sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//0 = 48, 9 = 57
//a = 97, z = 122
//[ = 91, ] = 93

public class Sprint8FinalA_SingleStack {
    static final char LOW_A = 'a';
    static final char ZERO_CHAR = '0';
    static final char NINE_CHAR = '9';
    static final char OPEN_BRACKET = '[';
    static final char CLOSE_BRACKET = ']';
    static final int MAX_SIZE = 100000;
    static char[] prefixString;
    static int prefLen = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());

        //По первой строке соберем маску-массив
        List<Character> thisCharactersList = readString(br.readLine());
        prefLen = thisCharactersList.size();
        prefixString = new char[prefLen];
        for (int i = 0; i < prefLen; i++) {
            prefixString[i] = thisCharactersList.get(i);
        }

        //Каждую следующую строку сравниваем с маской-префиксом, если нашли различия - отрезаем ограничитель до размера
        for (int s = 1; s < rows; s++) {
            thisCharactersList = readString(br.readLine());
            for (int i = 0; i < prefLen; i++) {
                if (prefixString[i] != thisCharactersList.get(i)) {
                    prefLen = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefLen; i++) {
            sb.append(prefixString[i]);
        }
        System.out.println(sb);
    }

    public static List<Character> readString(String s) {
        char[] ca = s.toCharArray();
        Deque<Character> charSeq = new ArrayDeque<>();
        for (int ci = 0; ci < ca.length; ci++) {
            char currChar = ca[ci];
            if (currChar >= LOW_A) {
                charSeq.push(currChar);
            } else if (charIsDigit(currChar)) {
                charSeq.push(currChar);
            } else if (currChar == OPEN_BRACKET) {
                //а не интересны они, перед ней всегда число, а число всегда однозначное
            } else if (currChar == CLOSE_BRACKET) {
                unpackStack(charSeq);
            }
        }
        List<Character> ans = new ArrayList<>(MAX_SIZE);
        while (!charSeq.isEmpty()) {
            ans.add(charSeq.pollLast());
        }
        return ans;
    }

    public static void unpackStack(Deque<Character> deq) {
        List<Character> charseq = new ArrayList<>();
        char c = deq.pop();
        while (!charIsDigit(c)) {
            charseq.add(c);
            c = deq.pop();
        }
        Collections.reverse(charseq);
        for (int i = 0; i < Character.getNumericValue(c); i++) {
            for (char cl : charseq) {
                deq.push(cl);
            }
        }
    }

    public static boolean charIsDigit(char c) {
        return c >= ZERO_CHAR && c <= NINE_CHAR;
    }

}