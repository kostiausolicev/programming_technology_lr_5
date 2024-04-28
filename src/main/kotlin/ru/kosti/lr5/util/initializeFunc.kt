package ru.kosti.lr5.util

import ru.kosti.lr5.emuns.EdgeType
import ru.kosti.lr5.emuns.LineEnum
import ru.kosti.lr5.model.Edge
import ru.kosti.lr5.model.Station

val stations: MutableList<Station> = mutableListOf()
val edges: MutableMap<Station, MutableList<Edge>> = mutableMapOf()

fun initialize() {
    // Red line
    val greenford = Station(name = "Greenford", line = LineEnum.RED).also { stations.add(it) }
    val perivale = Station(name = "Perivale", line = LineEnum.RED).also { stations.add(it) }
    val hangerLane = Station(name = "Hanger Lane", line = LineEnum.RED).also { stations.add(it) }
    val nortActon = Station(name = "North Acton", line = LineEnum.RED).also { stations.add(it) }
    Edge(stationA = greenford, stationB = perivale, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = perivale, stationB = hangerLane, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = hangerLane, stationB = nortActon, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = perivale, stationB = greenford, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = hangerLane, stationB = perivale, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = nortActon, stationB = hangerLane, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }

    // Blue line
    val southHarrow = Station(name = "South Harrow", line = LineEnum.BLUE).also { stations.add(it) }
    val sudburyHill = Station(name = "Sudbury Hill", line = LineEnum.BLUE).also { stations.add(it) }
    val alperton = Station(name = "Alperton", line = LineEnum.BLUE).also { stations.add(it) }
    val parkRoyal = Station(name = "Park Royal", line = LineEnum.BLUE).also { stations.add(it) }
    val earlingCommonBlue = Station(name = "Earling Common", line = LineEnum.BLUE).also { stations.add(it) }
    val actonTownBlue = Station(name = "Acton Town", line = LineEnum.BLUE).also { stations.add(it) }

    Edge(stationA = southHarrow, stationB = sudburyHill, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = sudburyHill, stationB = alperton, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = alperton, stationB = parkRoyal, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = parkRoyal, stationB = earlingCommonBlue, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonBlue, stationB = actonTownBlue, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = sudburyHill, stationB = southHarrow, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = alperton, stationB = sudburyHill, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = parkRoyal, stationB = alperton, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonBlue, stationB = parkRoyal, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = actonTownBlue, stationB = earlingCommonBlue, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }

    // Green line
    val ealingBroadway = Station(name = "Ealing Broadway", line = LineEnum.GREEN).also { stations.add(it) }
    val earlingCommonGreen = Station(name = "Earling Common", line = LineEnum.GREEN).also { stations.add(it) }
    val actonTownGreen = Station(name = "Acton Town", line = LineEnum.GREEN).also { stations.add(it) }
    val chiswickPark = Station(name = "Chiswick Park", line = LineEnum.GREEN).also { stations.add(it) }
    Edge(stationA = ealingBroadway, stationB = earlingCommonGreen, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonGreen, stationB = actonTownGreen, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = actonTownGreen, stationB = chiswickPark, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonGreen, stationB = ealingBroadway, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = actonTownGreen, stationB = earlingCommonGreen, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = chiswickPark, stationB = actonTownGreen, weight = 3, type = EdgeType.TRAIN).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }

    // Add walk transfers
    Edge(stationA = hangerLane, stationB = parkRoyal, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = parkRoyal, stationB = hangerLane, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonGreen, stationB = earlingCommonBlue, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = earlingCommonBlue, stationB = earlingCommonGreen, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = actonTownGreen, stationB = actonTownBlue, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
    Edge(stationA = actonTownBlue, stationB = actonTownGreen, weight = 1, type = EdgeType.WALK).also {
        if (edges.containsKey(it.stationA))
            edges[it.stationA]!!.add(it)
        else
            edges[it.stationA] = mutableListOf(it)
    }
}