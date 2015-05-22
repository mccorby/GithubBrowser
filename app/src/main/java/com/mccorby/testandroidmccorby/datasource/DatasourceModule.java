package com.mccorby.testandroidmccorby.datasource;

import android.content.Context;

import com.mccorby.testandroidmccorby.repository.datasource.CacheDatasource;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JAC on 22/05/2015.
 */
@Module
public class DatasourceModule {
    @Provides
    public NetworkDatasource provideNetworkDatasource() {
        // TODO Inject this via EndPoint. See here http://www.future-processing.pl/blog/dependency-injection-with-dagger-2/
        String url = "https://api.github.com/users/mccorby";
        return new NetworkDatasourceImpl(url);
    }

    @Provides
    public CacheDatasource provideCacheDatasource(Context context) {
        return new CacheDatasourceImpl(context);
    }
}
