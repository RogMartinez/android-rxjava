package com.example.unittesting

class Observable<T>(var value: T ) {

    private val observers: MutableList <(T)->Unit> = mutableListOf()

    fun subscribe(observer: (T) -> Unit){
        observers.add(observer)
        observer(value)
    }

    fun unsubscribe(observer: (T) -> Unit){
        observers.remove(observer)
    }

    fun update(newValue: T){
        value = newValue
        notifyObservers()
    }

    fun notifyObservers(){
        observers.forEach { it(value) }
    }

}