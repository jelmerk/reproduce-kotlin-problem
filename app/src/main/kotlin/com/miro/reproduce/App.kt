package com.miro.reproduce

import kotlinx.coroutines.*

class App(val crash: Boolean) {

    suspend fun run() {
        myReport()
        println("GC should collect huge array here")

        val b = ByteArray(600_000_000)

        println("Was able to allocate array with size ${b.size}")
    }

    suspend fun myReport(): List<String> {
        return if (crash) {
            runGaqlRequest()
        } else {
            runGaqlRequest2()
        }.map { "some keyword" }

    }

    suspend fun runGaqlRequest(): List<ByteArray>  {
        return withContext(Dispatchers.IO) {
            listOf(ByteArray(600_000_000))
        }
    }

    suspend fun runGaqlRequest2(): List<ByteArray>  {
        return listOf(ByteArray(600_000_000))
    }
}

fun main(args: Array<String>) {
    val crash = args.isNotEmpty() && args[0] == "true"

    val app = App(crash)

    runBlocking {
        app.run()
    }
}
