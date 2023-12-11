//102439984
//https://contest.yandex.ru/contest/25070/run-report/102439984/

package Yandex.Algo_course.Sprint6;

/*
ПРИНЦИП РАБОТЫ
Идея состоит в том, чтобы представить маршруты в виде графа, R будут пути в прямом направлении (R = 1 -> 2), а B - в обратном (B = 2 -> 1)
Таким образом, если при обходе в глубину мы наткнёмся на цикл, это будет означать, что обратные пути привели нас в тот же город, из которого мы "выехали", что означает неоптимальность карты.

Количество рёбер, по условиям задачи, E = (V*(V-1))/2 => E ~ V^2 для оценки сложности.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
В условии сказано, что можно двигаться только от большего города к меньшему. Значит, граф ориентированный.
Из каждого города дороги ведут только "вперед, к столице", значит, дороги одного типа не могут сформировать цикл.

Теорема о DFS и циклах:
В случае обхода в глубину, при добавлении новых вершин в стек, если вершина серая - значит, в данном пути есть цикл.
Черные вершины (посещенные в предыдущих итерациях DFS), проверять нет необходимости - так как они уже проверены и не имеют в себе цикла, значит, они ведут в другие вершины, отдельные от тех, которые мы проверяем сейчас.


Визуализация RB R
1 --- 2 --- 3
1 ========= 3

Если представить дорогу типа B как ребро с обратной ориентацией (из столицы на периферию), то в случае обхода в глубину, путь будет 1-2-3=(1),
вершина 1 будет серой в данной итерации, а значит, по пути типа B мы вернулись в вершину, из которой вышли, когда шли путями R.
Если определить R как "обратный" путь ничего не поменяется, обход будет 1=3-2-(1), та же серая вершина на том же месте.
Таким образом, по условию задачи, это будет неоптимальная карта - по R мы прошли в те же города, что и по B. На этом можно завершать все проверки и выводить ответ.
Если же мы прошли все элементы DFS (все ячейки чёрные), значит цикла нет и карта оптимальная.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
В худшем по времени случае нам нужно будет пройти все элементы - все рёбра и все вершины, O(V) + O(E), где V и E - вершины и рёбра соответственно.
Исходя из условия, количество вершин равно N, а количество ребер пропорционально квадрату, получаем O(N) + O(N^2)
Итоговая сложность: O(N^2)
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
В данном решении для хранения используется список смежности, изначально занимаемое место О(N^2).
Вспомогательные структуры хранения данных - стек для ДФС и массив цветов - пропорциональны N.
Итоговая сложность O(N^2)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sprint6FinalB {
    static Deque<Integer> graphStack = new ArrayDeque<>();
    static char[] colors; //покрас
    static List<Integer>[] vortexes;

    static boolean alarm; //глобальный триггер, что граф зацикленный, чтобы прервать исполнение и сэкономить

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertQty = Integer.parseInt(br.readLine());

        //Все задачи решал через сдвиг номера вершины, теперь хочу не учитывать нулевой индекс массива, чтобы номер вершины был индексом.
        vortexes = new List[vertQty + 1];
        for (int m = 0; m < vertQty + 1; m++) {
            vortexes[m] = new ArrayList<>();
        }
        colors = new char[vertQty + 1];
        //Представим R как прямые пути, а B - обратные.
        for (int m = 1; m < vertQty; m++) {
            char[] links = br.readLine().toCharArray();
            for (int l = 0; l < links.length; l++) {
                if (links[l] == 'R') {
                    vortexes[m].add(m + l + 1);
                } else {
                    vortexes[m + l + 1].add(m);
                }
            }
        }

        for (int i = 1; i < vertQty + 1; i++) {
            colors[i] = 'w';
        }

        //И поищем циклы в ДФСе
        for (int i = 1; i < vertQty + 1; i++) {
            if (colors[i] == 'w') {
                DFS(i);
                if (alarm) {
                    break;
                }
            }
        }

        if (alarm) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        br.close();
    }

    public static void DFS(int startNode) {
        graphStack.push(startNode);
        while (!graphStack.isEmpty()) {
            int thisNode = graphStack.pop();
            if (colors[thisNode] == 'b') {
                continue;
            }
            if (colors[thisNode] == 'w') {
                graphStack.push(thisNode);
                colors[thisNode] = 'g';
                addToStack(thisNode);
                if (alarm) {
                    return;
                }
            } else {
                if (colors[thisNode] == 'g') {
                    colors[thisNode] = 'b';
                }
            }
        }
    }

    public static void addToStack(int thisNode) {
        List<Integer> nears = vortexes[thisNode];
        for (int i : nears) {
            if (colors[i] == 'w') {
                graphStack.push(i);
            }
            if (colors[i] == 'g') {
                alarm = true;
                return;
            }
        }
    }
}
