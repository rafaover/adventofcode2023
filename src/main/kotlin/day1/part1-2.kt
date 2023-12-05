package day1

import java.io.File

fun main() {
//    part1()
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
    val inputFile = File("C:\\Users\\rafam\\IdeaProjects\\adventofcode2023\\src\\main\\kotlin\\day1\\input.txt")
    var sumNumbers = 0
    val optionsList = listOf(
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "1", "2", "3", "4", "5", "6", "7", "8", "9"
    )
    val regex = Regex(optionsList.joinToString("|"))
    inputFile.forEachLine { line ->
        val matches = regex.findAll(line).map { it.value }.toList()
        if (matches.isNotEmpty()) {
            val firstMatch = matches.first()
            val lastMatch = matches.last()
            val firstNumber = if(firstMatch.toIntOrNull() != null) firstMatch.toInt() else optionsList.indexOf(firstMatch) + 1
            val lastNumber = if(lastMatch.toIntOrNull() != null) lastMatch.toInt() else optionsList.indexOf(lastMatch) + 1
            val numberString = "$firstNumber$lastNumber"
            sumNumbers += numberString.toInt()
        }
    }
    println(sumNumbers)
}