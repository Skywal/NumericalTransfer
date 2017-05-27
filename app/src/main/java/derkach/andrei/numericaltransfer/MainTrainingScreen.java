package derkach.andrei.numericaltransfer;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainTrainingScreen extends AppCompatActivity {
    /**теекст таймеру*/
    TextView timerText;
    /**час на зворотній відлік у секудах*/
    long timerCount;
    /**текст завдання що виводиться для вирішення*/
    TextView taskText;
    /**відповідь що вводиться гравцем*/
    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_training);

        /**привязка до віджетів на екрані*/
        timerText = (TextView) findViewById(R.id.timerText);
        taskText = (TextView) findViewById(R.id.taskText);
        answerText = (TextView) findViewById(R.id.answerText);

        /**виставляжмо секундний таймер*/
        timerCount = 30;

        /**таймер зворотнього відліку, зміни демонструються через 1000 мілісекунд*/
        new CountDownTimer(millisecondsFromSeconds(), 1000){

            @Override
            public void onTick(long millisecondsUntilFinish) {
                timerText.setText(millisecondsUntilFinish / 1000 + "");
            }

            @Override
            public void onFinish() {
                timerText.setText("done");
                //викликаємо діалог по закінченню часу
                timeOverDialog();
            }
        }.start();
    }
    /**обробник апаратної кнопки назад*/
    @Override
    public void onBackPressed(){
        Toast.makeText(this,"Натиснуто НАЗАД", Toast.LENGTH_SHORT).show();
    }
    /**обробник натиснення кнопки ПІДТВЕРДЖЕННЯ*/
    public void confirmButtonPush (View view){
        /**для тесту*/
        Toast.makeText(this,"Натиснуто ПІДТВЕРДИТИ", Toast.LENGTH_SHORT).show();
    }
    /**обробник натиснення кнопки ВІДПОВІДЬ*/
    public void answerButtonPush (View view){
        /**для тесту*/
        Toast.makeText(this,"Натиснуто ВІДПОВІДЬ", Toast.LENGTH_SHORT).show();
    }
    /**обробник натиснення кнопки ВИДАЛИТИ*/
    public void delButtonPush (View view){
        /**для тесту*/
        Toast.makeText(this,"Натиснуто ВИДАЛИТИ", Toast.LENGTH_SHORT).show();
    }
    /**обробник натиснення кнопки ЦИФРА 0*/
    public void numPad0ButtonPush (View view){
        answerText.setText("0");
    }
    /**обробник натиснення кнопки ЦИФРА 1*/
    public void numPad1ButtonPush (View view){
        answerText.setText("1");
    }
    /**діалог який з'являжться коли час вичерпано*/
    public void timeOverDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //вибудовуємо контейнери для повідомлення
        builder.setMessage(R.string.alertDialogMessage);
        builder.setTitle(R.string.alertDialogTitle);

        //додаємо кнопки
        builder.setPositiveButton(R.string.alertDialogContinue, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //перехід до результатів тренування
            }
        });
        builder.setNegativeButton(R.string.alertDialogResults, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // нове тренування

            }
        });

        // створюжмо сам діалог
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**конвертація в мілісекунди*/
    long millisecondsFromSeconds(){
        return timerCount * 1000;
    }
}
