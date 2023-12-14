package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sprint7C {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());
        int pQty = Integer.parseInt(br.readLine());

        Pile[] piles = new Pile[pQty];

        for (int i = 0; i < pQty; i++) {
            String[] ss = br.readLine().split(" ");
            piles[i] = new Pile(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
        }

        Arrays.sort(piles);

        long profit = 0;
        int ptr = 0;

        while (weight > 0 && ptr < pQty) {
            int gettedWeight = Math.min(weight, piles[ptr].qty);
            profit += (long) piles[ptr].price * gettedWeight;
            weight -= gettedWeight;
            ptr++;
        }
        System.out.println(profit);
    }
}

class Pile implements Comparable<Pile> {
    public int qty, price;

    public Pile(int price, int qty) {
        this.qty = qty;
        this.price = price;
    }

    @Override
    public int compareTo(Pile o) {
        return -this.price + o.price;
    }
}
