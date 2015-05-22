package com.mccorby.testandroidmccorby.repository;

import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.domain.repository.RepositoriesRepository;
import com.mccorby.testandroidmccorby.repository.datasource.CacheDatasource;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class RepositoriesRepositoryImpl implements RepositoriesRepository {

    private NetworkDatasource mNetworkDatasource;
    private CacheDatasource mCacheDatasource;

    public RepositoriesRepositoryImpl(NetworkDatasource networkDatasource, CacheDatasource cacheDatasource) {
        this.mNetworkDatasource = networkDatasource;
        this.mCacheDatasource = cacheDatasource;
    }

    @Override
    public List<Repository> getRepositories() {
        // TODO Retrieve the values from the cache after calling the network
        List<Repository> repos = mNetworkDatasource.getRepositories();
        if (mCacheDatasource != null) {
            mCacheDatasource.addRepositories(repos);
        }
        return repos;
    }
}
