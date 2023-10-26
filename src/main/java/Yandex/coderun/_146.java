package Yandex.coderun;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class _146 {
    public static int CARDS = 10;
    public static int TURNS_LIMIT = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstS = br.readLine().split(" ");
        String[] secondS = br.readLine().split(" ");

        Queue<Integer> first = createQueue(firstS);
        Queue<Integer> second = createQueue(secondS);

        int currTurn = 0;

        while (currTurn < TURNS_LIMIT){
            if(first.isEmpty()){
                System.out.println("second " + currTurn);
                return;
            }
            if(second.isEmpty()){
                System.out.println("first " + currTurn);
                return;
            }
            makeTurn(first, second);
            currTurn++;
        }
        bw.write("botva");

        br.close();
        bw.close();
    }

    public static void makeTurn(Queue<Integer> first, Queue<Integer> second){
        int f = first.remove();
        int s = second.remove();
        if(f==0 && s == 9){
            first.add(f);
            first.add(s);
        }else if(f==9 && s == 0){
            second.add(f);
            second.add(s);
        }else {
            if (f > s) {
                first.add(f);
                first.add(s);
            } else {
                second.add(f);
                second.add(s);
            }
        }
    }

    public static Queue<Integer> createQueue(String[] ss){
        Queue<Integer> q = new ArrayDeque<>(CARDS);
        for (String s : ss) {
            q.add(Integer.parseInt(s));
        }
        return q;
    }
}
