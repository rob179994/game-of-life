package com.freshmanstudios.extension

/**
 * Wraps a point round on the board to an actual existing point in every dimension. E.g. (-1,2) on a 5 by 5
 * board wraps to (4,2). This essentially makes every dimension infinite due to wrapping characteristic.
 */
fun Pair<Int, Int>.wrap(xLimit: Int, yLimit: Int): Pair<Int, Int>{
    val newX = if(first < 0){
        first + xLimit
    } else if(first >= xLimit) {
        first - xLimit
    } else first

    val newY = if(second < 0){
        second + yLimit
    } else if(second >= yLimit) {
        second - yLimit
    } else second

    return Pair(newX, newY)
}