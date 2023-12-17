package Yandex.Algo_course.Sprint8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pw = PrintWriter(System.out)

    val inpChars = br.readLine().toCharArray();
    val inpStringsQty = br.readLine().toInt()

    val stringMaps = HashMap<Int, String>()


    for(i in 0 until inpStringsQty){
        val ss = br.readLine().split(" ")
        stringMaps[ss[1].toInt()] = ss[0];
    }

    for(i in inpChars.indices){
        if(stringMaps.containsKey(i)){
            pw.print(stringMaps[i])
        }
        pw.print(inpChars[i]);
    }

    if(stringMaps.containsKey(inpChars.size)){
        pw.print(stringMaps[inpChars.size])
    }

    pw.close()
    br.close()
}