const val BASENAME = "Day02"

fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        for (line in input) {
            val (command, amountString) = line.split(" ")
            when (command) {
                "down" -> depth += amountString.toInt()
                "forward" -> horizontal += amountString.toInt()
                "up" -> depth -= amountString.toInt()
                else -> throw IllegalStateException("Unable to parse command '$command'.")
            }
        }

        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for (line in input) {
            val (command, amountString) = line.split(" ")
            when (command) {
                "down" -> aim += amountString.toInt()
                "up" -> aim -= amountString.toInt()
                "forward" -> {
                    horizontal += amountString.toInt()
                    depth += aim * amountString.toInt()
                }
                else -> throw IllegalStateException("Unable to parse command '$command'.")
            }
        }

        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(BASENAME + "_test")
    check(part1(testInput) == 150) {"Wrong solution: ${part1(testInput)}"}
    check(part2(testInput) == 900) {"Wrong solution: ${part2(testInput)}"}

    val input = readInput(BASENAME)
    println(part1(input))
    println(part2(input))
}
