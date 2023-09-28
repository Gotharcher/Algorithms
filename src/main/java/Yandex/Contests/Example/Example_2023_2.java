package Yandex.Contests.Example;
//Через тернии к клиенту

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Example_2023_2 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalRows = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Map<Integer, Boolean>> rocketData = new TreeMap<>();
        for (int i = 0; i < totalRows; i++) {
            String[] event = br.readLine().split(" ");
            int rocketNumber = Integer.parseInt(event[3]);
            Map<Integer, Boolean> eventsData = rocketData.getOrDefault(rocketNumber, new TreeMap<>());
            if (event[4].equals("A")) {
                eventsData.put(convertToMinutes(event[0], event[1], event[2]), true);
            }
            if (event[4].equals("S") || event[4].equals("C")) {
                eventsData.put(convertToMinutes(event[0], event[1], event[2]), false);
            }
            rocketData.put(rocketNumber, eventsData);
        }
        for (var v : rocketData.entrySet()) {
            int res = 0;
            for (var t : v.getValue().entrySet()) {
                if (t.getValue()) res -= t.getKey();
                if (!t.getValue()) res += t.getKey();
            }
            sb.append(res);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int convertToMinutes(String day, String hour, String minute) {
        return (Integer.parseInt(day) * 24 + Integer.parseInt(hour)) * 60 + Integer.parseInt(minute);
    }

}
