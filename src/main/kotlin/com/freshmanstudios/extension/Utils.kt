package com.freshmanstudios.extension

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