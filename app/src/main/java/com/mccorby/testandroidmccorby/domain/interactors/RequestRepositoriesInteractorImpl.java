package com.mccorby.testandroidmccorby.domain.interactors;

import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.domain.repository.RepositoriesRepository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class RequestRepositoriesInteractorImpl implements RequestRepositoriesInteractor {

    private final RepositoriesRepository mRepository;

    public RequestRepositoriesInteractorImpl(RepositoriesRepository repository) {
        this.mRepository = repository;
    }

    @Override
    public List<Repository> getRepositories() {
        return mRepository.getRepositories();
    }
}
