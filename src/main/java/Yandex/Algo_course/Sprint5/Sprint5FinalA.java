package Yandex.Algo_course.Sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
ПРИНЦИП РАБОТЫ
Требуется реализовать сортировку кучей. Как: добавялем в конец и сеем вверх ИЛИ добавляем псевдо-элемент на первую позицию и сеем вниз.
Для получения ответа, выводим первый элемент кучи, сеем её вниз, и так до конца кучи.
 */

public class Sprint5FinalA {
    static PrintWriter pw;
    static int lastIndex = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int partsQty = Integer.parseInt(br.readLine());
        HeapParticipantElement[] partsHeap = new HeapParticipantElement[2*partsQty+1];
        for(int i = 0; i<partsQty;i++){
            String[] ss = br.readLine().split(" ");
            HeapParticipantElement newEle = new HeapParticipantElement(ss);
            partsHeap[lastIndex] = newEle;
            siftUp(partsHeap, lastIndex);
            lastIndex++;
        }
    }

    static int siftUp(HeapParticipantElement[] heap, int idx){
        if(idx == 1){
            return idx;
        }
        int hostIdx = idx/2;
        HeapParticipantElement ele = heap[idx];
        if(heap[hostIdx].isLesser(ele)){
            heap[idx] = heap[hostIdx];
            heap[hostIdx] = ele;
            return siftUp(heap, hostIdx);
        }else{
            return idx;
        }
    }

    static int siftDown(HeapParticipantElement[] heap, int idx, HeapParticipantElement siftedElement){
        return 0;
    }
}

class HeapParticipantElement implements Comparable<HeapParticipantElement>{
    public String name;
    public int solved, penalty;

    public HeapParticipantElement(String name, int solved, int penalty) {
        this.name = name;
        this.solved = solved;
        this.penalty = penalty;
    }

    public HeapParticipantElement(String[] dataStrings) {
        this(dataStrings[0], Integer.parseInt(dataStrings[1]), Integer.parseInt(dataStrings[2]));
    }

    public boolean isLesser(HeapParticipantElement o){
        return this.compareTo(o) < 0;
    }

    @Override
    public int compareTo(HeapParticipantElement o) {
        if(this.solved == o.solved){
            if(this.penalty == o.penalty){
                return this.name.compareTo(o.name);
            }else{
                return o.penalty - this.penalty;
            }
        }else{
            return this.solved - o.solved;
        }
    }
}
