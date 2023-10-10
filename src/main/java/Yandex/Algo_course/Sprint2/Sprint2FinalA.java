//92564407

package Yandex.Algo_course.Sprint2;

//Дек на кольце

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Sprint2FinalA {

    public static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commands = Integer.parseInt(br.readLine());
        int maxSize = Integer.parseInt(br.readLine());
        myDeque mdq = new myDeque(maxSize);
        for (int i = 0; i < commands; i++) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if ("push_front".equals(command)) {
                    mdq.pushFront(Integer.parseInt(st.nextToken()));
                    continue;
                }
                if ("push_back".equals(command)) {
                    mdq.pushBack(Integer.parseInt(st.nextToken()));
                    continue;
                }
                if ("pop_front".equals(command)) {
                    pw.println(mdq.popFront());
                    continue;
                }
                if ("pop_back".equals(command)) {
                    pw.println(mdq.popBack());
                    continue;
                }
            } catch (IllegalStateException | NoSuchElementException ex) {
                pw.println("error");
//            } catch (NoSuchElementException ex){
//                pw.println("empty");
            }
        }
        pw.close();
    }

}

class myDeque {
    public int[] dequeBody;
    public int maxSize;
    public int currSize = 0;
    public int headIndex, tailIndex;

    public myDeque() {
    }

    public myDeque(int maxSize) {
        this.currSize = 0;
        this.maxSize = maxSize;
        this.dequeBody = new int[maxSize];
        this.headIndex = 0;
        this.tailIndex = 1;
    }

    public int decrementIndex(int idx) {
        idx--;
        if (idx == -1) {
            idx = maxSize - 1;
        }
        return idx;
    }

    public int incrementIndex(int idx) {
        idx++;
        if (idx == maxSize) {
            idx = 0;
        }
        return idx;
    }

    public void pushFront(int val) throws IllegalStateException {
        if (currSize == maxSize) {
            throw new IllegalStateException();
        }
        currSize++;
        dequeBody[headIndex] = val;
        headIndex = decrementIndex(headIndex);
    }

    public int popFront() throws NoSuchElementException {
        if (currSize == 0) {
            throw new NoSuchElementException();
        }
        currSize--;
        headIndex = incrementIndex(headIndex);
        return dequeBody[headIndex];
    }

    public void pushBack(int val) throws IllegalStateException {
        if (currSize == maxSize) {
            throw new IllegalStateException();
        }
        currSize++;
        dequeBody[tailIndex] = val;
        tailIndex = incrementIndex(tailIndex);
    }

    public int popBack() throws NoSuchElementException {
        if (currSize == 0) {
            throw new NoSuchElementException();
        }
        currSize--;
        tailIndex = decrementIndex(tailIndex);
        return dequeBody[tailIndex];
    }
}