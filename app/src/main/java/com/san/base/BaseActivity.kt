package com.san.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.san.GankApplication
import com.san.di.component.buildAndInject
import com.evernote.android.state.StateSaver
import com.uber.autodispose.*
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.*
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.parallel.ParallelFlowable

abstract class BaseActivity : AppCompatActivity() {
    private val scopeProvider by lazy { AndroidLifecycleScopeProvider.from(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as GankApplication).component
            .newActivityComponentBuilder().buildAndInject(this)
        super.onCreate(savedInstanceState)
        StateSaver.restoreInstanceState(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState)
    }

    fun <T : ViewModel> getViewModel(key: String, modelClass: Class<T>) =
        getViewModelProvider(this).get(key, modelClass)

    fun <T : ViewModel> getViewModel(modelClass: Class<T>) =
        getViewModelProvider(this).get(modelClass)

    fun getViewModelProvider(fragment: Fragment) =
        ViewModelProviders.of(fragment, (application as GankApplication).viewModelFactory)

    fun getViewModelProvider(activity: FragmentActivity) =
        ViewModelProviders.of(activity, (application as GankApplication).viewModelFactory)

    /**
     * Modified from https://github.com/uber/AutoDispose
     */
    @CheckReturnValue
    fun <T> Flowable<T>.autoDisposable(): FlowableSubscribeProxy<T> =
        this.`as`(AutoDispose.autoDisposable(scopeProvider))

    @CheckReturnValue
    fun <T> Observable<T>.autoDisposable(): ObservableSubscribeProxy<T> =
        this.`as`(AutoDispose.autoDisposable(scopeProvider))

    @CheckReturnValue
    fun <T> Single<T>.autoDisposable(): SingleSubscribeProxy<T> =
        this.`as`(AutoDispose.autoDisposable(scopeProvider))

    @CheckReturnValue
    fun <T> Maybe<T>.autoDisposable(): MaybeSubscribeProxy<T> =
        this.`as`(AutoDispose.autoDisposable(scopeProvider))

    @CheckReturnValue
    fun Completable.autoDisposable(): CompletableSubscribeProxy =
        this.`as`(AutoDispose.autoDisposable<Any>(scopeProvider))

    @CheckReturnValue
    fun <T> ParallelFlowable<T>.autoDisposable(): ParallelFlowableSubscribeProxy<T> =
        this.`as`(AutoDispose.autoDisposable(scopeProvider))
}
