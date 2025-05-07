package com.example.zewtaskandroid.presentation.viewmodel

import com.example.zewtaskandroid.data.model.MenuItem

class Order {
    private val items = mutableListOf<MenuItem>()

    val total: Int
        get() = items.sumOf { it.price }

    fun add(item: MenuItem) {
        items.add(item)
    }

    fun remove(item: MenuItem) {
        items.remove(item)
    }

    fun getItems(): List<MenuItem> = items.toList()
}