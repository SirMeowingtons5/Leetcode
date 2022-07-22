package annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AlgorithmProblem(
    val platform: AlgorithmPlatform,
    val number: Int,
    val title: String,
    val link: String,
    val difficulty: ProblemDifficulty,
)
