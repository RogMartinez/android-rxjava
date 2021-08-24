package com.example.unittesting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object ItemsProvider {
    val observable = Observable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val rndm = Random(100)

    fun starEmitting(){
        GlobalScope.launch(Dispatchers.Main) {
            while(true){
                delay(5000)
                values = values + rndm.nextInt().toString()
                observable.update(values)
            }
        }
    }

    fun addValuesTo(value:String){
        values = values + value
    }
}