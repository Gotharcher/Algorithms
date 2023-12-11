//https://contest.yandex.ru/contest/25070/run-report/102547566/
//102547566

/*
ПРИНЦИП РАБОТЫ
Используем вариант Алгоритма Прима, но будем брать максимальное ребро, а не минимальное. Я еще так посмотрел, это не совсем Прима...
Это какой-то priorityFS.
Пояснения к сокращениям: V - число вершин, E - число ребер.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Для хранения следующих вершин шага, используем приоритетную очередь - кучу, в которой будут объекты с полями: куда, вес.
Классу описан компаратор, чтобы куча корректно сортировалась.
Начнем алгоритм с того, что добавим в кучу все ребра из произвольной вершины (вершина у нас как минимум одна, выберем первую).
Следующим шагом, в цикле, пока в куче есть ребра, будем брать из кучи ребро с наибольшим весом. Если оно ведет в ранее посещенную вершину - берем следующее.
Если ребро ведет в непосещенную вершину - увеличиваем итоговый вес остовного дерева, и добавляем в кучу все рёбра из новой вершины, которые ведут в непосещенные вершины.
Так мы гарантированно обойдём все вершины.
Для каждой вершины, чьи рёбра мы вносим в кучу, покрасим её в серый. В черный красить необязательно - после обхода графа, по массиву цветов будет запущен поиск белых вершин.
Если таковые найдутся, граф несвязный.

Исходя из этого, мы гарантированно обошли все достижимые вершины ТОЛЬКО по максимальному пути. И можем удостовериться, что у нас нет непосещенных вершин.
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Начальное заполнение требует O(E) операций. Финальная проверка на связность графа занимает O(V).
Добавление и изъятие ребра в/из кучи занимает O(log N), где N - число элементов в куче. Худший вариант - когда в кучу
добавляется V раз E/V записей ~ O(E*log E). Последующие действия - E извлечений, тоже O(E*log E). Так как добавляются только
непосещенные вершины, это снижает подходящее число E, для последних добавляемых ребер с O(log E) до O(1), но это константа, на сложность не влияет.

Итоговая сложность O(E * log E)
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Изначальный список смежности занимает O(V+E).
Дополнительные структуры - массив цветов, O(V), куча ребер O(E)
Итоговая сложность O(V+E)
 */

package Yandex.Algo_course.Sprint6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Sprint6FinalA {
    public static final char WHITE = 'w';
    public static final char GREY = 'g';
    static PriorityQueue<Edge> edgesHeap = new PriorityQueue<>();
    static char[] colors;
    static List<Edge>[] vortexies;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inpSS = br.readLine().split(" ");
        int v = Integer.parseInt(inpSS[0]);
        int e = Integer.parseInt(inpSS[1]);

        colors = new char[v];
        for (int i = 0; i < v; i++) {
            colors[i] = WHITE;
        }

        vortexies = new List[v];
        for (int m = 0; m < v; m++) {
            vortexies[m] = new ArrayList<>();
        }

        for (int m = 0; m < e; m++) {
            String[] ss = br.readLine().split(" ");
            int inp = Integer.parseInt(ss[0]);
            int outp = Integer.parseInt(ss[1]);
            int weight = Integer.parseInt(ss[2]);
            Edge eFwd = new Edge(outp, weight);
            Edge eRev = new Edge(inp, weight);
            vortexies[inp - 1].add(eFwd);
            vortexies[outp - 1].add(eRev);
        }

        strangeSearch(1);

        boolean anyWhite = false;
        for (char c : colors) {
            if (c == WHITE) {
                anyWhite = true;
                break;
            }
        }
        if (anyWhite) {
            System.out.println("Oops! I did it again");
        } else {
            System.out.println(ans);
        }
        br.close();
    }

    public static void strangeSearch(int startNode) {
        addToHeap(startNode);
        colors[0] = 'g';
        while (!edgesHeap.isEmpty()) {
            Edge nextEdge = edgesHeap.poll();
            if (colors[nextEdge.toV - 1] == WHITE) {
                colors[nextEdge.toV - 1] = GREY;
                addToHeap(nextEdge.toV);
                ans += nextEdge.weight;
            }
        }
    }

    public static void addToHeap(int thisNode) {
        List<Edge> nears = vortexies[thisNode - 1];
        for (Edge e : nears) {
            if (colors[e.toV - 1] == WHITE) {
                edgesHeap.add(e);
            }
        }
    }
}

//Компарэбл класс для Кучи
class Edge implements Comparable<Edge> {
    public int toV, weight;

    public Edge(int toV, int weight) {
        this.toV = toV;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return o.weight - this.weight;
    }
}