package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sprint3P {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int valsQty = Integer.parseInt(br.readLine());
        int[] vals = new int[valsQty];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<valsQty;i++){
            vals[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> segments = new ArrayList<>();

        int ans = 0;
        int searched = 0;
        int maxFound = 0;
        for(int i=0; i<valsQty;i++){
            maxFound = Math.max(vals[i], maxFound);
            if(vals[i] == searched){
                ans++;
                searched = maxFound+1;
                segments.add(maxFound);
            }else if(vals[i] < maxFound && ans > 0){
                ans = rearrangeSegments(segments, maxFound, vals[i]);
            }
        }
        System.out.println(ans);
    }

    public static int rearrangeSegments(List<Integer> segments, int maxFound, int valsValue){
        int ans = 1;
        for(int i = 0; i<segments.size();i++){
            if(segments.get(i)< valsValue){
                ans++;
            }else{
                segments.set(i,maxFound);
                break;
            }
        }
        return ans;
    }

}
