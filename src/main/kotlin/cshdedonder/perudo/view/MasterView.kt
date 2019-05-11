package cshdedonder.perudo.view

import cshdedonder.perudo.app.GameModeSelector
import cshdedonder.perudo.math.PerudoDistribution
import cshdedonder.perudo.math.*
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*

class MasterView : View() {

    private val pacoDist = BinomialDistribution(n = 36, p = 1.0/11)
    private val nonPacoDist = BinomialDistribution(n = 36, p = 2.0/11)

    override val root = gridpane {
        row {
            barchart("Density Function", CategoryAxis(), NumberAxis()){
                series("Probability to roll n paco's with 36 dice"){
                    (1..36).map {it.toString() to pacoDist.pmf(it)}.forEach { data(it.first, it.second) }
                }
                series("Probability to roll n non-paco's with 36 dice"){
                    (1..36).map {it.toString() to nonPacoDist.pmf(it)}.forEach { data(it.first, it.second) }
                }
            }
        }
    }
}
