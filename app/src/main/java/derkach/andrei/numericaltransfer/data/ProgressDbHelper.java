package derkach.andrei.numericaltransfer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
