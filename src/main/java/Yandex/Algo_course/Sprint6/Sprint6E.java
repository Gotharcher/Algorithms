package Yandex.Algo_course.Sprint6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Sprint6E {
    static Deque<Integer> graphStack = new ArrayDeque<>();
    static char[] colors;
    static List<List<Integer>> countColors = new ArrayList<>();
    static PrintWriter pw;
    static int vertecies;
    static List<Integer>[] vortexies;
    static int currColor = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        String[] inpSS = br.readLine().split(" ");
        vertecies = Integer.parseInt(inpSS[0]);

        int e = Integer.parseInt(inpSS[1]);

        colors = new char[vertecies];

        for (int i = 0; i < vertecies; i++) {
            colors[i] = 'w';
        }

        vortexies = new List[vertecies];
        for (int m = 0; m < vertecies; m++) {
            vortexies[m] = new ArrayList<>();
        }

        for (int m = 0; m < e; m++) {
            String[] ss = br.readLine().split(" ");
            int inp = Integer.parseInt(ss[0]);
            int outp = Integer.parseInt(ss[1]);
            vortexies[inp - 1].add(outp);
            vortexies[outp - 1].add(inp);
        }

        for(int i = 0; i<vertecies; i++){
            if(colors[i] == 'w'){
                DFS(i+1);
            }
        }

        System.out.println(countColors.size());

        for(List<Integer> l:countColors){
            Collections.sort(l);
            for(int n: l){
                pw.print(n);
                pw.print(" ");
            }
            pw.println();
        }

        br.close();
        pw.close();
    }

    public static void DFS(int startNode) {
        List<Integer> coloredNode = new ArrayList<>();
        graphStack.push(startNode);
        while (!graphStack.isEmpty()) {

            int thisNode = graphStack.pop();
            if(colors[thisNode-1] == 'b'){
                continue;
            }
            if (colors[thisNode - 1] == 'w') {
                graphStack.push(thisNode);
                colors[thisNode - 1] = 'g';
                addToStack(thisNode);
            } else {
                if (colors[thisNode - 1] == 'g') {
                    colors[thisNode - 1] = 'b';
                    coloredNode.add(thisNode);
                }
            }
        }
        countColors.add(coloredNode);
    }

    public static void addToStack(int thisNode) {
        List<Integer> nears = vortexies[thisNode-1];
        for (int i : nears) {
            if (colors[i - 1] == 'w') {
                graphStack.push(i);
            }
        }
    }
}
