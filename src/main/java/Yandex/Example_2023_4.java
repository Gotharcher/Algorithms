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
        List<Integer> listOfStarts = new ArrayList<>(pricesMap.keySet());
        Collections.sort(listOfStarts);

        List<Integer> listOfEnds = new ArrayList<>(lengthMap.keySet());
        Collections.sort(listOfEnds);

        int questionsQty = Integer.parseInt(br.readLine());
        for (int i = 0; i < questionsQty; i++) {
            long res = 0;
            String[] questions = br.readLine().split(" ");
            int startTime = Integer.parseInt(questions[0]);
            int stopTime = Integer.parseInt(questions[1]);
            if(questions[2].equals("1")){
                List<Integer> resList = getSubarrayOfValues(listOfStarts, startTime, stopTime);
                for(Integer k: resList){
                    res += pricesMap.get(k);
                }
            }
            if(questions[2].equals("2")){
                List<Integer> resList = getSubarrayOfValues(listOfEnds, startTime, stopTime);
                for(Integer k: resList){
                    res += lengthMap.get(k);
                }
            }
            sb.append(res);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static List<Integer> getSubarrayOfValues(List<Integer> arr, int start, int stop){
        int startIndex =-1, stopIndex = -1;
        for(int i=0; i<arr.size(); i++ ){
            if(arr.get(i) >= start){
                startIndex = i;
                break;
            }
        }
        for(int i=arr.size()-1; i>=0; i--){
            if(arr.get(i) <= stop){
                stopIndex = i;
                break;
            }
        }
        if(startIndex < 0 || stopIndex < 0){
            return new ArrayList<>();
        }
        return arr.subList(startIndex, stopIndex+1);
    }
}
