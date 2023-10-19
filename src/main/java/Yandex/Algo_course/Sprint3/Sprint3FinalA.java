package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint3FinalA {
    public static int brokenSearch(int[] arr, int k) {
        return locateSequence(arr, k, 0, arr.length - 1);
    }

    public static int locateSequence(int[] arr, int k, int start, int stop) {
        if (stop - start <= 1) {
            if (arr[start] == k) {
                return start;
            } else if (arr[stop] == k) {
                return stop;
            } else {
                return -1;
            }
        }
        int midPos = start + (stop - start) / 2;

        if (arr[midPos] == k) {
            return midPos;
        } else {
            if (arr[stop] < arr[midPos]) { //Перелом справа от опорного
                if (k > arr[midPos]) { // элемент справа от опорного, до перелома
                    start = midPos;
                } else { //элемент слева от опорного, может быть через "0"
                    //сравним с началом массива
                    if (k >= arr[start]) { // элемент от 0 до центра.
                        stop = midPos;
                    } else {//элемент за нулём, у перелома
                        start = midPos;
                    }
                }
            } else { //перелом слева от опорного
                if (k < arr[midPos]) { //элемент где-то от опорного до перелома
                    stop = midPos;
                } else { //элемент справа от опорного, может быть через "0"
                    //сравним с началом массива
                    if (k > arr[stop]) { // элемент от 0 до центра.
                        stop = midPos;
                    } else {//элемент за нулём, у перелома
                        start = midPos;
                    }
                }
            }
            return locateSequence(arr, k, start, stop);
        }
    }

    private static void test() {
//        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
//        System.out.println(brokenSearch(arr, 5));
//
//        int[] arrr = {5, 1};
//        System.out.println(brokenSearch(arrr, 1));
//
//        int[] arrrr = {6, 7, 8, 1, 2, 3, 5};
//        System.out.println(brokenSearch(arrrr, 6));
//        System.out.println(brokenSearch(arrrr, 7));
//        System.out.println(brokenSearch(arrrr, 8));
//        System.out.println(brokenSearch(arrrr, 1));
//        System.out.println(brokenSearch(arrrr, 2));
//        System.out.println(brokenSearch(arrrr, 3));
//        System.out.println(brokenSearch(arrrr, 5));
//        System.out.println(brokenSearch(arrrr, 4));
//
//        int[] ar = {4, 8, 1, 2, 3};
//        System.out.println(brokenSearch(ar, 3));
//        System.out.println(brokenSearch(ar, 1));
//        System.out.println(brokenSearch(ar, 4));
//        System.out.println(brokenSearch(ar, 8));
//        System.out.println(brokenSearch(ar, 2));
//        System.out.println(brokenSearch(ar, 0));
//        System.out.println(brokenSearch(ar, 5));
//        System.out.println(brokenSearch(ar, 10));

//        assert 6 == brokenSearch(arr, 5);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        System.out.println(Sprint3FinalA.brokenSearch(arr, k));
    }
}
