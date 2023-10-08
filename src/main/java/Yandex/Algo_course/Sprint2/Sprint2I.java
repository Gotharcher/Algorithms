package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint2I {
    public static int[] limQueue;
    public static int headIndex, tailIndex, queueSize;
    public static int eleQty = 0;
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commands = Integer.parseInt(br.readLine());
        queueSize = Integer.parseInt(br.readLine());
        limQueue = new int[queueSize];
        headIndex = 0;
        tailIndex = 0;
        for(int i=0; i<commands;i++){
            String[] command = br.readLine().split(" ");
            if("push".equals(command[0])){
                qPush(Integer.parseInt(command[1]));
            }
            if("pop".equals(command[0])){
                qPop();
            }
            if("peek".equals(command[0])){
                qPeek();
            }
            if("size".equals(command[0])){
                qSize();
            }
        }
    }
    public static void qPush(Integer i){
        if(eleQty == queueSize){
            System.out.println("error");
            return;
        }
        eleQty++;
        limQueue[tailIndex] = i;
        tailIndex++;
        if(tailIndex >= queueSize){
            tailIndex = tailIndex - queueSize;
        }
    }
    public static void qPop(){
        if(eleQty == 0){
            System.out.println("None");
            return;
        }
        System.out.println(limQueue[headIndex]);
        headIndex++;
        if(headIndex >= queueSize){
            headIndex = headIndex - queueSize;
        }
        eleQty--;
    }
    public static void qPeek(){
        if(eleQty==0){
            System.out.println("None");
            return;
        }
        System.out.println(limQueue[headIndex]);
    }
    public static void qSize(){
        System.out.println(eleQty);
    }

}
