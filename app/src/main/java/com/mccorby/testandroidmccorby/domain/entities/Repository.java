package com.mccorby.testandroidmccorby.domain.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Class representing a repository in Github.
 *
 * For simplicity sake I am using the same models for the domain, presentation and data layers
 * meaning this class is coupled to Gson.
 *
 * Created by JAC on 21/05/2015.
 */
public class Repository {

    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String description;
    @SerializedName("owner")
    private Owner  mOwner;
    @SerializedName("fork")
    private boolean mFork;
    @SerializedName("html_url")
    private String mHtmlUrl;


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public boolean isFork() {
        return mFork;
    }

    public void setFork(boolean fork) {
        mFork = fork;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }
}
