package com.mccorby.testandroidmccorby.domain.repository;

import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public interface RepositoriesRepository {

    List<Repository> getRepositories();
}
