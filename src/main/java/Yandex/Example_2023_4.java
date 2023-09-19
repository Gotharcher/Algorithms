package Yandex;

//Лей, лей, не жалей

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Example_2023_4 {
    public static Map<Integer, Integer> pricesMap = new HashMap<>();
    public static Map<Integer, Integer> lengthMap = new HashMap<>();

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordersQty = Integer.parseInt(br.readLine());
        for (int i = 0; i < ordersQty; i++) {
            String[] orderData = br.readLine().split(" ");
            int startTime = Integer.parseInt(orderData[0]);
            int stopTime = Integer.parseInt(orderData[1]);
            pricesMap.put(startTime, pricesMap.getOrDefault(startTime, 0) + Integer.parseInt(orderData[2]));
            lengthMap.put(stopTime, lengthMap.getOrDefault(stopTime, 0) + stopTime-startTime);
        }
        int questionsQty = Integer.parseInt(br.readLine());
        int[][] questionsArray= new int[questionsQty][3];
        for (int i = 0; i < questionsQty; i++) {
            String[] questions = br.readLine().split(" ");
            int startTime = Integer.parseInt(questions[0]);
            int stopTime = Integer.parseInt(questions[1]);
            int question = Integer.parseInt(questions[2]);

            if(question == 1) {
                pricesMap.putIfAbsent(startTime-1, 0);
                pricesMap.putIfAbsent(stopTime, 0);
            }
            if(question == 2) {
                lengthMap.putIfAbsent(startTime-1, 0);
                lengthMap.putIfAbsent(stopTime, 0);
            }

            questionsArray[i][0] = startTime;
            questionsArray[i][1] = stopTime;
            questionsArray[i][2] = question;
        }

        List<Integer> listOfStarts = new ArrayList<>(pricesMap.keySet());
        Collections.sort(listOfStarts);
        Map<Integer, Long>  rsqPrices = getPrefixesMap(listOfStarts, pricesMap);

        List<Integer> listOfEnds = new ArrayList<>(lengthMap.keySet());
        Collections.sort(listOfEnds);
        Map<Integer, Long>  rsqLengths = getPrefixesMap(listOfEnds, lengthMap);

        for(int k=0; k<questionsQty; k++){
            long res = 0;
            if(questionsArray[k][2] == 1){
                res = countPrefSumm(rsqPrices, questionsArray[k][0] - 1, questionsArray[k][1]);
                sb.append(res);

            }
            if(questionsArray[k][2]==2){
                res = countPrefSumm(rsqLengths, questionsArray[k][0] - 1, questionsArray[k][1]);
                sb.append(res);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static Map<Integer, Long> getPrefixesMap(List<Integer> initList, Map<Integer, Integer> sourceMap){
        Map<Integer, Long> prefMap = new HashMap<>();
        prefMap.put(0, 0L);
        prefMap.put(initList.get(0), 0L);
        for(int i=1; i<initList.size(); i++){
            prefMap.put(initList.get(i), prefMap.get(initList.get(i-1)) + sourceMap.get(initList.get(i)));
        }
        return prefMap;
    }

    public static long countPrefSumm(Map<Integer, Long> prefMap, int startVal, int stopVal){
        return prefMap.get(stopVal) - prefMap.get(startVal);
    }
}
