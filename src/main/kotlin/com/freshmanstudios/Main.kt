package com.freshmanstudios

import com.freshmanstudios.board.BoardPreset

fun main() {
    val iterations = 16
    val board = BoardPreset.PENTADECATHLON.board
    (1..iterations).forEach { _ -> board.iterate() }
}