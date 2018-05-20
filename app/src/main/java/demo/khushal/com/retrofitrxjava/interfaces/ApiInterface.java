package demo.khushal.com.retrofitrxjava.interfaces;

import java.util.List;
import java.util.Observable;

import demo.khushal.com.retrofitrxjava.beans.GitHubResponse;
import demo.khushal.com.retrofitrxjava.utils.Api;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET(Api.repo_url)
    io.reactivex.Observable<List<GitHubResponse>> getData();

}
