import java.io.File

internal fun parseInput(filename: String) =
    File("inputs/$filename").readLines().map { it.trim() }.filter { it.isNotBlank() }