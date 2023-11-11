package Yandex.Algo_course.Sprint4;

//96886858
//https://contest.yandex.ru/contest/24414/run-report/96886858/

/*
������� ������
����: ������ ����, �� ������, ����� �������� � ����, ���������� ������� ����� ���� ����, � ������� ����� ���� - ��������, � �������� - ���������� ���������.
�����, ������� ������� ��� �� �������� �� �����.
������ ����� � ������� �������� � �������� � ���, ����� ���������� ������������. ��� ������� ����������� ����� ������ ��� � ����.
�������� ���� ������� � ������� ����, ������� ����������� �� ����������, ��������� ������ (s3f B). ������� ������ 5 �������� �� ����� (s3 I).
 */

/*
�������������� ������������
������ ����� � ��������� �������� ������ �������� ��������� �������� ������� - HashMap, ��� ��������� ������������, � ��� �� ������� ������ �� �����.
��� ��� ���������� ��������� ������ ��������� ����� � ��������, �� ��������� ���� ������ �������� ��������� ��������� - ���� ����, � ������� ���� - ����� ���������, � ������ - ����� ���������.
����� �������, ��������� �������� ��������� ��� ������ �� O(1) � ������ ��������: "������� ��� ��� ����� ����������� � ���������".
��� ������� �������, �������� "������ �������������" (������� ������, ������ �������� - ��������, � �������� - ���������� ���������).
�� ��������� ����� �������, �� �������� �����, ��������� ������������ ������, ������� ������� �� �������� ������, ��������������� ���������� �� ���� ����� � "������ �����������".
��� ���������� �������� �������� �� ������ ������: ������������ ����� ��������� (���������� �� ��������) � �� ������� ���������� (�� �����������).
�� ��������� ���������������� ������������� ������� ������� �����, � �������� �� �������������� ���������� �������.
*/

/*
��������� ���������
��������� ������: �� O(1) ����������� ������� ����� � �������, �� ����� �� ����� ������������ ������� ����������. �������� ��������� ��������� ������: N (����� ����������) * k (����� ���� � ������ ���������) O(N*k)
��������� ������ (�������): ��� ������� ����� ����������� ��� ������������ �(1), ������� � ������� �(1), ��������� ������ �������� (� ������ ������, N) -> O(N). ������� �� ����� ���� (L) � �������
�����, ���� ��������� ������: ���������� ������� N * log(N). ����� ��������� ��� ��������� 1 �������: L*N + N * log(N) = N * (L + log (N)).
�������� ��������� ���� ��������: M * (N * (log N + L)).
������ ��������� ���������: O((N*k) + (M*N*(log N + L)))
*/

/*
���������������� ���������
������ �������� ����� ���� �� ����� ��������� � ��������: �(N * L).
��� ������� ������ ������������ ��������������� ���������, ��� ��������� �������� ����������� �������, ������� �� ����� ����������: N. ����� ��������� ������ �� ������, ��� ��������� �� �����.
�������� ���������: O(N*L)
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
