package com.example

fun useStdlib() {
    val x = (1..10).filter { it % 2 == 0 }.toSet()
    x.forEach { println(it) }
}