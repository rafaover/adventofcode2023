package day1

import java.io.File

// Iterate on file, line by line
// For each line, find first and last number, convert to String
// Connect both numbers, convert to Int
// Sum value found in SumOfNumbers var

var sumOfNumbers = 0
fun main() {
    val input = File("C:\\Users\\rafam\\IdeaProjects\\adventofcode2023\\src\\main\\kotlin\\day1\\input.txt")
    input.forEachLine { line ->
        val firstInt = line.find { it.isDigit() }?.toString()
        val lastInt = line.reversed().find { it.isDigit() }?.toString()
        val numberFound = "$firstInt$lastInt".toInt()
        sumOfNumbers += numberFound
    }
    println(sumOfNumbers)
}