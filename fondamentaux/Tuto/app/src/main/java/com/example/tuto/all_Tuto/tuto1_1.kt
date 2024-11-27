package com.example.tuto.all_Tuto

fun main() {
    val trafficLightColor = "Red"

    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)
}