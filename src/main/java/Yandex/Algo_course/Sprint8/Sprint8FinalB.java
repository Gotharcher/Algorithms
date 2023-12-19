//103386525
//https://contest.yandex.ru/contest/26133/run-report/103386525/

package Yandex.Algo_course.Sprint8;

/*
ПРИНЦИП РАБОТЫ
Построим по словам-шаблонам бор. Бор будем строить нодами-Мапами, ключом будет буква, значением - следующая нода. И доп.поле - является ли она терминальной.
Первым шагом, с нулевого символа, пройдем по бору и терминальные позиции установим в массиве "терминальных индексов".
Далее, для каждого символа, который отмечен терминальным, снова пройдемся по бору.
Ответом будет терминальный индекс на последней позиции

L - Длина исходной строки (фразы, шпаргалки), N - количество поисковых строк (шаблонов), M - их максимальная длина.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Принципом работы является модификация алгоритма Кнута-Морриса-Пратта, который вызывается для каждой достижимой строки.

Доказательством того, что данный алгоритм корректен для задачи, будет "обратная развёртка" - в случае, если терминальный символ одного из элементов бора находится на последней позиции, означает,
что некая подстрока из фразы соответствует шаблону, значит, либо есть предыдущий терминальный символ (для которого можем проверить назад еще один шаблон) или начало фразы. Достижение начала фразы означает то,
что цепочка терминальных символов выстроилась в набор шаблонов, покрывающих фразу.
Решением алгоритма является динамическое программирование - начиная с нулевого символа, по бору, находится терминальный символ, после чего, для каждого найденного терминального символа
процесс повторяется - со следующего за терминальным символом снова ищется шаблон и терминальные символы.
Таким образом, новые терминальные символы появляются только впереди, значит, обход терминальных позиций с 0 гарантированно обойдет все терминальные символы (не будет такого, что символ появился в уже просмотренной области)
Так же, динамика позволит проверить каждый символ только один раз, даже в том случае, если несколько шаблонов "приходят" в один и тот же символ.
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Фраза (L), массив терминальных позиций (L), место для бора: (N*M)
Итоговая сложность: O(L + N*M)
 */

/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Время на построение бора (максимальное, все слова максимальной длины) - N*M.
Сложность поиска в худшем: для каждого символа фразы (каждый символ подходит под терминальный) L, надо будет пройти максимум M символов (максимальная длина поисковой строки, если она целиком совпадает).
Итоговая сложность: O(L*M + N*M)

Киллер-последовательностью является строка максимальной длины из одинаковых символов (а....а) = L, при шаблонах: (а, а....а = M). Односимвольный шаблон забьет весь массив терминальных символов чёрным,
а второй шаблон потребует M итераций для нахождения своего терминального символа...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Sprint8FinalB {
    static boolean[] teminatedSigns;
    static String phrase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        phrase = br.readLine();
        teminatedSigns = new boolean[phrase.length()];

        int qty = Integer.parseInt(br.readLine());

        TrieNode rootNode = new TrieNode();
        for (int i = 0; i < qty; i++) {
            fillNodeWithString(br.readLine(), rootNode);
        }

        findTermNode(rootNode, 0);
        for (int i = 0; i < phrase.length() - 1; i++) {
            if (teminatedSigns[i]) {
                findTermNode(rootNode, i + 1);
            }
        }

        if (teminatedSigns[phrase.length() - 1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void findTermNode(TrieNode rootNode, int charIdx) {
        Deque<TrieNode> deq = new ArrayDeque<>();
        TrieNode currNode;

        if (rootNode.dataMap.containsKey(phrase.charAt(charIdx))) {
            currNode = rootNode.dataMap.get(phrase.charAt(charIdx));
            deq.add(currNode);
            if (currNode.term) {
                teminatedSigns[charIdx] = true;
            }
            charIdx++;
        }
        while (!deq.isEmpty() && charIdx < phrase.length()) {
            TrieNode thisNode = deq.pop();
            if (thisNode.dataMap.containsKey(phrase.charAt(charIdx))) {
                currNode = thisNode.dataMap.get(phrase.charAt(charIdx));
                deq.add(currNode);
                if (currNode.term) {
                    teminatedSigns[charIdx] = true;
                }
                charIdx++;
            }
        }
    }

    public static void fillNodeWithString(String s, TrieNode rootNode) {
        TrieNode currNode = rootNode;
        for (char c : s.toCharArray()) {
            TrieNode nextNode = currNode.dataMap.getOrDefault(c, new TrieNode());
            currNode.dataMap.put(c, nextNode);
            currNode = nextNode;
        }
        currNode.term = true;
    }
}

class TrieNode {
    public Map<Character, TrieNode> dataMap = new HashMap<>();
    public boolean term; //Терминальный символ
}
