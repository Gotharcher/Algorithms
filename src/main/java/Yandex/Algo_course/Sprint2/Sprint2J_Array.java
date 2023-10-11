package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Sprint2J_Array {
    public static PrintWriter pw;
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int commands = Integer.parseInt(br.readLine());
        List<Integer> listArray = new ArrayList<>(commands);
        long tms = System.currentTimeMillis();
        for(int i=0; i<commands;i++){
            String[] command = br.readLine().split(" ");
//            String[] command = new String[]{"put", "1000"};
            if("put".equals(command[0])){
                listArray.add(0, Integer.parseInt(command[1]));
            }
            if("get".equals(command[0])){
                if(listArray.size()==0){
                    pw.println("error");
                    continue;
                }
                pw.println(listArray.remove(listArray.size()-1));
            }
            if("size".equals(command[0])){
                pw.println(listArray.size());
            }
        }
//        pw.println("time spent: " + (System.currentTimeMillis() - tms));
        pw.close();
    }
}
