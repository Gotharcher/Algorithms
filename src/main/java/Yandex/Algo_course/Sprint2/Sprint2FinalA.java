//92798984
//https://contest.yandex.ru/contest/22781/run-report/92798984/

//Как удобнее, посылку номером или ссылкой?

package Yandex.Algo_course.Sprint2;

/*
-- ПРИНЦИП РАБОТЫ --
По условиям задачи, необходимо реализовать дек на кольцевом буфере. Принцип работы дека схож с принципом работы кольцевой очереди:
задается максимальный размер буфера, который представляет собой массив заранее определенной длины, и два индекса-указателя, на начало и конец очереди.
При добавлении элемента, элементу массива с текущим индексом-указателем (не важно, с начала или конца) присваивается входное значение, индекс-указатель увеличивается на 1,
общий счётчик элементов увеличивается на 1.
При удалении элемента, индекс-указатель уменьшается на 1 и возвращается элемент индексу (аналогично, не важно, с начала или с конца,
принцип работы обоих указателей идентичен). Общий счетчик элементов уменьшается на 1.
Общий счетчик нужен для того, чтобы не перезаписать "нужное значение" (при добавлении элемента с номером бОльшим, чем размер буфера), а так же чтобы не вернуть "удаленное значение",
так как при удалении, удаляется только понятие "адреса" элемента, само значение в массиве-буфере остается.
 */

/*
-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Дек - структура, которая работает по принципу FIFO по направлению голова-хвост, т.е. для первого добавленного с Головы элемента, он первым выйдет с Хвоста, и наоборот.
Моя структура реализована как представление двух очередей, направленных в разные стороны - голова первой является хвостом второй, и наоборот.
Таким образом, доказательство корректности моего Дека на кольцевом буфере можно свести к доказательству корректности обычной очереди на кольцевом буфере.
Перед добавлением/удалением, происходит проверка количества элементов и сравнение с максимальным размером - это гарантирует, что не будет добавлено элементов больше размера дека -
а значит, не будет потери данных, а так же не будет удалён элемент из пустой очереди - индексы не сдвинутся, и не будет возвращено значение из предыдущих итераций очереди.
При добавлении элемента в очередь, по индексу Головы добавляется значение, индекс сдвигается в обратную сторону от Хвоста, и указывает на свободный элемент массива.
При удалении элемента, Хвост сдвигается к Голове на 1 и возвращается значение по индексу Хвоста. Это является реализацией принципа FIFO.
Для "обратной" очереди порядок действий такой же - добавление происходит по Хвосту, удаление - по Голове.
 */

/*
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Обращение к ячейке массива по индексу занимает константное время. Массив определяется один раз, при создании. Реаллокация массива не происходит.
Размер деки хранится в отдельном значении, проверка размера и заполненности деки -> константное значение.
Сравнивающие и арифметические операции над переменными выполняются за константное время.
Таким образом, временная сложность для работы с декой: записи, удаления - О(1).
Полное время выполнения программы - О(N), где N - число входных команд. [дописал эту строку после формирования посылки]
 */

/*
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для реализации дека требуется 4 вспомогательных значения - индекс головы, индекс хвоста, размер буфера, количество элементов в деке.
И сам кольцевой буфер, размером N - максимальный размер дека.
Соответственно, пространственная сложность реализации 4+N => O(N)
 */


//Дек на кольце

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Sprint2FinalA {

    static final String PUSH_FRONT = "push_front";
    static final String PUSH_BACK = "push_back";
    static final String POP_FRONT = "pop_front";
    static final String POP_BACK = "pop_back";

    static final String ERROR_MESSAGE = "error";

    public static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commands = Integer.parseInt(br.readLine());
        int maxSize = Integer.parseInt(br.readLine());
        MyDeque mdq = new MyDeque(maxSize);
        for (int i = 0; i < commands; i++) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                //свитч по-разному работает в разных Джавах.
                if (PUSH_FRONT.equals(command)) {
                    mdq.pushFront(Integer.parseInt(st.nextToken()));
                } else if (PUSH_BACK.equals(command)) {
                    mdq.pushBack(Integer.parseInt(st.nextToken()));
                } else if (POP_FRONT.equals(command)) {
                    pw.println(mdq.popFront());
                } else if (POP_BACK.equals(command)) {
                    pw.println(mdq.popBack());
                }
            } catch (IllegalStateException | NoSuchElementException ex) {
                pw.println(ERROR_MESSAGE);
//            } catch (NoSuchElementException ex){
//                pw.println("empty");
            }
        }
        pw.close();
    }

}

class MyDeque {
    public int[] dequeBody;
    public int maxSize;
    public int currSize = 0;
    public int headIndex, tailIndex;

    public MyDeque(int maxSize) {
        this.currSize = 0;
        this.maxSize = maxSize;
        this.dequeBody = new int[maxSize];
        this.headIndex = 0;
        this.tailIndex = 1;
    }

    public int decrementIndex(int idx) {
        idx--;
        if (idx == -1) {
            idx = maxSize - 1;
        }
        return idx;
    }

    public int incrementIndex(int idx) {
        idx++;
        if (idx == maxSize) {
            idx = 0;
        }
        return idx;
    }

    public void pushFront(int val) throws IllegalStateException {
        if (currSize == maxSize) {
            throw new IllegalStateException();
        }
        currSize++;
        dequeBody[headIndex] = val;
        headIndex = decrementIndex(headIndex);
    }

    public int popFront() throws NoSuchElementException {
        if (currSize == 0) {
            throw new NoSuchElementException();
        }
        currSize--;
        headIndex = incrementIndex(headIndex);
        return dequeBody[headIndex];
    }

    public void pushBack(int val) throws IllegalStateException {
        if (currSize == maxSize) {
            throw new IllegalStateException();
        }
        currSize++;
        dequeBody[tailIndex] = val;
        tailIndex = incrementIndex(tailIndex);
    }

    public int popBack() throws NoSuchElementException {
        if (currSize == 0) {
            throw new NoSuchElementException();
        }
        currSize--;
        tailIndex = decrementIndex(tailIndex);
        return dequeBody[tailIndex];
    }
}