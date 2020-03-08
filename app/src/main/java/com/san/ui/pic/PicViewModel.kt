package com.san.ui.pic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.san.backend.api.PicApi
import com.san.backend.model.MeiziPic
import com.san.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PicViewModel @Inject constructor(
    private val picApi: PicApi
) : BaseViewModel() {
    val liveDataPic: LiveData<MeiziPic> = MutableLiveData()

    init {
        fetchOnePic()
    }

    fun fetchOnePic() {
        liveDataPic as MutableLiveData
        picApi.getMeiziPics(1, (1..10).random())
            .subscribeOn(Schedulers.io()).doOnError {

            }
            .autoDisposable()
            .subscribe { response ->
                liveDataPic.postValue(response.results[0])
            }
    }
}
