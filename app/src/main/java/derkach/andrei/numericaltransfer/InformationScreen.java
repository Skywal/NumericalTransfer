package derkach.andrei.numericaltransfer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import derkach.andrei.numericaltransfer.data.ProgressContract;
import derkach.andrei.numericaltransfer.data.ProgressDbHelper;

public class InformationScreen extends AppCompatActivity {

    private ProgressDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_screen);

        mDbHelper = new ProgressDbHelper(this);
    }

    /**демонстрація результатів тренування*/
    private void displayDatabaseInfo(){
        /* створемо та відкриємо для читання базу даних*/
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        /*умова для вибірки - список стовбців аналог SELECT*/
        String[] projection = {
                ProgressContract.DecToBinProgress._ID,
                ProgressContract.DecToBinProgress.COLUMN_TASK_DEC,
                ProgressContract.DecToBinProgress.COLUMN_ANSWER_BIN
        };
        /*робимо запит*/
        Cursor cursor = database.query(
                ProgressContract.DecToBinProgress.TABLE_NAME,   // таблиця
                projection,                                     //стовпці
                null,                                           //стовпці для умови WHERE
                null,                                           //значення для умови WHERE
                null,                                           // не групувати ряди
                null,                                           // не фільтрувати за рядами групи
                null                                            //  порядок сортування
        );

        TextView resultsDbText = (TextView) findViewById(R.id.resultsDbText);
        try {
            resultsDbText.setText("Table has " + cursor.getCount() + " results.\n\n");
            resultsDbText.append(ProgressContract.DecToBinProgress._ID + ". "
                    + ProgressContract.DecToBinProgress.COLUMN_TASK_DEC + " - "
                    + ProgressContract.DecToBinProgress.COLUMN_ANSWER_BIN + "\n");

            /*дізнаємося індекс кожного стовпця*/
            int idColumnIndex = cursor.getColumnIndex(ProgressContract.DecToBinProgress._ID);
            int taskColumnIndex = cursor.getColumnIndex(ProgressContract.DecToBinProgress.COLUMN_TASK_DEC);
            int answerColumnIndex = cursor.getColumnIndex(ProgressContract.DecToBinProgress.COLUMN_ANSWER_BIN);

            while (cursor.moveToNext()){
                /*використовуємо індекси для отримання даних*/
                int currentID = cursor.getInt(idColumnIndex);
                int currentTask = cursor.getInt(taskColumnIndex);
                String currentAnswer = cursor.getString(answerColumnIndex);

                resultsDbText.append(currentID + ". "
                        + currentTask + " - "
                        + currentAnswer + "\n");
            }
        }
        catch (Exception e) {

        }
        finally {
            /*Завжди закриваємо курсор після читання*/
            cursor.close();
        }
    }

}
