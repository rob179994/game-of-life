package com.freshmanstudios.board

import com.freshmanstudios.extension.wrap

data class Board(private val xSize: Int, private val ySize: Int, private val startingPoints: List<Pair<Int, Int>> = listOf()){
    private var points: Map<Pair<Int, Int>, Boolean> = startingPoints.associateWith { true }
    private var iteration = 1

    private fun isAlive(point: Pair<Int,Int>): Boolean = points[point] ?: false

    fun iterate(): Board {
        println(toString())
        points = iteratePoints()
        iteration++
        return this
    }

    private fun iteratePoints(): Map<Pair<Int, Int>, Boolean> {
        val points: MutableMap<Pair<Int, Int>, Boolean> = mutableMapOf()
        (0..<ySize).forEach {yPoint ->
            (0..<xSize).forEach {xPoint ->
                if(iteratePoint(Pair(xPoint, yPoint))){
                    points[Pair(xPoint, yPoint)] = true
                }
            }
        }
        return points
    }

    private fun iteratePoint(point: Pair<Int,Int>): Boolean{
        val isAlive = isAlive(point)
        var aliveNeighbourCount = 0

        (point.second-1..point.second+1).forEach {yPoint ->
            (point.first-1..point.first+1).forEach {xPoint ->
                // wrap point that may not be on the board to an existing point using the max x and y vals
                val wrappedPoint = Pair(xPoint, yPoint).wrap(xSize, ySize)

                // don't count yourself
                if(wrappedPoint != point) {
                    aliveNeighbourCount += isAlive(wrappedPoint).let { if(it) 1 else 0 }
                }
            }
        }

        // the 3 rules of game of life
        return isAlive && aliveNeighbourCount == 2 ||
                isAlive && aliveNeighbourCount == 3 ||
                !isAlive && aliveNeighbourCount == 3
    }


    override fun toString(): String = """
------------------------------------------------------------
Iteration: $iteration. Grid size of x: $xSize and y: $ySize
------------------------------------------------------------
${elementString()}
------------------------------------------------------------

        """.trimIndent()

    private fun elementString(): String {
        var elementString = ""
        (0..<ySize).forEach {yPoint ->
            (0..<xSize).forEach {xPoint ->
                if(xPoint!=0){
                    elementString += " "
                }

                elementString += isAlive(Pair(xPoint, yPoint)).let { if(it) "O" else "-" }
            }
            if(yPoint < ySize - 1){
                elementString += "\n"
            }
        }
        return elementString
    }
}