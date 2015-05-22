package com.mccorby.testandroidmccorby.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;

import com.mccorby.testandroidmccorby.domain.entities.Owner;
import com.mccorby.testandroidmccorby.domain.entities.Repository;

/**
 * Created by JAC on 21/05/2015.
 */
public class Mapper {

    public static Repository transform(Cursor cursor) {
        Repository repo = new Repository();
        repo.setDescription(cursor.getString(cursor.getColumnIndex(RepositoryContract.Repository.COLUMN_DESCRIPTION)));
        repo.setName(cursor.getString(cursor.getColumnIndex(RepositoryContract.Repository.COLUMN_NAME)));
        Owner owner = new Owner();
        owner.setLogin(cursor.getString(cursor.getColumnIndex(RepositoryContract.Repository.COLUMN_OWNER)));
        repo.setOwner(owner);
        return repo;
    }

    public static ContentValues transform(Repository repository) {
        ContentValues values = new ContentValues();
        values.put(RepositoryContract.Repository.COLUMN_DESCRIPTION, repository.getDescription());
        values.put(RepositoryContract.Repository.COLUMN_NAME, repository.getName());
        values.put(RepositoryContract.Repository.COLUMN_OWNER, repository.getOwner().getLogin());
        return values;
    }
}
