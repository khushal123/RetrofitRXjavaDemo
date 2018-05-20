package demo.khushal.com.retrofitrxjava.interfaces

import java.util.Observable

import demo.khushal.com.retrofitrxjava.beans.GitHubResponse
import demo.khushal.com.retrofitrxjava.utils.Api
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @get:GET(Api.repo_url)
    val data: io.reactivex.Observable<List<GitHubResponse>>

}
