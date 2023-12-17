package Yandex.Algo_course.Sprint8

var fIdx:Int = -1
var sIdx:Int = -1

fun main(){
    val fStr = readlnOrNull()?.toCharArray()
    val sStr = readlnOrNull()?.toCharArray()

    var fChar:Char;
    var sChar:Char;

    while (fIdx < fStr!!.size-1 && sIdx < sStr!!.size-1){
        fChar = nextValChar(fStr)
        sChar = nextSecondValChar(sStr)

        if(fChar != sChar){
            println(fChar.compareTo(sChar))
            return
        }
    }
    println(0)
}

fun nextValChar(ca:CharArray):Char{

    while(fIdx < ca.size-1){
        fIdx++
        if((ca[fIdx] - 'a' - 1) % 2 == 0){
            return ca[fIdx]
        }
    }
    return 'a'-1
}

fun nextSecondValChar(ca:CharArray):Char{

    while(sIdx < ca.size-1){
        sIdx++
        if((ca[sIdx] - 'a' - 1) % 2 == 0){
            return ca[sIdx]
        }
    }
    return 'a'-1
}