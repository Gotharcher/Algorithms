//https://contest.yandex.ru/contest/23815/run-report/93737819/
//93737819

package Yandex.Algo_course.Sprint3;

/*
ПРИНЦИП РАБОТЫ
Пояснение: точка "перелома" - позиция, где в "изначальном массиве" находилась позиция "нуля". В обычном массиве находится между последним и первым элементом.
В основе реализованного алгоритма используется рекурсивный бинарный поиск. Ключевым отличием является то, что у данного массива
есть точка "перелома" внутри, то для того, чтобы однозначно решить, в какую сторону "обрезать" поиск (в отличие от классического бинарного,
в котором слева меньше — справа больше), необходимо учесть положение точки перелома.
*/

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Для классического бинарного поиска примем, что алгоритм является доказанным.
Определяя опорный элемент, проверяем, с какой стороны от него находится точка перелома.
Детально рассмотрим следующий случай: если последний элемент больше опорного - перелом слева опорного элемента.
В таком случае, однозначно, все значения, меньше опорного элемента находятся слева от него (от опорного до перелома). Вызываем рекурсивно
функцию для левого интервала.
В случае со значениями бОльше опорного, они находятся как справа, так и слева от опорного (через 0, до точки перелома), а значит,
для определения отрезка, на котором находится искомый элемент, необходимо сравнить искомый элемент с элементом в конце массива.
Если элемент бОльше опорного, но меньше или равен последнему элементу массива - он справа от опорного, иначе - слева.
Определив интервал, в котором лежит искомый элемент, рекурсивно вызываем функцию для соответствующего интервала.

Для случая, когда перелом справа от опорного элемента (последний элемент меньше опорного), ситуация зеркальна - в случае, если
необходимо получить значения, больше опорного элемента - они от него до перелома, а если меньше - они лежат как слева (от 0 до опорного),
так и справа - от перелома до конца. Определяем нужный интервал, сравнивая первый элемент массива с искомым.

Корректность выхода из рекурсии - Каждая итерация уменьшает интервал проверки в 2 раза.
Если размер интервала проверки не превосходит 2 - проверяем оба элемента на равенство искомому.
*/

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
На каждом шаге размер обрабатываемого массива уменьшается в 2 раза, в худшем, последнем, случае останется проверить 2 соседних элемента.
Таким образом, временная сложность O(log N), где N - число элементов в массиве.
*/

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Дополнительных структур не используется, бинарный поиск оперирует только указателями. Дополнительная сложность О(1),
исходный размер О(N) (N - число элементов в массиве), итоговая пространственная сложность O(N).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint3FinalA {
    public static int brokenSearch(int[] arr, int k) {
        return locateSequence(arr, k, 0, arr.length - 1);
    }

    public static int locateSequence(int[] arr, int k, int start, int stop) {
        if (stop - start <= 1) {
            if (arr[start] == k) {
                return start;
            } else if (arr[stop] == k) {
                return stop;
            } else {
                return -1;
            }
        }
        int midPos = start + (stop - start) / 2;

        if (arr[midPos] == k) {
            return midPos;
        } else {
            if (arr[stop] < arr[midPos]) { //Перелом справа от опорного
                if (k > arr[midPos]) { // элемент справа от опорного, до перелома
                    start = midPos;
                } else { //элемент слева от опорного, может быть через "0"
                    //сравним с началом массива
                    if (k >= arr[start]) { // элемент от 0 до центра.
                        stop = midPos;
                    } else {//элемент за нулём, у перелома
                        start = midPos;
                    }
                }
            } else { //перелом слева от опорного
                if (k < arr[midPos]) { //элемент где-то от опорного до перелома
                    stop = midPos;
                } else { //элемент справа от опорного, может быть через "0"
                    //сравним с началом массива
                    if (k > arr[stop]) { // элемент от 0 до центра.
                        stop = midPos;
                    } else {//элемент за нулём, у перелома
                        start = midPos;
                    }
                }
            }
            return locateSequence(arr, k, start, stop);
        }
    }

    private static void test() {
//        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
//        System.out.println(brokenSearch(arr, 5));
    }

    //psvm для отладки
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        System.out.println(Sprint3FinalA.brokenSearch(arr, k));
    }
}
