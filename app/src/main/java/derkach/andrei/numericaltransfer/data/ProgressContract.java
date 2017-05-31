package derkach.andrei.numericaltransfer.data;

import android.provider.BaseColumns;

/**
 * Created by Bloom on 30.05.2017.
 * клас контракт для роботи із базою даних
 */

public final class ProgressContract {
    private ProgressContract(){
    }
    /**окремий клас для роботи із таблицею прогресу переведення із десятків
     * у двійки*/
    public static final class DecToBinProgress implements BaseColumns{
        /*назва таблиці*/
        public final static String TABLE_NAME = "dec_to_bin";

        /*назва стовпців таблиці*/
        public final static String _ID = BaseColumns._ID; // головне ключове поле
        public final static String COLUMN_TASK_DEC = "task_dec"; // завдання
        public final static String COLUMN_ANSWER_BIN = "answer_bin"; // відповідь
    }
}
