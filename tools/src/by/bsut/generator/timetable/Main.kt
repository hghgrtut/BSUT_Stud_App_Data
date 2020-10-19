package by.bsut.generator.timetable

import java.lang.StringBuilder

data class Para(
    val weekday: Int,
    val number: Int,
    val teacher: String? = null,
    val type: Int,
    val auditory: String,
    val subject: String,
    val weekMode: Int = ALL,
    val isMilitary: Boolean = false,
    val podgroupa: Int = ALL
) {
    override fun toString(): String ="{\"weekday\":$weekday,\"number\":$number,\"teacher\":" +
            "\"$teacher\",\"type\":$type,\"auditory\":\"$auditory\",\"subject\":\"$subject\"," +
            "\"weekMode\":$weekMode,\"isMilitary\":$isMilitary,\"podgroupa\":$podgroupa},"

    companion object { const val ALL = 0 } }

fun main() {
    print("Введите нужное количество пар: ")
    var size = readInt()
    var string = StringBuilder("")
    while (size > 0) {
        string = StringBuilder("$string${readPara()}")
        size--
    }
    print(string)
}

private inline fun readInt(): Int = readLine()!!.toInt()

private fun readPara(): Para {
    var weekDay: Int = 0
    do {
        println("Введите номер дня недели (1-6)")
        weekDay = readInt()
    } while (weekDay < 1 || weekDay > 6)
    weekDay--
    var number: Int = 0
    do {
        println("Введите номер пары (1-7)")
        number = readInt()
    } while (number < 1 || number > 7)
    number--
    println("Введите преподавателя")
    val teacher: String = readLine()!!
    var type: Int = -1
    do {
        println("Введи тип пары (0 - лаба, 1 - лекция, 2 - другое, 3 - ПЗ)")
        type = readInt()
    } while (type < 0 || type > 3)
    println("Введите аудиторию")
    val auditory: String = readLine()!!
    println("Введите предмет")
    val subject: String = readLine()!!
    var weekMode: Int = 3
    do {
        println("Введите неделю(0 - без разницы, 1 - над чертой, 2 - под чертой)")
        weekMode = readInt()
    } while (weekMode < 0 || weekMode > 2)
    println("Введите ограничение: (0 - никаких, -1 - военка, другое - номер подгруппы)")
    var podgroupa = readInt()
    var isMilitary: Boolean = false
    if (podgroupa == -1) {
        podgroupa = 0
        isMilitary = true
    }
    return Para(weekDay, number, teacher, type, auditory, subject, weekMode, isMilitary, podgroupa)
}