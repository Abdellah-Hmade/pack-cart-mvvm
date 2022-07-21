package com.hmd377.pack_carte_mvvm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hmd377.pack_carte_mvvm.dao.PackDao;
import com.hmd377.pack_carte_mvvm.db.PackDatabase;
import com.hmd377.pack_carte_mvvm.model.PackModel;

import java.util.List;

public class PackRepository {

    private PackDao packDao;
    private LiveData<List<PackModel>> allPacks;

    public PackRepository(Application application){
        PackDatabase db = PackDatabase.getInstance(application);
        packDao = db.packDao();
        allPacks = packDao.getAllPacks();
    }

    public void insert(PackModel pack){
        new InsertNoteAsyncTask(packDao).execute(pack);
    }

    public void update(PackModel pack) {
        new UpdateNoteAsyncTask(packDao).execute(pack);
    }

    /*@Override
    public void delete(PackModel pack) {

    }*/

    public LiveData<List<PackModel>> getAllPacks() {
        return allPacks;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<PackModel, Void, Void> {
        private PackDao packDao;

        private InsertNoteAsyncTask(PackDao packDao) {
            this.packDao = packDao;
        }

        @Override
        protected Void doInBackground(PackModel... packs) {
            packDao.insert(packs[0]);
            return null;
        }
    }


    private static class UpdateNoteAsyncTask extends AsyncTask<PackModel, Void, Void> {
        private PackDao packDao;

        private UpdateNoteAsyncTask(PackDao packDao) {
            this.packDao = packDao;
        }

        @Override
        protected Void doInBackground(PackModel... packs) {
            packDao.update(packs[0]);
            return null;
        }
    }
}
