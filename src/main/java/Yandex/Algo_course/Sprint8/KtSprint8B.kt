package Yandex.Algo_course.Sprint8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val fString = br.readLine()
    val sString = br.readLine()

    when (fString.length - sString.length) {
        (0) -> checkReplace(fString, sString)
        (1) -> checkErase(fString, sString)
        (-1) -> checkErase(fString, sString)
        else -> println("FAIL")
    }

    br.close()
}

fun checkReplace(fString: String, sString: String) {
    val fChars = fString.toCharArray()
    val sChars = sString.toCharArray()
    var fIdx = 0
    var switched = false
    while (fIdx < fString.length) {
        if (fChars[fIdx] != sChars[fIdx]) {
            if(switched){
                print("FAIL")
                return
            }
            switched = true;
        }
        fIdx++
    }
    println("OK")
}

fun checkErase(fString: String, sString: String) {
    val fChars:CharArray
    val sChars:CharArray
    if(fString.length > sString.length) {
        fChars = fString.toCharArray()
        sChars = sString.toCharArray()
    }else{
        fChars = sString.toCharArray()
        sChars = fString.toCharArray()
    }
    var fIdx = 0
    var sIdx = 0
    var switched = false

    while (fIdx < fString.length-1) {
        if (fChars[fIdx] != sChars[sIdx]) {
            if(switched){
                print("FAIL")
                return
            }
            switched = true;
            fIdx++
        }
        fIdx++
        sIdx++
    }
    println("OK")
}