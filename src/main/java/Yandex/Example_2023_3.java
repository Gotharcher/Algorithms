package Yandex;
//Приснится же такое...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2023_3 {
    public static int[][] tree;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int treeSize = Integer.parseInt(input[0]);
        String[] moves = br.readLine().split(" ");

        initTree(treeSize);
        for(String s: moves){
            swapValues(Integer.parseInt(s));
        }
        int currHead = 1;
        for(int[] nn: tree){
            if(nn[3]==0) {
                currHead = nn[0];
                break;
            }
        }
        lvrPath(currHead);
        System.out.println(sb);
    }

    public static void swapValues(int n){
        int parNode = tree[n-1][3];
        if(parNode==0) return;
        int[] parr = tree[parNode - 1];
        if (parr[1] == n) {
            leftSwap(n, parr);
        }
        if (parr[2] == n) {
            rightSwap(n, parr);
        }

    }

    public static void leftSwap(int node, int[] parNode){
        int[] swapNode = tree[node - 1];

        int oldPar = parNode[3];
        int oldChild = swapNode[1];
        if(oldChild > 0){
            tree[oldChild-1][3] = parNode[0];
        }
        parNode[1] = swapNode[1];
        parNode[3] = swapNode[0];
        swapNode[1] = parNode[0];
        swapParParNode(swapNode, parNode, oldPar);
    }

    public static void rightSwap(int node, int[] parNode) {
        int[] swapNode = tree[node - 1];

        int oldPar = parNode[3];
        int oldChild = swapNode[2];
        if(oldChild > 0){
            tree[oldChild-1][3] = parNode[0];
        }
        parNode[2] = swapNode[2];
        parNode[3] = swapNode[0];
        swapNode[2] = parNode[0];
        swapParParNode(swapNode, parNode, oldPar);
    }

    public static void swapParParNode(int[] swappingNode, int[] parNode, int oldPar){
        if(oldPar > 0){
            int[] parParNode = tree[oldPar-1];
            if(parParNode[2] == parNode[0]){
                parParNode[2] = swappingNode[0];
            }
            if(parParNode[1] == parNode[0]){
                parParNode[1] = swappingNode[0];
            }
            swappingNode[3] = parParNode[0];
        }else{
            swappingNode[3] = 0;
        }
    }


    public static void initTree(int size){
        tree = new int[size][4];
        for(int i=1; i<size+1; i++){
            tree[i-1][0] = i;
            if (i * 2 <= size) {
                tree[i-1][1] = i * 2;
                tree[i*2-1][3] = i;
            }
            if (i * 2 + 1 < size) {
                tree[i-1][2] = i * 2 + 1;
                tree[i * 2][3] = i;
            }
        }
    }

    public static void lvrPath(int n) {
        int node = n - 1;
        if (node < 0) {
            return;
        }
        int[] nodeArr = tree[node];
        if (nodeArr[1] != 0) {
            lvrPath(nodeArr[1]);
        }
        sb.append(nodeArr[0]);
        sb.append(" ");
        if (nodeArr[2] != 0) {
            lvrPath(nodeArr[2]);
        }
    }
}
