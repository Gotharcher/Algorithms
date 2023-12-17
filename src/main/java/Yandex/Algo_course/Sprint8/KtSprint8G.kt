package Yandex.Algo_course.Sprint8

fun main(){
    val days = readlnOrNull()?.toInt()?:0
    val measures = Array(days){0}
    var inpString:List<String> = readlnOrNull()?.split(" ")?:List(0){""}
    for(i in 0 until days){
        measures[i] = inpString[i].toInt()
    }

    val seq = readlnOrNull()?.toInt()?:0
    val seqs = Array(seq){0}
    inpString = readlnOrNull()?.split(" ")?:List(0){""}
    for(i in 0 until seq){
        seqs[i] = inpString[i].toInt()
    }

    var shift = 0
    var fits = true
    for(m in 0 until days-seq+1){
        shift = measures[m] - seqs[0]
        fits = true

        for(sq in 0 until seq){
            if(measures[m+sq] != seqs[sq] + shift){
                fits = false
                break
            }
        }

        if(fits){
            print(m+1)
            print(" ")
        }
    }
}