package derkach.andrei.numericaltransfer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Bloom on 31.05.2017.
 * допоміжний клас для роботи із базою даних
 */

public class ProgressDbHelper extends SQLiteOpenHelper {

    /**назва файлу бази даних*/
    public static final String DATABASE_NAME = "progress.db";
    /**версія бази даних
     * якщо змінюється схема бази то збільшувати на один*/
    public static final int DATABASE_VERSION = 1;
    /**для запису в лог*/
    public static final String LOG_TAG = ProgressDbHelper.class.getName();

    /**Конструктор*/
    public ProgressDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**Викликається при створенні бази данних*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*рядок для створення таблиці*/
        String SQL_CREATE_PROGRESS_TABLE = "create table "
                + ProgressContract.DecToBinProgress.TABLE_NAME + " ("
                + ProgressContract.DecToBinProgress._ID + " integer primary key autoincrement,"
                + ProgressContract.DecToBinProgress.COLUMN_TASK_DEC + " integer not null,"
                + ProgressContract.DecToBinProgress.COLUMN_ANSWER_BIN + " string not null);";

        /*запускаємо створення таблиці*/
        sqLiteDatabase.execSQL(SQL_CREATE_PROGRESS_TABLE);
    }

    /**Викликається при обнові схеми бази данних*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        /*запишемо в журнал*/
        Log.w("SQLite","Update from version " + oldVersion + " on version " + newVersion);

        /*видаляємо стару базу даних*/
        sqLiteDatabase.execSQL("drop table if it " + ProgressContract.DecToBinProgress.TABLE_NAME);
        /*створюємо нову базу*/
        onCreate(sqLiteDatabase);
    }

    /**викликати при знищенні бази даних*/
    public void onDrop(SQLiteDatabase sqLiteDatabase){
        //рядок для знищення бази данних
        String SQL_DROP_PROGRESS_TABLE = "drop table if exists "
                + ProgressContract.DecToBinProgress.TABLE_NAME;

        //знищення таблиці/
        sqLiteDatabase.execSQL(SQL_DROP_PROGRESS_TABLE);
    }
}
