package com.mccorby.testandroidmccorby.datasource;

import android.util.Base64;

import com.mccorby.testandroidmccorby.BuildConfig;
import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by JAC on 21/05/2015.
 */
public class NetworkDatasourceImpl implements NetworkDatasource {

    /**
     * This could be a singleton.
     */
    private RestAdapter mRestAdapter;


    public NetworkDatasourceImpl(String apiUrl) {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(apiUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();
    }

    /**
     * A custom interceptor to add required headers to the request.
     */
    RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            request.addHeader("Accept", "application/vnd.github.v3+json");

            request.addHeader("Authorization", encodeAuth(BuildConfig.AUTH_USERNAME, BuildConfig.AUTH_TOKEN));
        }
    };


    @Override
    public List<Repository> getRepositories() {
        GithubApiService service = mRestAdapter.create(GithubApiService.class);
        return service.retrieveRepositories();
    }

    private String encodeAuth(String username, String token) {
        String source = username + ":" + token;
        String result = "Basic " + Base64.encodeToString(source.getBytes(), Base64.URL_SAFE | Base64.NO_WRAP);

        return result;
    }
}
