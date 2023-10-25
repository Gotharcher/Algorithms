//https://contest.yandex.ru/contest/23815/run-report/94362717/
//94362717

package Yandex.Algo_course.Sprint3;

/*
ПРИНЦИП РАБОТЫ
Для начала, опишем класс участников (Participant), имплементируем ему интерфейс Comparable и определим метод. Это позволит сортировать список
по нашим правилам, любой сортировкой.
После этого, реализуем быструю сортировку, которая оперирует интервалами, определяемыми индексами начала и конца рассматриваемого подмассива,
так алгоритм сможет отсортировать массив без выделения дополнительной памяти.
*/

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Для корректности работы алгоритма, надо доказать корректность работы сортировки и корректность работы компаратора.
Условия работы компаратора: Сначала идёт сравнение по кол-ву решенных задач (больше - лучше), потом по штрафу (меньше - лучше),
потом по имени (лексикографически). Первые два условия сравниваются простым вычитанием, третье - встроенным
String.compareTo (которое является результатом вычитания char).
Следующим шагом, рассмотрим корректность сортировки. Выбирается опорный элемент (произвольный, в данном случае, случайно выберем
элемент из рассматриваемого подмассива, чтобы не было возможности однозначно создать killer-sequence),
весь массив проходится с двух сторон, элементы по указателям сравниваются с опорным, если элемент слева больше, а справа меньше,
элементы меняются местами. В итоге, получается два логических подмассива, разделенные точкой встречи указателей, слева не превосходящие,
а справа не меньшие опорного элемента.
Алгоритм рекурсивно вызывается для двух подмассивов, от начала до середины и от середины до конца. Подмассивы определяются
индексами, дополнительные физические подмассивы не создаются.
*/

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
N - размер исходного массива.
В каждом проходе, массив разделяется на два промежутка, к которым сортировка применяется рекурсивно, в этом отличия от
классической быстрой сортировки нет, поэтому, временная сложность у данного алгоритма такая же - в среднем, O(N * log(N))
*/

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Дополнительных структур не используется, оперируем только указателями и выделяется отдельный элемент-буфер для swap() -> дополнительная сложность О(1),
исходный размер О(N) (N - число элементов в массиве), итоговая пространственная сложность O(N).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Sprint3FinalB {

    public static PrintWriter pw;
    public static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pQty = Integer.parseInt(br.readLine());
        Participant[] participants = new Participant[pQty];
        for (int i = 0; i < pQty; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            participants[i] = new Participant(st.nextToken(), st.nextToken(), st.nextToken());
        }

//        Проверим, как написан компаратор!
//        Arrays.sort(participants);

        inPlaceQuickSort(participants, 0, pQty - 1);

        for (Participant p : participants) {
            pw.println(p);
        }

        br.close();
        pw.close();
    }


    public static <T extends Comparable<T>> void inPlaceQuickSort(T[] arr, int startInput, int stopInput) {
        //выберем случайный индекс от начала подмассива до конца. Рандом генерирует подотрезок, без баунда.
        int randomIdx = startInput + rnd.nextInt(stopInput-startInput+1);
        T pivot = arr[randomIdx];
        int startIdx = startInput;
        int stopIdx = stopInput;
        while (startIdx < stopIdx) {
            while (arr[startIdx].compareTo(pivot) < 0) {
                startIdx++;
            }
            while (arr[stopIdx].compareTo(pivot) > 0) {
                stopIdx--;
            }
            if (startIdx <= stopIdx) {
                if (startIdx < stopIdx) { //Если указатели на одной позиции, менять не нужно
                    swap(arr, startIdx, stopIdx);
                }
                startIdx++;
                stopIdx--;
            }
        }

        //Рекурсия не будет вызываться, если остаточный массив из 1 элемента.
        if (startInput < stopIdx) {
            inPlaceQuickSort(arr, startInput, stopIdx);
        }
        if (startIdx < stopInput) {
            inPlaceQuickSort(arr, startIdx, stopInput);
        }
    }

    public static <T> void swap(T[] arr, int idxA, int idxB) {
        T buff = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = buff;
    }
}

class Participant implements Comparable<Participant> {
    public String name;
    public int solved;
    public int penalty;

    public Participant(String name, String solved, String penalty) {
        this.name = name;
        this.solved = Integer.parseInt(solved);
        this.penalty = Integer.parseInt(penalty);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Participant o) {
        if (this.solved == o.solved) {
            if (this.penalty == o.penalty) {
                return this.name.compareTo(o.name);
            } else {
                return this.penalty - o.penalty;
            }
        } else {
            return o.solved - this.solved;
        }
    }
}