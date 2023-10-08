package Yandex.Algo_course.Sprint2;

import java.io.*;

public class Sprint2J {
    public static LinkedQueue headLink, tailLink;
    public static int eleQty = 0;
//    public static BufferedWriter bw;
    public static PrintWriter pw;
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pw = new PrintWriter(System.out);
        int commands = Integer.parseInt(br.readLine());
        for(int i=0; i<commands;i++){
            String[] command = br.readLine().split(" ");
            if("put".equals(command[0])){
                lqPut(Integer.parseInt(command[1]));
            }
            if("get".equals(command[0])){
                lqGet();
            }
            if("size".equals(command[0])){
                qSize();
            }
        }
//        bw.close();
        pw.close();
    }
    public static void lqPut(Integer i){
        LinkedQueue newLink = new LinkedQueue(i);
        eleQty++;
        if(headLink == null){
            headLink = newLink;
            tailLink = headLink;
        } else {
            tailLink.nextLink = newLink;
            tailLink = newLink;
        }
    }

    public static void lqGet(){
        if(eleQty == 0){
            pw.println("error");
//            bw.write("error" + System.lineSeparator());
//            System.out.println("error");
        }else{
            pw.println(headLink.val);
//            bw.write(headLink.val + System.lineSeparator());
//            System.out.println(headLink.val);
            headLink = headLink.nextLink;
            eleQty--;
        }
    }

    public static void qSize(){
        pw.println(eleQty);
//        bw.write(eleQty + System.lineSeparator());
//        System.out.println(eleQty);
    }

}

class LinkedQueue{
    LinkedQueue nextLink;
    int val;

    public LinkedQueue(int val){
        this.val = val;
    }
    public LinkedQueue(){

    }
}
