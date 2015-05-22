package com.mccorby.testandroidmccorby;

import com.mccorby.testandroidmccorby.datasource.DatasourceModule;
import com.mccorby.testandroidmccorby.domain.interactors.InteractorsModule;
import com.mccorby.testandroidmccorby.domain.interactors.RequestRepositoriesInteractor;
import com.mccorby.testandroidmccorby.repository.RepositoriesRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JAC on 22/05/2015.
 */
@Singleton

@Component (modules = {
        ChallengeAppModule.class,
        InteractorsModule.class,
        RepositoriesRepositoryModule.class,
        DatasourceModule.class
})
public interface ChallengeAppComponent {

    void inject(ChallengeApp app);

    RequestRepositoriesInteractor getRequestRepositoriesInteractor();
}
