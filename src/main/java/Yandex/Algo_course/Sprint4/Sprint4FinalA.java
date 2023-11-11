package Yandex.Algo_course.Sprint4;

//96886858
//https://contest.yandex.ru/contest/24414/run-report/96886858/

/*
ПРИНЦИП РАБОТЫ
Идея: каждый вход, по словам, будем помещать в Мапу, значениями которой будут тоже Мапы, в которых будет ключ - документ, а значение - количество вхождений.
Далее, входные запросы так же разобьем на слова.
Каждое слово в запросе проверим и поместим в Сет, чтобы поддержать уникальность. Для каждого уникального слова поищем его в Мапе.
Значения мапы соберем в двойной Лист, который отсортируем по количеству, входящему номеру (s3f B). Выведем первые 5 значений из Листа (s3 I).
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Каждое слово в документе является ключом основной структуры хранения индекса - HashMap, это обеспечит уникальность, а так же быстрый доступ по ключу.
Так как необходимо учитывать каждое вхождение слова в документ, то значением Мапы должно являться двумерное хранилище - тоже Мапа, у которой ключ - номер документа, а индекс - число вхождений.
Таким образом, хранилище индексов обеспечит нам доступ за O(1) к набору значений: "сколько раз это слово встречается в документе".
Для каждого запроса, составим "массив релевантности" (обычный массив, индекс которого - документ, а значение - количество вхождений).
На основании этого массива, по значащим полям, создается динамический массив, который состоит из объектов класса, поддерживающего сортировку по двум полям в "разном направлении".
Эта сортировка позволит ответить на запрос задачи: максимальное число вхождений (сортировка по убыванию) и по порядку документов (по возрастанию).
На основании отсортированного динамического массива выводим ответ, с отсечкой по запрашиваемому количеству ответов.
*/

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Сложность записи: за O(1) проверяется наличие слова в индексе, за такое же время дописывается счётчик документов. Итоговая сложность обработки записи: N (число документов) * k (число слов в каждом документе) O(N*k)
Сложность чтения (запроса): для каждого слова проверяется его уникальность О(1), наличие в индексе О(1), считается каждый документ (в худшем случае, N) -> O(N). Зависит от числа слов (L) в запросе
Далее, идет обработка ответа: Сортировка массива N * log(N). Общая сложность для обработки 1 запроса: L*N + N * log(N) = N * (L + log (N)).
Итоговая сложность всех запросов: M * (N * (log N + L)).
Полная сложность алгоритма: O((N*k) + (M*N*(log N + L)))
*/

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Индекс занимает число слов на число вхождений в документ: О(N * L).
Для каждого ответа используется вспомогательная структура, для получения наиболее релевантных ответов, зависит от числа документов: N. После получения ответа на запрос, эта структура не нужна.
Итоговая сложность: O(N*L)
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Sprint4FinalA {
    static final int TOTAL_ANS = 5;
    static Map<String, Map<Integer, Integer>> docsMap = new HashMap<>();
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int docs = Integer.parseInt(br.readLine());
        for (int i = 1; i <= docs; i++) {
            String[] words = br.readLine().split(" ");
            for (String s : words) {
                Map<Integer, Integer> mapMap = docsMap.get(s);
                if (mapMap != null) {
                    mapMap.put(i, mapMap.getOrDefault(i, 0) + 1);
                } else {
                    mapMap = new HashMap<>();
                    mapMap.put(i, 1);
                    docsMap.put(s, mapMap);
                }
            }
        }

        int asks = Integer.parseInt(br.readLine());
        for (int k = 1; k <= asks; k++) {
            int[] ansArr = new int[docs + 1];
            Set<String> uniqs = new HashSet<>();
            String[] askWords = br.readLine().split(" ");
            for (String s : askWords) {
                if (uniqs.contains(s)) continue;
                uniqs.add(s);

                Map<Integer, Integer> mapMap = docsMap.get(s);
                if (mapMap == null) continue;
                for (Map.Entry<Integer, Integer> e : mapMap.entrySet()) {
                    ansArr[e.getKey()] += e.getValue();
                }
            }
            pw.println(printAnswerFromArray(ansArr));
        }
        pw.close();
        br.close();
    }


    public static String printAnswerFromArray(int[] arr) {
        List<DocsEnters> docsList = new ArrayList<>();
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == 0) continue;
            docsList.add(new DocsEnters(k, arr[k]));
        }
        Collections.sort(docsList);
        int scopeAns = TOTAL_ANS;
        StringBuilder sb = new StringBuilder();
        for (DocsEnters d : docsList) {
            sb.append(d.docNumber).append(" ");
            scopeAns--;
            if (scopeAns == 0) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}

class DocsEnters implements Comparable<DocsEnters> {
    public int docNumber;
    public int entersQty;

    public DocsEnters(int docNumber, int entersQty) {
        this.docNumber = docNumber;
        this.entersQty = entersQty;
    }

    @Override
    public int compareTo(DocsEnters o) {
        if (this.entersQty == o.entersQty) {
            return this.docNumber - o.docNumber;
        } else {
            return o.entersQty - this.entersQty;
        }
    }
}
