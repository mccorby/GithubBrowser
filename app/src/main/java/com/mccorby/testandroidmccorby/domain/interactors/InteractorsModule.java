package com.mccorby.testandroidmccorby.domain.interactors;

import com.mccorby.testandroidmccorby.domain.repository.RepositoriesRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JAC on 22/05/2015.
 */
@Module
public class InteractorsModule {

    @Provides
    public RequestRepositoriesInteractor provideRequestRepositoriesInteractor(RepositoriesRepository repository) {
        return new RequestRepositoriesInteractorImpl(repository);
    }
}
