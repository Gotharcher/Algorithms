package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprint2F {
//    public static Integer max = null;
    public static List<Integer> stack = new ArrayList<>();
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commands = Integer.parseInt(br.readLine());
        for (int i = 0; i < commands; i++) {
            String[] command = br.readLine().split(" ");
            if ("push".equals(command[0])) {
                push(Integer.parseInt(command[1]));
            }
            if ("pop".equals(command[0])) {
                pop();
            }
            if ("get_max".equals(command[0])) {
                findAndPrintMax();
//                getMax();
            }
        }


    }

    public static void push(Integer val){
//        if(max==null){
//            max = val;
//        }else{
//            max = Math.max(max, val);
//        }
        stack.add(val);
    }

    public static void pop(){
        if(stack.size() == 0){
            System.out.println("error");
        }else{
            Integer lastValue = stack.remove(stack.size()-1);
//            if(lastValue.equals(max)){
//                max = null;
//            }
        }
    }

//    public static void getMax() {
//        if(stack.size()==0){
//            System.out.println("None");
//            return;
//        }
//        if(max==null){
//            findMax();
//        }
//        System.out.println(max);
//    }
//    public static void findMax(){
//        if(stack.size() == 0){
//            return;
//        }
//        for(int i=0; i<stack.size(); i++){
//            if(max==null){
//                max = stack.get(i);
//            }else{
//                max = Math.max(max, stack.get(i));
//            }
//        }
//    }
    public static void findAndPrintMax(){
        if(stack.size() == 0){
            System.out.println("None");
            return;
        }
        int max = stack.get(0);
        for(int i=1; i<stack.size(); i++){
            max = Math.max(max, stack.get(i));
        }
        System.out.println(max);
    }
}
