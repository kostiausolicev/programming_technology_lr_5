package ru.kosti.lr5

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import ru.kosti.lr5.util.find
import ru.kosti.lr5.util.initialize
import ru.kosti.lr5.util.stations

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        initialize()
        val a = stations[0]
        val b = stations[4]
        println(find(stationA = a, stationB = b))
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}