package ru.kosti.lr5.util

import ru.kosti.lr5.model.Edge
import ru.kosti.lr5.model.Station

fun find(stationA: Station, stationB: Station): Pair<Int?, List<Edge>?> {
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
    val previous = mutableMapOf<Station, Edge>()
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
            for (edge in edges[currentStation] ?: throw NullPointerException()) {
                val newWeight = weights[edge.stationA]!! + edge.weight
                if (newWeight < (weights[edge.stationB] ?: Int.MAX_VALUE)) {
                    weights[edge.stationB] = newWeight
                    previous[edge.stationB] = edge
                }
            }
            visits[currentStation] = true
        } catch (ex: NullPointerException) {
            return null to null
        }
    }
    var path: List<Edge>? = null
    weights[stationB]?.let {
        var currentStation = stationB
        path = mutableListOf<Edge>()
        while (currentStation != stationA) {
            path = path!! + previous[currentStation]!!
            currentStation = previous[currentStation]!!.stationA
        }
        path = path!!.reversed()
    }
    return weights[stationB] to path
}