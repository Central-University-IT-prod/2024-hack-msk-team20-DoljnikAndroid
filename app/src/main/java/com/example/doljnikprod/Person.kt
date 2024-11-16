package com.example.doljnikprod;

import android.app.Person

data class Transaction (val name: String, val money: Int)

class Person(val name: String) {
    // Map (key: person name, mean: dips)
    val debtors = mutableMapOf<String, Int>()
    val history = mutableListOf<Transaction>()

    fun addPerson(name: String){
        debtors[name] = 0
    }

    fun adddebtPlus(person: String, debt: Int){
        debtors[person] = debtors[person]!! + debt
        history.add(Transaction(person, debt))
    }
    fun adddebtMinus(person: String, debt: Int){
        debtors[person] = debtors[person]!! - debt
        history.add(Transaction(person, -debt))
    }

}

