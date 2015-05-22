package com.mccorby.testandroidmccorby.repository;

import com.mccorby.testandroidmccorby.domain.repository.RepositoriesRepository;
import com.mccorby.testandroidmccorby.repository.datasource.CacheDatasource;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JAC on 22/05/2015.
 */
@Module
public class RepositoriesRepositoryModule {

    @Provides
    public RepositoriesRepository provideRepositoriesRepository(NetworkDatasource networkDatasource, CacheDatasource cacheDatasource) {
        return new RepositoriesRepositoryImpl(networkDatasource, cacheDatasource);
    }
}
