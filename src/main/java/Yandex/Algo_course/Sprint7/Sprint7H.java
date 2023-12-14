package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint7H {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int l = Integer.parseInt(ss[0]);
        int c = Integer.parseInt(ss[1]);

        FieldNode[][] field = new FieldNode[l+2][c+2];

        for(int i = 0; i<l+2; i++){
            for(int k = 0; k<c+2;k++){
                field[i][k] = new FieldNode(0);
            }
        }

        for(int i = 0; i<l; i++){
            field[i][0] = new FieldNode(0);
            field[i][c+1] = new FieldNode(0);
            char[] fieldLine = br.readLine().toCharArray();
            for(int k = 0; k<c;k++){
                field[i+1][k+1].flowers = Character.getNumericValue(fieldLine[k]);
            }
        }

        for(int col = l; col > 0; col--){
            for(int row = 1; row < c+1; row++){
                field[col][row].accum = field[col][row].flowers + Math.max(field[col][row-1].accum, field[col+1][row].accum);
            }
        }

        System.out.println(field[1][c].accum);
    }
}

class FieldNode{
    public int flowers, accum;

    public FieldNode(int flowers) {
        this.flowers = flowers;
        this.accum = 0;
    }
}
