package Yandex.Algo_course.Sprint3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sprint3B {
    public static PrintWriter pw;
    public static Map<Character, char[]> buttons;

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        buttons = initMap();

        char[] charSeq = sc.next().toCharArray();
        printCharSeq(charSeq, 0, "");
        pw.close();
    }

    public static void printCharSeq(char[] charSeq, int idx, String ans) {
        if(idx == charSeq.length){
            pw.print(ans + " ");
            return;
        }
        char[] charsAtButton = buttons.get(charSeq[idx]);
        for(char c: charsAtButton){
            String nextAns = ans + c;
            printCharSeq(charSeq, idx+1, nextAns);
        }
    }

    public static Map<Character, char[]> initMap(){
        Map<Character, char[]> buttonsMap = new HashMap<>();
        buttonsMap.put('2', new char[]{'a', 'b', 'c'});
        buttonsMap.put('3', new char[]{'d', 'e', 'f'});
        buttonsMap.put('4', new char[]{'g', 'h', 'i'});
        buttonsMap.put('5', new char[]{'j', 'k', 'l'});
        buttonsMap.put('6', new char[]{'m', 'n', 'o'});
        buttonsMap.put('7', new char[]{'p', 'q', 'r', 's'});
        buttonsMap.put('8', new char[]{'t', 'u', 'v'});
        buttonsMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        return buttonsMap;
    }

}
