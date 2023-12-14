package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint7I {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int l = Integer.parseInt(ss[0]);
        int c = Integer.parseInt(ss[1]);

        FieldNodeWithHistory[][] field = new FieldNodeWithHistory[l+2][c+2];

        for(int i = 0; i<l+2; i++){
            for(int k = 0; k<c+2;k++){
                field[i][k] = new FieldNodeWithHistory(0);
            }
        }

        for(int i = 0; i<l; i++){
            field[i][0] = new FieldNodeWithHistory(0);
            field[i][c+1] = new FieldNodeWithHistory(0);
            char[] fieldLine = br.readLine().toCharArray();
            for(int k = 0; k<c;k++){
                field[i+1][k+1].flowers = Character.getNumericValue(fieldLine[k]);
            }
        }

        char prev = 'a';
        int add = 0;
        for(int line = l; line > 0; line--){
            field[line][1].accum = field[line][1].flowers + field[line+1][1].accum;
            field[line][1].prev = 'U';
        }
        for(int col = 1; col < c+1; col++){
            field[l][col].accum = field[l][col].flowers + field[l][col-1].accum;
            field[l][col].prev = 'R';
        }

        for(int line = l-1; line > 0; line--){
            for(int column = 2; column < c+1; column++){
                if(field[line][column-1].accum > field[line+1][column].accum){
                    add = field[line][column-1].accum;
                    prev = 'R';
                }else{
                    add = field[line+1][column].accum;
                    prev = 'U';
                }
                field[line][column].accum = field[line][column].flowers + add;
                field[line][column].prev = prev;
            }
        }

        field[l][1].prev = 'F';

        System.out.println(field[1][c].accum);
        int idxL = 1;
        int idxC = c;
        StringBuilder sb = new StringBuilder();

        while(idxC >= 1 && idxL <= l){
            prev = field[idxL][idxC].prev;
            if(prev == 'F'){
                break;
            }
            sb.append(prev);
            if(prev == 'R'){
                idxC -= 1;
            }else{
                idxL += 1;
            }
        }
        sb.reverse();
        System.out.println(sb);
    }
}

class FieldNodeWithHistory{
    public int flowers, accum;
    public char prev = 'F';

    public FieldNodeWithHistory(int flowers) {
        this.flowers = flowers;
        this.accum = 0;
    }
}
