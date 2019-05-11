package cshdedonder.perudo.view

import cshdedonder.perudo.app.GameModeSelector
import tornadofx.*

class MasterView : View() {

    override val root = gridpane {
        row {
            add(GameModeSelector)
        }
    }
}
