package com.dicoding.courseschedule.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.courseschedule.data.DataRepository
import com.dicoding.courseschedule.util.QueryType
import kotlinx.coroutines.launch

class HomeViewModel(repository: DataRepository) : ViewModel() {

    private val _queryType = MutableLiveData<QueryType>()
    val todaySchedule = Transformations.switchMap(_queryType){ repository.getNearestSchedule(it) }

    init {
        _queryType.value = QueryType.CURRENT_DAY
    }

    fun setQueryType(queryType: QueryType) {
        _queryType.value = queryType
    }
}