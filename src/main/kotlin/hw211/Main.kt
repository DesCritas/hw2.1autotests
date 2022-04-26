package hw211

fun main(){
    val transAmount = 1100000
    val comission : Int = transaction(transAmount, "Maestro", 6500000)
    if (comission == -1) {
        println("Неверный тип карты")
    } else {
        println("Перевод $transAmount коп. Комиссия составила: $comission коп.")
    }

}

fun transaction(
    currentTrans : Int,
    cardType: String = "VK Pay",
    prevTransSum: Int = 0
) : Int {
    val comission : Int = when(cardType){
        "VK Pay" ->  0
        "Visa", "МИР" -> if (currentTrans*0.0075 < 3500) 3500 else (currentTrans*0.0075).toInt()
        "Mastercard", "Maestro" -> calcComissionMM(prevTransSum, currentTrans)
        else -> -1
    }
    return comission
}

fun calcComissionMM (prevTransSum: Int, currentTrans: Int) : Int{
    val comission :Int = when (val transSum : Int = prevTransSum + currentTrans){
        in 0..7500000 -> 0
        else -> if (prevTransSum>7500000) (2000 + 0.006*currentTrans).toInt() else (2000 + 0.006*(transSum-7500000)).toInt()
    }
    return comission
}
