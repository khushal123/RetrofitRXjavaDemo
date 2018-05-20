package demo.khushal.com.retrofitrxjava.beans;

import com.google.gson.annotations.SerializedName;

public class GitHubResponse {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("full_name")
    String full_name;
    @SerializedName("html_url")
    String html_url;
    @SerializedName("description")
    String description;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("updated_at")
    String updated_at;
    @SerializedName("git_url")
    String git_url;

    public class Owner{
        @SerializedName("login")
        String login;
        @SerializedName("id")
        String id;
        @SerializedName("avatar_url")
        String avatar_url;
        @SerializedName("url")
        String url;
    }
}
