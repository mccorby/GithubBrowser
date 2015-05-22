package com.mccorby.testandroidmccorby.domain.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JAC on 21/05/2015.
 */
public class Owner {

    @SerializedName("login")
    private String mLogin;
    @SerializedName("html_url")
    private String mHtmlUrl;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }
}
