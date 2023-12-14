package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint7B {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int meets = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[meets];
        for (int m = 0; m < meets; m++) {
            String[] len = br.readLine().split(" ");
            Meeting mm = new Meeting(m, len);
            meetings[m] = mm;
        }

        Arrays.sort(meetings);

        List<Meeting> meetingsArr = new ArrayList<>(meets);

        Time currTime = new Time(0, 0);
        for(int i = 0; i<meets;i++){
            if(meetings[i].S.compareTo(currTime) >= 0){
                meetingsArr.add(meetings[i]);
                currTime = meetings[i].F;
            }
        }

        System.out.println(meetingsArr.size());
        for(Meeting m: meetingsArr){
            System.out.println(m);
        }

    }
}

class Time implements Comparable<Time> {
    public int H, M;

    public Time(int h, int m) {
        H = h;
        M = m;
    }

    public Time(String s) {
        String[] splitted = s.split("\\.");
        H = Integer.parseInt(splitted[0]);
        if (splitted.length > 1) {
            this.M = Integer.parseInt(splitted[1]);
        }
    }

    @Override
    public String toString() {
        return this.H + (this.M==0?(""):("."+this.M));
    }

    @Override
    public int compareTo(Time o) {
        if(this.H == o.H){
            return this.M - o.M;
        }else{
            return this.H - o.H;
        }
    }
}

class Meeting implements Comparable<Meeting>{
    public int id;
    public Time S, F;
    public boolean out = false;

    public Meeting(int id, String[] ss) {
        this.id = id;

        this.S = new Time(ss[0]);
        this.F = new Time(ss[1]);

    }

    @Override
    public String toString() {
        this.out = true;
        return this.S.toString() + " " + this.F.toString();
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.F.compareTo(o.F) == 0){
            return this.S.compareTo(o.S);
        }else{
            return this.F.compareTo(o.F);
        }
    }
}