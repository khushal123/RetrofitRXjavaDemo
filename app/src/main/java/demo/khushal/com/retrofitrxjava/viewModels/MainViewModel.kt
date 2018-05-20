package demo.khushal.com.retrofitrxjava.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log

import com.google.gson.Gson
import java.util.Observable
import java.util.Observer

import demo.khushal.com.retrofitrxjava.beans.GitHubResponse
import demo.khushal.com.retrofitrxjava.interfaces.ApiInterface
import demo.khushal.com.retrofitrxjava.utils.RetroFitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class MainViewModel : Observable() {

    lateinit var userList: List<GitHubResponse>
        internal set

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()
    fun getData() {

        val retrofit = RetroFitInstance.createSimpleRequest()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        val d = apiInterface.data.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ gitHubResponses ->
            //Log.e("adapter", new Gson().toJson(gitHubResponses));
            this@MainViewModel.userList = gitHubResponses
            setChanged()
            notifyObservers()
        }) {
            //Log.e("adapter", Log.getStackTraceString(throwable));
            setChanged()
            notifyObservers()
        }

        compositeDisposable!!.add(d)

    }

    private fun unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable!!.isDisposed) {
            compositeDisposable!!.dispose()
        }
    }

    fun reset() {
        unSubscribeFromObservable()
        compositeDisposable = null
    }

}
