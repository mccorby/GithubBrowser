package com.mccorby.testandroidmccorby.repository.datasource;

import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public interface CacheDatasource {

    void addRepositories(List<Repository> repositoryList);
    List<Repository> getRepositories();
}
