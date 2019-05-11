package cshdedonder.perudo.app

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import javafx.scene.layout.GridPane
import tornadofx.*

object GameModeSelector: GridPane(){

    private val toggleGroup = ToggleGroup()

    val selectedToggle by toggleGroup.selectedToggleProperty()

    init {
         add(imageview(null), 0,0)
        /*add(vbox {
            radiobutton("Default", toggleGroup){
                isFocused = true
                action {
                    println(selectedToggle.toString())
                }
            }
            radiobutton("Exact", toggleGroup)
            radiobutton("Palifico", toggleGroup)
        })*/
    }
}