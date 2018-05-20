package demo.khushal.com.retrofitrxjava.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import demo.khushal.com.retrofitrxjava.beans.GitHubResponse;
import demo.khushal.com.retrofitrxjava.interfaces.ApiInterface;
import demo.khushal.com.retrofitrxjava.utils.RetroFitInstance;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainViewModel extends Observable {

    List<GitHubResponse> gitHubResponses;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void getData(){

        Retrofit retrofit = RetroFitInstance.createSimpleRequest();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Disposable d = apiInterface.getData().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<GitHubResponse>>() {
            @Override
            public void accept(List<GitHubResponse> gitHubResponses) throws Exception {
                //Log.e("adapter", new Gson().toJson(gitHubResponses));
                MainViewModel.this.gitHubResponses = gitHubResponses;
                setChanged();
                notifyObservers();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //Log.e("adapter", Log.getStackTraceString(throwable));
                setChanged();
                notifyObservers();
            }
        });

        compositeDisposable.add(d);

    }



    public List<GitHubResponse> getUserList() {
        return gitHubResponses;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
    }

}
