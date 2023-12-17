package Yandex.Algo_course.Sprint8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pw = PrintWriter(System.out);
    val ss = br.readLine().split(" ")

    for (s in ss.asReversed()) {
        pw.print(s)
        pw.print(" ")
    }

    pw.close()
    br.close()
}