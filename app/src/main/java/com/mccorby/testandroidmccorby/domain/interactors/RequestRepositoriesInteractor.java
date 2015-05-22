package com.mccorby.testandroidmccorby.domain.interactors;

import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public interface RequestRepositoriesInteractor {

    /**
     * Retrieve a list of repositories from Github.
     * @return the list of Repository objects
     */
    List<Repository> getRepositories();
}
