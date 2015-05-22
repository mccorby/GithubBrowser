package com.mccorby.testandroidmccorby.datasource;

import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by JAC on 21/05/2015.
 */
public interface GithubApiService {

    @GET("/repos")
    List<Repository> retrieveRepositories();
}
