package Yandex.Algo_course.Sprint6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprint6A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpSS = br.readLine().split(" ");
        int v = Integer.parseInt(inpSS[0]);
        int e = Integer.parseInt(inpSS[1]);
        List<Integer>[] vortexies = new List[v];
        for (int m = 0; m < v; m++) {
            vortexies[m] = new ArrayList<>();
        }
        for (int m = 0; m < e; m++) {
            String[] ss = br.readLine().split(" ");
            vortexies[Integer.parseInt(ss[0])-1].add(Integer.parseInt(ss[1]));
        }
        for (List<Integer> l : vortexies) {
            StringBuilder sb = new StringBuilder();
            Collections.sort(l);
            sb.append(l.size());
            sb.append(" ");
            for (Integer i : l) {
                sb.append(i);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
