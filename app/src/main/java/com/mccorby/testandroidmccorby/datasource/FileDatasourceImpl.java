package com.mccorby.testandroidmccorby.datasource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class FileDatasourceImpl implements NetworkDatasource {

    private InputStream mInputStream;

    public FileDatasourceImpl(InputStream file) {
        this.mInputStream = file;
    }

    @Override
    public List<Repository> getRepositories() {
        Type listType = new TypeToken<ArrayList<Repository>>() {
        }.getType();
        List<Repository> repos = new Gson().fromJson(new InputStreamReader(mInputStream), listType);
        return repos;
    }
}
