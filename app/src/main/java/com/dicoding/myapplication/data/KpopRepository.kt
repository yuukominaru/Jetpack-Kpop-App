package com.dicoding.myapplication.data

import com.dicoding.myapplication.model.Kpop
import com.dicoding.myapplication.model.KpopData

class KpopRepository {
    fun getGroups(): List<Kpop> {
        return KpopData.kpop
    }

    fun searchGroups(query: String): List<Kpop>{
        return KpopData.kpop.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}