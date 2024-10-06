package com.freshmanstudios.board

/**
 * Some standard periodic presets for the board configurations. More could be added
 */
enum class BoardPreset(val board: Board) {
    BLINKER(
        board = Board(
            xSize = 5,
            ySize = 5,
            startingPoints = listOf(Pair(1,2), Pair(2,2), Pair(3,2))
        )
    ),
    TOAD(
        board = Board(
            xSize = 6,
            ySize = 6,
            startingPoints = listOf(
                Pair(2,2), Pair(3,2), Pair(4,2),
                Pair(1,3), Pair(2,3), Pair(3,3)
            )
        )
    ),
    BEACON(
        board = Board(
            xSize = 6,
            ySize = 6,
            startingPoints = listOf(
                Pair(1,1), Pair(2,1),
                Pair(1,2), Pair(2,2),
                Pair(3,3), Pair(4,3),
                Pair(3,4), Pair(4,4)
            )
        )
    )
}