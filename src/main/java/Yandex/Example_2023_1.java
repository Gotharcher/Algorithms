package Yandex;

//Хитрый шифр

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2023_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalRows = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<totalRows; i++){
            int sliceRes = 0;
            String studentData = br.readLine();
            String[] separatedData = studentData.split(",");
            sliceRes = countSymbols(separatedData[0],separatedData[1],separatedData[2]);
            sliceRes = sliceRes + countDate(separatedData[3], separatedData[4]);
            String ansString = String.format("%03x", sliceRes);
            sb.append(ansString.substring(ansString.length()-3).toUpperCase());
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int countSymbols(String first, String second, String third){
        int[] symbols = new int[('z'-'A')+1];
        fillArray(first, symbols);
        fillArray(second, symbols);
        fillArray(third, symbols);
        int res = 0;
        for(int k: symbols) {
            if (k > 0) {
                res++;
            }
        }
        res = res + ((first.toLowerCase().toCharArray()[0]-'a'+1)*256);
        return res;
    }

    public static int countDate(String day, String month){
        int dayInt = 0;
        for(char c: day.toCharArray()){
            dayInt += Character.getNumericValue(c);
        }
        int monthInt = 0;
        for(char c: month.toCharArray()){
            monthInt += Character.getNumericValue(c);
        }
        return (dayInt+monthInt)*64;
    }
    public static int[] fillArray(String name, int[] array){
        for(char c: name.toCharArray()){
            array[c-'A']++;
        }
        return array;
    }

}
