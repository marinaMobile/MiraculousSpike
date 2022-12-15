package com.aqupepgames.projectp.one

import kotlin.random.Random


data class SingleUser(
    val idddd: Int = Random.nextInt(from = 1, until = 10000),
    val nameeee: String
)  {
    val listNames = listOf("sasha", "masha", "roma", "denis", "eva", "nastya", "kolya", "john", "noname", "rembo", "frodo", "gimli")
}
