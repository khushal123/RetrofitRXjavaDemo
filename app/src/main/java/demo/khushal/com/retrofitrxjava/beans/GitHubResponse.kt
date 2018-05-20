package demo.khushal.com.retrofitrxjava.beans

import android.databinding.BaseObservable
import android.databinding.Bindable

import com.google.gson.annotations.SerializedName

import java.util.Observable

class GitHubResponse : BaseObservable() {
    @SerializedName("id")
    lateinit var id: String
    @SerializedName("name")
    @get:Bindable
    lateinit var name: String
    @SerializedName("full_name")
    lateinit var full_name: String
    @SerializedName("html_url")
    @get:Bindable
    lateinit var html_url: String
    @SerializedName("description")
    lateinit var description: String
    @SerializedName("created_at")
    @get:Bindable
    lateinit var created_at: String
    @SerializedName("updated_at")
    lateinit var updated_at: String
    @SerializedName("git_url")
    lateinit var git_url: String

    @SerializedName("owner")
    lateinit var owner: Owner

    inner class Owner {
        @SerializedName("login")
        lateinit var login: String
        @SerializedName("id")
        lateinit var id: String
        @SerializedName("avatar_url")
        lateinit var avatar_url: String
        @SerializedName("url")
        lateinit var url: String
    }
}
