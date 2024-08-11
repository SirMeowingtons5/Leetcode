import annotation.AlgorithmProblem
import java.io.File

fun updateReadme() {
    val problems = findAnnotatedClasses().mapNotNull { clazz ->
        clazz.getAnnotation(AlgorithmProblem::class.java)
    }
    generateReadme(problems)
}

// Scan for annotated classes
private fun findAnnotatedClasses(): List<Class<*>> {
    val classes = mutableListOf<Class<*>>()

    // Root directory for compiled classes
    val rootDir = File("build/classes/kotlin/main")

    if (!rootDir.exists()) {
        throw IllegalStateException("Directory ${rootDir.absolutePath} does not exist. Make sure to compile the project first.")
    }

    rootDir.walkTopDown().filter { it.extension == "class" }.forEach { classFile ->
        val relativePath = classFile.relativeTo(rootDir).path
        val className = relativePath
            .removeSuffix(".class")
            .replace(File.separatorChar, '.')
        try {
            val clazz = Class.forName(className)
            if (clazz.isAnnotationPresent(AlgorithmProblem::class.java)) {
                classes.add(clazz)
            }
        } catch (ex: ClassNotFoundException) {
            println("Class not found: $className")
        }
    }

    return classes
}

// Function to generate the README.md file
private fun generateReadme(problems: List<AlgorithmProblem>) {
    val readmeFile = File("Readme.md")
    readmeFile.writeText("# Stats\n")
    readmeFile.appendText("[![Leetcode Stats](https://leetcard.jacoblin.cool/SirMeowingtons5)](https://leetcode.com/SirMeowingtons5)\n\n")
    readmeFile.appendText("# Solved Problems\n\n")
    readmeFile.appendText("| Number | Problem | Difficulty |\n")
    readmeFile.appendText("|--------|---------|------------|\n")
    problems.sortedBy { it.number }.forEach { problem ->
        readmeFile.appendText("| ${problem.number} | [${problem.title}](${problem.link}) | ${problem.difficulty.name} |\n")
    }
}