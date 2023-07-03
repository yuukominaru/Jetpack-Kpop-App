package com.dicoding.myapplication.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dicoding.myapplication.data.KpopRepository
import com.dicoding.myapplication.model.Kpop
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: KpopRepository) : ViewModel() {
    private val _groupedKpop = MutableStateFlow(
        repository.getGroups()
            .groupBy { it.name[0] }
    )
    val groupedKpop: StateFlow<Map<Char, List<Kpop>>> get() = _groupedKpop

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedKpop.value = repository.searchGroups(_query.value)
            .groupBy { it.name[0] }
    }
}
