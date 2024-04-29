package ru.kosti.lr5.presenter

import javafx.event.ActionEvent
import javafx.scene.Group
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import ru.kosti.lr5.util.find
import ru.kosti.lr5.util.stationsMap


class MainPresenter {

    lateinit var stationA: Label
    lateinit var stationB: Label
    lateinit var createWayButton: Button
    lateinit var listview: ListView<String>
    fun updateLables(mouseEvent: MouseEvent) {
        val group = mouseEvent.source as Group
        val name = group.children.firstNotNullOf { it as? Label }.text
        if (stationA.text.split(':')[1] == "") {
            stationA.text += name
        } else if (stationB.text.split(':')[1] == "") {
            stationB.text += name
        } else {
            stationA.text = stationA.text.split(':')[0] + ':' + name
            stationB.text = stationB.text.split(':')[0] + ':'
        }
    }

    fun createWayButttonActive(actionEvent: ActionEvent) {
        try {
            listview.items.clear()
            val a = stationA.text.split(':')[1]
            val b = stationB.text.split(':')[1]
            val stationStart = stationsMap[a] ?: throw Exception("Неверное имя станции А")
            val stationFinish = stationsMap[b] ?: throw Exception("Неверное имя станции В")
            val res = find(stationStart, stationFinish)
            listview.items.add(res.first?.toString() ?: "0")
            res.second?.forEach { edge ->
                val text = "${edge.stationA.name} -> ${edge.stationB.name} : ${edge.weight}m ${edge.type}"
                listview.items.add(text)
            }
        } catch (ex: Exception) {
            val alert = Alert(Alert.AlertType.CONFIRMATION)
            alert.title = "Ошибка"
            alert.headerText = ex.message
            alert.showAndWait()
        }
    }
}
