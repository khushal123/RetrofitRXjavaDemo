package demo.khushal.com.retrofitrxjava.repositories;

import java.util.List;

import demo.khushal.com.retrofitrxjava.beans.GitHubResponse;
import demo.khushal.com.retrofitrxjava.interfaces.ApiInterface;
import demo.khushal.com.retrofitrxjava.utils.RetroFitInstance;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class GithubRepo {

    List<GitHubResponse> gitHubResponses;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void getData(){

        Retrofit retrofit = RetroFitInstance.createSimpleRequest();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Disposable d = apiInterface.getData().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<GitHubResponse>>() {
            @Override
            public void onSuccess(List<GitHubResponse> gitHubResponses) {
                GithubRepo.this.gitHubResponses = gitHubResponses;
            }

            @Override
            public void onError(Throwable e) {
                gitHubResponses = null;
            }
        });

        compositeDisposable.add(d);
    }
}
