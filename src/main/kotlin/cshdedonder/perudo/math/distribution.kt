package cshdedonder.perudo.math

open class GenericDistribution(private val pmfMap: Map<Int, Double>) {

    private val cdfMap = pmfMap.mapValues { pmfMap.filterKeys { n -> n <= it.key }.sumValues() }

    val iteratePMF = pmfMap.entries
    val iterateCDF = cdfMap.entries

    open val lowerBound = pmfMap.keys.min() ?: Int.MIN_VALUE
    open val upperBound = pmfMap.keys.max() ?: Int.MIN_VALUE

    fun pmf(x: Int): Double = pmfMap.getOrDefault(x, 0.0)
    fun cdf(x: Int): Double = cdfMap.getOrDefault(x, 0.0)
    fun surv(x: Int): Double = 1.0 - cdf(x)
    fun range(a: Int, b: Int): Double = cdf(b) - cdf(a)

    override fun toString(): String = iteratePMF.toString()
}

fun <T> Map<T, Double>.sumValues() = values.sum()

operator fun GenericDistribution.plus(other: GenericDistribution): GenericDistribution =
    GenericDistribution((lowerBound+other.lowerBound..upperBound+other.upperBound).map {
        it to iteratePMF.map { entry -> entry.value * other.pmf(it - entry.key) }.sum()
    }.toMap())

operator fun Int.times(d: GenericDistribution): GenericDistribution = (1 until this).fold(d, {acc, _ -> acc + d})

open class UniformDistribution(override val lowerBound: Int = 0, override val upperBound: Int = 1): GenericDistribution(
        run {
            val n = upperBound - lowerBound + 1
            (lowerBound..upperBound).map { it to 1.0 / n }.toMap()
        })

object PerudoDistribution: GenericDistribution(mapOf(1 to 1.0/11, 2 to 2.0/11, 3 to 2.0/11, 4 to 2.0/11, 5 to 2.0/11, 6 to 2.0/11))
object DiceDistribution: UniformDistribution(1,6)