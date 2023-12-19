package Yandex.Algo_course.Sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//0 = 48, 9 = 57
//a = 97, z = 122
//[ = 91, ] = 93

public class Sprint8FinalA {
    static char[][] symbols;
    static char[] prefixString = new char[100000];
    static int prefLen = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());

        unpackStringAndCompare(br.readLine());

        for(int s = 1; s<rows; s++){
            unpackStringAndCompare(br.readLine());
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < prefLen; i++){
            if(prefixString[i] == 0){
                break;
            }
            sb.append(prefixString[i]);
        }
        System.out.println(sb);
    }

    public static void unpackStringAndCompare(String s){
        char[] currString = new char[100000];
        int cIdx = 0;

        Deque<char[]> charsStack = new ArrayDeque<>();
        Deque<Integer> multiCharsStack = new ArrayDeque<>();


        for(int ci = 0; ci<s.length(); ci++){
            char procChar = s.charAt(ci);
            if(procChar >= 97){
                //буква строки
                currString[cIdx] = procChar;
                cIdx++;
            }else{
                //распаковать
                if(procChar >= 48 && procChar <= 57){
                    char[] multData = new char[100000];
                }
            }
        }

        if(prefLen == -1){
            prefixString = currString;
            prefLen = prefixString.length;
            return;
        }

        for (int i = 0; i < prefLen; i++) {
            if(currString[i] != prefixString[i]){
                prefLen = i;
                break;
            }
        }
    }
}
