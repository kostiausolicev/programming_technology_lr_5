package ru.kosti.lr5.util

import ru.kosti.lr5.model.Station

fun find(stationA: Station, stationB: Station): Pair<Int?, List<Station>?> {
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
    val previous = mutableMapOf<Station, Station>()
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
                val newWeight = weights[st.stationA]!! + st.weight
                if (newWeight < (weights[st.stationB] ?: Int.MAX_VALUE)) {
                    weights[st.stationB] = newWeight
                    previous[st.stationB] = st.stationA
                }
            }
            visits[currentStation] = true
        } catch (ex: NullPointerException) {
            return null to null
        }
    }
    var path: List<Station>? = null
    weights[stationB]?.let {
        var currentStation = stationB
        path = mutableListOf<Station>()
        while (currentStation != stationA) {
            path = path!! + currentStation
            currentStation = previous[currentStation] ?: break
        }
        path = path!! + stationA
        path = path!!.reversed()
    }
    return weights[stationB] to path
}