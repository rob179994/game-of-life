package com.freshmanstudios

import com.freshmanstudios.board.BoardPreset
import com.freshmanstudios.extension.wrap

fun main() {
    val iterations = 5
    val board = BoardPreset.BLINKER.board
    (1..iterations).forEach { _ -> board.iterate() }
}