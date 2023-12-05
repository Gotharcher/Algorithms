//102103160
package Yandex.Algo_course.Sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
ПРИНЦИП РАБОТЫ
Требуется реализовать сортировку кучей. Как: при добавлении, добавляем в конец массива элемент и сеем вверх.
Для получения ответа, выводим первый элемент кучи, последний элемент ставим на место первого и сеем кучу вниз. Повторяем, пока куча не кончится.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Для удобства, опустим первый элемент массива, на котором реализована куча, и будем заполнять её с 1го индекса. Для каждого элемента, у него будет 2 потомка, по адресу (индекс*2), (индекс*2+1).
Для первого элемента, потомки 2й и 3й, для 2го - 4й и 5й, для 3го - 6й и 7й... и так далее.
Работа алгоритма строится на механизме просеивания кучи вверх и вниз при добавлении или удалении элемента.
При добавлении элемента, он добавляется на последний пустой элемент массива (lastIndex) и происходит просеивание вверх - определяется родитель текущего элемента, как lastIndex/2,
сравнивается с добавленным элементом, если родитель меньше - элементы меняются местами (новый элемент "всплывает"), и так вплоть до индекса 1. Так на вершине кучи оказывается наибольший элемент на текущий момент.
Поэтому, выводя ответ, максимальным элементом будет первый элемент массива.
После вывода первого элемента, необходимо переставить на его место последний элемент и просеять кучу вниз. Это снова обеспечит максимальный элемент в самом верху кучи.
Принцип просеивания вниз: новый_элемент (элемент из конца массива) сравнивается с левым и правым потомками, и, если потомок больше, они меняются местами.
И так далее, новый_элемент, с позиции потомка, снова сеется вниз, и так до конца массива. Таким образом, новый_элемент, если он меньше, "утонет" в куче, а сверху будет наибольший элемент.
Выводим этот элемент в ответ, и повторяем, до тех пор, пока куча не закончится.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Добавление занимает O(h), где h - глубина текущей кучи, которая пропорциональна размеру: log n (n - текущее число элементов), в последний элемент добавится за O(log N), где N - общее число элементов.
Изъятие занимает так же O(h), из-за повторного просеивания вниз.
В среднем, сложность изъятия и добавления каждого элемента O(log N/2).
Итоговая сложность: 2*N * O(log N/2) = O(N log N);
 */


/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Для хранения исходных данных требуется O(N), где N - число элементов. Дополнительных структур не создается.
Итоговая сложность: O(N).
 */


public class Sprint5FinalA {

    static PrintWriter pw;
    static int lastIndex = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int partsQty = Integer.parseInt(br.readLine());
        HeapParticipantElement[] partsHeap = new HeapParticipantElement[partsQty + 1];
        //Заполним кучу входными данными
        for (int i = 0; i < partsQty; i++) {
            String[] ss = br.readLine().split(" ");
            HeapParticipantElement newEle = new HeapParticipantElement(ss);
            partsHeap[lastIndex] = newEle;
            siftUp(partsHeap, lastIndex);
            lastIndex++;
        }
        //Высыпем кучу в упорядоченном виде (сразу на вывод)
        while (lastIndex > 1) {
            pw.println(partsHeap[1]);
            partsHeap[1] = partsHeap[lastIndex - 1];
            lastIndex--;
            siftDown(partsHeap, 1);
        }
        br.close();
        pw.close();
    }

    static int siftUp(HeapParticipantElement[] heap, int idx) {
        if (idx == 1) {
            return idx;
        }
        int hostIdx = idx / 2;
        HeapParticipantElement ele = heap[idx];
        if (heap[hostIdx].isLesser(ele)) {
            heap[idx] = heap[hostIdx];
            heap[hostIdx] = ele;
            return siftUp(heap, hostIdx);
        } else {
            return idx;
        }
    }

    static int siftDown(HeapParticipantElement[] heap, int idx) {
        HeapParticipantElement ele = heap[idx];
        int left = idx * 2;
        int right = idx * 2 + 1;
        if (left >= lastIndex) {
            return idx;
        } else {
            if (right >= lastIndex) {
                if (heap[left].isLesser(ele)) {
                    return idx;
                } else {
                    heap[idx] = heap[left];
                    heap[left] = ele;
                    return left;
                }
            } else {
                int maxIdx;
                if (heap[left].isLesser(heap[right])) {
                    maxIdx = right;
                } else {
                    maxIdx = left;
                }
                if (heap[maxIdx].isLesser(ele)) {
                    return idx;
                } else {
                    heap[idx] = heap[maxIdx];
                    heap[maxIdx] = ele;
                    return siftDown(heap, maxIdx);
                }
            }
        }
    }
}

class HeapParticipantElement implements Comparable<HeapParticipantElement> {
    public String name;
    public int solved, penalty;

    public HeapParticipantElement(String name, int solved, int penalty) {
        this.name = name;
        this.solved = solved;
        this.penalty = penalty;
    }

    public HeapParticipantElement(String[] dataStrings) {
        this(dataStrings[0], Integer.parseInt(dataStrings[1]), Integer.parseInt(dataStrings[2]));
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isLesser(HeapParticipantElement o) {
        return this.compareTo(o) < 0;
    }

    @Override
    public int compareTo(HeapParticipantElement o) {
        if (this.solved == o.solved) {
            if (this.penalty == o.penalty) {
                return o.name.compareTo(this.name);
            } else {
                return o.penalty - this.penalty;
            }
        } else {
            return this.solved - o.solved;
        }
    }
}
