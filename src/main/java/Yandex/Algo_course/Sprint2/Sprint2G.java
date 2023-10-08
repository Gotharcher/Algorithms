package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprint2G {
    public static List<Integer> stack = new ArrayList<>();
    public static List<Integer> maxStack = new ArrayList<>();
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
        stack.add(val);
        if(maxStack.size() == 0 || val > maxStack.get(maxStack.size()-1)){
            maxStack.add(val);
        }else{
            maxStack.add(maxStack.get(maxStack.size()-1));
        }
    }

    public static void pop(){
        if(stack.size() == 0){
            System.out.println("error");
        }else{
            stack.remove(stack.size()-1);
            maxStack.remove(maxStack.size()-1);
        }
    }

    public static void findAndPrintMax(){
        if(stack.size() == 0){
            System.out.println("None");
            return;
        }
        System.out.println(maxStack.get(maxStack.size()-1));
    }
}
