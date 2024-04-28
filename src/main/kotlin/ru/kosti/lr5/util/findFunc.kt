package ru.kosti.lr5.util

import ru.kosti.lr5.model.Station
import kotlin.math.min

fun find(stationA: Station, stationB: Station): Int? {
    val visits = mutableMapOf<Station, Boolean>().also {
        stations.forEach { st ->
            it[st] = false
        }
    }
    val weights = mutableMapOf<Station, Int>().also {
        stations.forEach { st ->
            if (st == stationA)
                it[st] = 0
            else
                it[st] = Int.MAX_VALUE
        }
    }
    while (visits.containsValue(false)) {
        var minWeight = Int.MAX_VALUE
        lateinit var currentStation: Station
        for ((st, v) in visits) {
            if (v)
                continue
            if ((weights[st] ?: Int.MAX_VALUE) < minWeight) {
                minWeight = weights[st] ?: Int.MAX_VALUE
                currentStation = st
            }
        }
        try {
            for (st in edges[currentStation] ?: throw NullPointerException()) {
                weights[st.stationB] = min(weights[st.stationA]!! + st.weight, weights[stationB]!!)
            }
            visits[currentStation] = true
        } catch (ex: NullPointerException) {
            return null
        }
    }
    return weights[stationB]
}