package Yandex.Algo_course.Sprint4;

//96687065
//https://contest.yandex.ru/contest/24414/run-report/96687065/

/*
ПРИНЦИП РАБОТЫ
Для реализации бакетов, буду использовать ЛинкедЛисты. Из библиотеки, по условию, это разрешено.
Ячейкой линкеда будет объект-нода, со значением ключа, значением и пометкой удаления.
По условиям, максимальное число хешей 10^5. Это будет размером массива ссылок на Линкеды. Максимальный размер значения
ключа 10^9, исходя из этого подберем "хеш-функцию" - модуль, ближайший к этому значению.
Определим массив для ЛинкедЛистов. Хеш ключа будет индексом массива линкедов. А дальше оно само работает:
Берем ключ, получаем индекс, если в ячейке не null - проходимся по всем элементам Линкеда, сравнивая нехешированный ключ, и проверяя пометку удаления.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Хешем Integer является само значение Integer.
Метод вычисления бакета основан на вычислении методом умножения. Не зависит от числа корзин. Из-за особенностей деления по модулю в Java (остается минус для отрицательных),
хешем ключа является его значение по модулю (Math.abs). В бакетах хранятся объекты класса LinkedList, у которых есть ключ, значение и пометка удаления.
Итогом вычисления номера бакета является индекс в массиве ЛинкедЛистов, с которым осуществляются действия в зависимости от входящей команды.
Для добавления - если ЛинкедЛиста нет, он создается. Если есть, то среди элементов ищется элемент с переданным ключом, и либо значение перезаписывается, либо создается новый элемент ЛинкедЛиста.
В случае получения - если ЛинкедЛиста нет, то элемент не существует. Иначе, перебираются элементы ЛинкедЛиста и сравниваются исходные ключи. В результате, возвращается значение либо "None".
При этом, важно проверить наличие пометки удаления - если ключ совпал, но есть пометка, значит, этот элемент удален и не должен влиять на результат.
Для удаления - аналогично получению, ищется элемент ЛинкедЛиста с совпадающим значением ключа, и устанавливается пометка удаления.
Причина, по которой используется пометка удаления - стандартный ЛинкедЛист поддерживает удаление, но не возвращает удаленное значение, это неудобно для решения данной задачи.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Доступ к бакету происходит за О(1). (Вычисление хеша и доступ к элементу массива по индексу).
Амортизированный поиск по ЛинкедЛисту происходит за О(1), это сложность любой операции при коллизиях.
Итоговая временная сложность O(1).
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Основные потребители пространства - аллоцированная память для хешей (в текущей реализации, занята даже при пустом наборе данных). Занимает меньше 10^5.
Сами значения: О(N), где N - количество данных для хранения. По условиям задачи, не превосходит 10^5.
Итоговая пространственная сложность: O(N).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Sprint4FinalB {

    //    static final int MOD = 100019;
    static final long S = 2654435769L;
    static final long POW_TWO_THIRTYTWO = 4294967296L;
    static final int P = 14; //65к, ~1/2 от 10^5...

    static PrintWriter pw;
    static LinkedList<NodeOfList>[] valuesList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        valuesList = new LinkedList[(int) Math.pow(2, P)];
        int totalAsks = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalAsks; i++) {
            String[] ask = br.readLine().split(" ");
            parseAsk(ask);
        }
        br.close();
        pw.close();
    }

    static void parseAsk(String[] ask) {
        int key = Integer.parseInt(ask[1]);
        if ("get".equals(ask[0])) {
            getMapValue(getHash(key), key);
        }
        if ("put".equals(ask[0])) {
            putMapValue(getHash(key), key, Integer.parseInt(ask[2]));
        }
        if ("delete".equals(ask[0])) {
            deleteMapValue(getHash(key), key);
        }
    }

    static void getMapValue(int hash, int keyValue) {
        LinkedList<NodeOfList> listEle = valuesList[hash];
        if (listEle == null) {
            pw.println("None");
        } else {
            for (NodeOfList n : listEle) {
                if (n.key == keyValue) {
                    pw.println(n.deletionMark ? "None" : n.value);
                    return;
                }
            }
            pw.println("None");
        }
    }

    static void putMapValue(int hash, int keyValue, int value) {
        LinkedList<NodeOfList> listEle = valuesList[hash];
        if (listEle == null) {
            listEle = new LinkedList<>();
            listEle.add(new NodeOfList(keyValue, value));
            valuesList[hash] = listEle;
        } else {
            for (NodeOfList n : listEle) {
                if (n.key == keyValue) {
                    n.deletionMark = false;
                    n.value = value;
                    return;
                }
            }
            listEle.add(new NodeOfList(keyValue, value));
        }
    }

    static void deleteMapValue(int hash, int keyValue) {
        LinkedList<NodeOfList> listEle = valuesList[hash];
        if (listEle == null) {
            pw.println("None");
        } else {
            for (NodeOfList n : listEle) {
                if (n.key == keyValue) {
                    if (!n.deletionMark) {
                        pw.println(n.value);
                        n.deletionMark = true;
                    } else {
                        pw.println("None");
                    }
                    return;
                }
            }
            pw.println("None");
        }
    }

    public static int getHash(int keyValue) {
        keyValue = Math.abs(keyValue);
        return (int) ((keyValue * S % POW_TWO_THIRTYTWO) >> (32 - P));
//        return (((keyValue % MOD) + MOD) % MOD);
    }
}

class NodeOfList {
    public int value, key;
    public boolean deletionMark = false;

    public NodeOfList(int key, int value) {
        this.value = value;
        this.key = key;
    }
}