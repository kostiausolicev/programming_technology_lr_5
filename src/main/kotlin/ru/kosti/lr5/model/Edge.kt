package ru.kosti.lr5.model

import ru.kosti.lr5.emuns.EdgeType

data class Edge(
    val stationA: Station,
    val stationB: Station,
    val weight: Int,
    val type: EdgeType
)