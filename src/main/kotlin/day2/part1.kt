package day2

import java.io.File

fun main() {
    part1()
}

fun part1() {
    val input = File("src/main/kotlin/day2/input.txt")
    val redCubes = 12
    val greenCubes = 13
    val blueCubes = 14
    var idSum = 0
    input.forEachLine { line ->
        val gameNumber = line.substringAfter("Game").substringBefore(":").trim().toInt()
        val gameDraw = line.substringAfter(":").trim().replace("[^\\w\\s]".toRegex(), "").split(" ")
        var conditionsMet = true
        for (i in gameDraw.indices) {
            val gameDrawItem = gameDraw[i]
            if (gameDrawItem.toIntOrNull() == null) {
                val previousCubeCount = gameDraw[i - 1].toInt()
                if (gameDrawItem == "red" && previousCubeCount > redCubes) conditionsMet = false
                if (gameDrawItem == "green" && previousCubeCount > greenCubes) conditionsMet = false
                if (gameDrawItem == "blue" && previousCubeCount > blueCubes) conditionsMet = false
            }
        }
        if (conditionsMet) idSum += gameNumber
    }
    println(idSum)
}