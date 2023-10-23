package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Sprint3I {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int studentQty = Integer.parseInt(br.readLine());
        int[] students = new int[studentQty];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<studentQty;i++){
            students[i] = Integer.parseInt(st.nextToken());
        }
        int kVal = Integer.parseInt(br.readLine());
        int[] universitiesIDs = new int[10001];
        for(int s = 0; s<studentQty;s++){
            universitiesIDs[students[s]]++;
        }

        List<University> univers = new ArrayList<>();
        for(int i = 0; i<10001;i++){
            if(universitiesIDs[i] != 0){
                univers.add(new University(i, universitiesIDs[i]));
            }
        }

        Collections.sort(univers);

        StringBuilder sb = new StringBuilder();
        for(University u: univers){
            sb.append(u.id + " ");
            kVal--;
            if (kVal == 0){
                break;
            }
        }
        System.out.println(sb);
    }
}

class University implements Comparable<University>{
    public int id;
    public int qty;

    public University(int id, int qty) {
        this.id = id;
        this.qty = qty;
    }

    @Override
    public int compareTo(University o) {
        if(this.qty == o.qty){
            return this.id - o.id;
        }else{
            return o.qty - this.qty;
        }
    }

    @Override
    public String toString(){
        return "id: " + this.id + " qty: " + this.qty;
    }
}
