package com.game.randomCatFacts.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.game.randomCatFacts.data.remote.CatApi
import com.game.randomCatFacts.data.remote.CatListItem
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatListViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    private val _listLiveDate = MutableLiveData<CatListItem>()
    val listLiveData: LiveData<CatListItem> = _listLiveDate

    fun fetchCatList(catApi: CatApi) {
        viewModelScope.launch(Dispatchers.IO) {
            _listLiveDate.postValue(catApi.getCatList())
        }
    }
}