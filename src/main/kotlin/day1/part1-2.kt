package day1

import java.io.File

fun main() {
    part1()
    part2()
}

fun part1() {
    val input = File("C:\\Users\\rafam\\IdeaProjects\\adventofcode2023\\src\\main\\kotlin\\day1\\input.txt")
    var sumOfNumbers = 0
    input.forEachLine { line ->
        val firstInt = line.find { it.isDigit() }?.toString()
        val lastInt = line.reversed().find { it.isDigit() }?.toString()
        val numberFound = "$firstInt$lastInt".toInt()
        sumOfNumbers += numberFound
    }
    println(sumOfNumbers)
}

fun part2() {
    val input = File("C:\\Users\\rafam\\IdeaProjects\\adventofcode2023\\src\\main\\kotlin\\day1\\input.txt")
    val numbersList = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
    )
    var sumOfNumbers = 0
    input.forEachLine { line ->
        val numbersFound: MutableList<String> = mutableListOf()
        for (char in line.indices) {
            val substring = line.substring(char)
            if (substring.first().isDigit()) {
                numbersFound.add(substring.first().toString())
            } else {
                for (number in numbersList) {
                    if (substring.startsWith(number.value)) {
                        numbersFound.add(number.key.toString())
                        break
                    }
                }
            }
        }
        val firstNumber = numbersFound.first()
        val lastNumber = numbersFound.last()
        val numberFound = "$firstNumber$lastNumber".toInt()
        sumOfNumbers += numberFound
    }
    println(sumOfNumbers)
}