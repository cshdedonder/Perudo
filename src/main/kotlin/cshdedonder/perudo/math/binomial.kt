package cshdedonder.perudo.math

import kotlin.math.pow

infix fun Int.choose(k: Int): Int = (1..k).fold(1, {acc, i -> acc * (this + 1 - i)/i})

class BinomialDistribution(val n: Int, val p: Double) {

    fun pmf(k: Int): Double {
        return (n choose k) * p.pow(k) * (1-p).pow(n-k)
    }
}