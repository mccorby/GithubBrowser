package com.mccorby.testandroidmccorby.datasource;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mccorby.testandroidmccorby.datasource.cache.Mapper;
import com.mccorby.testandroidmccorby.datasource.cache.RepositoryContract;
import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.repository.datasource.CacheDatasource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class CacheDatasourceImpl implements CacheDatasource {

    private Context mContext;

    public CacheDatasourceImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void addRepositories(List<Repository> repositoryList) {
        ContentResolver cr = mContext.getContentResolver();
        Uri uri = RepositoryContract.REPOSITORIES_URI;
        for (Repository repo : repositoryList) {
            ContentValues values = Mapper.transform(repo);
            cr.insert(uri, values);
        }
    }

    @Override
    public List<Repository> getRepositories() {
        List<Repository> result = new ArrayList<>();
        Uri uri = RepositoryContract.REPOSITORIES_URI;
        Cursor cursor = mContext.getContentResolver().query(uri,
                RepositoryContract.Repository.ALL_COLUMNS_PROJECTION, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                result.add(Mapper.transform(cursor));
            }
            cursor.close();
        }
        return result;
    }
}
