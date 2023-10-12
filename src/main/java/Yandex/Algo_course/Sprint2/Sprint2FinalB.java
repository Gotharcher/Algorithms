//92798602
//https://contest.yandex.ru/contest/22781/run-report/92798602/

package Yandex.Algo_course.Sprint2;

/*
-- ПРИНЦИП РАБОТЫ --
На вход подаются числа, в случае, если на вход подан оператор, он применяется к последним двум числам и итог операции становится "последним входным числом".
Для реализации хранилища чисел используется стек, так как он обеспечивает быстрый доступ к последним добавленным значениям.
Каждое входящее значение проверяется на наличие в множестве операторов - изначально предопределенным, если это НЕ оператор -
преобразуем значение в число и добавляем в стек. Если оператор - отправляем в калькулятор, на вычисление. Отдельно стоит обратить внимание на операции,
в которых результат зависит от порядка операндов. Поэтому, отправляя числа в калькулятор, последнее добавленное число является "вторым" - передаем числа в обратном порядке.
Так же, необходимо учесть, что используется целочисленное деление и необходимо использовать соответствующий метод.
 */

/*
-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
По условиям задачи, максимальное итоговое значение не превосходит 50000, значит, типа int достаточно.
Арифметические операции используются встроенные - их корректность предполагается доказанной, при использовании в данной программе.
По условиям, операнды должны храниться в программе, пока не будет встречен оператор для их обработки. Обработка операндов происходит с конца.
Операторы хранить во вспомогательной структуре нет необходимости - если встретился оператор, он сразу применяется.
Стек работает по принципу LIFO, значит, он подходит для получения последних двух поступивших операндов, с помощью pop(), pop().
Таким образом: использование стека, как вспомогательной структуры хранения операндов, обеспечивает корректный доступ к ним по принципу LIFO.
 */

/*
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Амортизированное добавление и получение из стека занимает О(1). Вычисление двух подготовленных операндов занимает О(1), таким образом, суммарные затраты времени на обработку оператора занимают:
Два получения, вычисление и добавление, 4*О(1) => О(1)
Полное время выполнение программы, по вычислению полной записи в итоговое значение, займет N * O(1) -> O(N), где N - количество операторов и операндов во входящем выражении.
 */

/*
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Вспомогательные переменные занимают константное пространство - О(1).
Стек, в котором хранятся операнды, занимает, в худшем случае, P*2 места, где P - количество входящих операндов, в случае, когда последний добавленный операнд попал на реаллокацию.
Таким образом, пространственная сложность О(1 + P*2) => O(P).
 */

//Польский калькулятор

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint2FinalB {

    public static Deque<Integer> values = new ArrayDeque<>();
    public static Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        MyStackCalculator msc = new MyStackCalculator();
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            if (operators.contains(nextToken)) {
                values.push(msc.decideOperand(nextToken, values.pop(), values.pop()));
            } else {
                values.push(Integer.parseInt(nextToken));
            }
        }
        System.out.println(values.pop());
    }
}

class MyStackCalculator {

    public int decideOperand(String oper, int b, int a) {
        if ("+".equals(oper)) {
            return plus(a, b);
        } else if ("-".equals(oper)) {
            return minus(a, b);
        } else if ("*".equals(oper)) {
            return mult(a, b);
        } else if ("/".equals(oper)) {
            return divide(a, b);
        }
        return 0;
    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return Math.floorDiv(a, b);
    }
}
