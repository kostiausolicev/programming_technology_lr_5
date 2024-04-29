package ru.kosti.lr5.presenter

import javafx.event.ActionEvent
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import javafx.scene.shape.Circle
import ru.kosti.lr5.util.find
import ru.kosti.lr5.util.stations
import java.lang.StringBuilder

class MainPresenter {

    lateinit var stationA: Label
    lateinit var stationB: Label
    lateinit var createWayButton: Button
    lateinit var listview: ListView<String>
    lateinit var perivaleStation: Circle
    lateinit var greenfordStation: Circle
    lateinit var hangerLaneStation: Circle
    lateinit var northActonStation: Circle
    lateinit var sourthHarrowStaion: Circle
    lateinit var sudburyHillStaion: Circle
    lateinit var alpertonStaion: Circle
    lateinit var royalParkStaion: Circle
    lateinit var northEarlingStation: Circle
    lateinit var earlingBroadwayStation: Circle
    lateinit var earlingCommonGreen: Circle
    lateinit var earlingCommonBlue: Circle
    lateinit var actonTownBlue: Circle
    lateinit var actonTownGreen: Circle
    lateinit var chiswickParkStation: Circle
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
        val stationStart = when (stationA.text.split(':')[1]) {
            "Greenfort" -> stations[0]
            else -> stations[8]
        }
        val stationFinish = when (stationB.text.split(':')[1]) {
            "Greenford" -> stations[0]
            else -> stations[8]
        }
        val res = find(stationStart, stationFinish)
        listview.items.add(res.first?.toString() ?: throw Exception())
        res.second?.forEach { edge ->
            val text = "${edge.stationA.name} -> ${edge.stationB.name} : ${edge.weight}m ${edge.type}"
            listview.items.add(text)
        }
    }
}
