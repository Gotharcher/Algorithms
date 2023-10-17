package Yandex.Algo_course.Sprint3;

import java.util.Arrays;

public class Sprint3K {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] ans = new int[right-left];
        int rslide = mid;
        int lslide = left;
        int ansIdx = 0;
        while(lslide<mid && rslide<right){
            if(arr[lslide] <= arr[rslide]){
                ans[ansIdx] = arr[lslide];
                lslide++;
            }else{
                ans[ansIdx] = arr[rslide];
                rslide++;
            }
            ansIdx++;
        }
        if(rslide == right && lslide < mid){
            for(int l = lslide; l < mid; l++){
                ans[ansIdx] = arr[l];
                ansIdx++;
            }
        }
        if(lslide == mid && rslide < right){
            for(int l = rslide; l < right; l++){
                ans[ansIdx] = arr[l];
                ansIdx++;
            }
        }
        for(int i = 0; i<ans.length; i++){
            arr[left+i] = ans[i];
        }
        return ans;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if(right-left > 2){
            merge_sort(arr, left, left+(right-left)/2);
            merge_sort(arr, left+(right-left)/2, right);
        }
        merge(arr, left, left+(right-left)/2, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
