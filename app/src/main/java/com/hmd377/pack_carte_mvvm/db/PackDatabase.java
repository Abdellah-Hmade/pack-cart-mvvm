package com.hmd377.pack_carte_mvvm.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.hmd377.pack_carte_mvvm.dao.PackDao;
import com.hmd377.pack_carte_mvvm.model.PackModel;

@Database(entities = {PackModel.class},version = 5)
public abstract class PackDatabase extends RoomDatabase {
    public final static String DB_NAME = "Pack";
    private static volatile PackDatabase instance;

    public static synchronized PackDatabase getInstance(Context context){
        if (instance == null) {
            synchronized (PackModel.class){
            instance = Room.databaseBuilder(context.getApplicationContext(), PackDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
            }
        }
        return instance;
    }

    public static Callback roomCallback = new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyncTask(instance);
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PackDao packDao;

        private PopulateDbAsyncTask(PackDatabase db) {

            packDao = db.packDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            packDao.insert(new PackModel("Pack REFLEX 25","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux\n" +"Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +"Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",false));
            packDao.insert(new PackModel("Pack ENERGY 35","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux\n" +"Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +"Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",false));
            packDao.insert(new PackModel("Pack Classic 35","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux","Retraits et paiements au Maroc et à l’étranger\n"+"E-paiement sur les sites nationaux et internationaux\n" +"Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +"Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",false));
            return null;
        }
    }

    public abstract PackDao packDao();

}
