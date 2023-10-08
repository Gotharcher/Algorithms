package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Sprint2H {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charSeq = br.readLine().toCharArray();
        Stack<Character> bracketSeq = new Stack<>();
        try {
            for (char c : charSeq) {
                if (c == '(' || c == '[' || c == '{') {
                    bracketSeq.push(c);
                }
                if (c == ')' || c == ']' || c == '}') {
                    Character stackChar = bracketSeq.pop();
                    if (stackChar == '(' && c != ')') {
                        System.out.println("False");
                        return;
                    }
                    if (stackChar == '[' && c != ']') {
                        System.out.println("False");
                        return;
                    }
                    if (stackChar == '{' && c != '}') {
                        System.out.println("False");
                        return;
                    }
                }
            }
        } catch (EmptyStackException ex) {
            System.out.println("False");
            return;
        }
        if (bracketSeq.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
