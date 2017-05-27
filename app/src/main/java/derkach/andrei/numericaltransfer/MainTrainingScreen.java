package derkach.andrei.numericaltransfer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import derkach.andrei.numericaltransfer.trainingResources.FromDecimalToBinary;

public class MainTrainingScreen extends AppCompatActivity {
    /**теекст таймеру*/
    TextView timerText;
    /**час на зворотній відлік у секудах*/
    long timerCount;
    /**текст завдання що виводиться для вирішення*/
    TextView taskText;
    /**відповідь що вводиться гравцем*/
    TextView answerText;
    String answerString;

    /**для переводу чисел в діцйкову систему числення*/
    FromDecimalToBinary fromDecimalToBinary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_training);

        /**привязка до віджетів на екрані*/
        timerText = (TextView) findViewById(R.id.timerText);
        taskText = (TextView) findViewById(R.id.taskText);
        answerText = (TextView) findViewById(R.id.answerText);

        /**виставляжмо секундний таймер*/
       // timerCount = 90;

        fromDecimalToBinary = new FromDecimalToBinary();
        /**Старт тренування*/
        startTraining();

        timerStart();
    }
    /**обробник апаратної кнопки назад*/
    @Override
    public void onBackPressed(){
        backButtonDialog();
    }
    /**обробник натиснення кнопки ПІДТВЕРДЖЕННЯ*/
    public void confirmButtonPush (View view){
        /**для тесту*/
        Toast.makeText(this,"Натиснуто ПІДТВЕРДИТИ", Toast.LENGTH_SHORT).show();

        /*конвертація при натиснені кнопки*/
        fromDecimalToBinary.convertToBinary();
        taskText.setText("");
        taskText.setText(fromDecimalToBinary.getBinaryNumber());

        answerString = "";
        answerText.setText(answerString);
    }
    /**обробник натиснення кнопки ВІДПОВІДЬ (демонстрація правильної відповіді)*/
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
        answerString += "0";
        answerText.setText(answerString);
    }
    /**обробник натиснення кнопки ЦИФРА 1*/
    public void numPad1ButtonPush (View view){
        answerString +="1";
        answerText.setText(answerString);
    }
    /**діалог який з'являжться коли час вичерпано*/
    public void timeOverDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //вибудовуємо контейнери для повідомлення
        builder.setMessage(R.string.alertDialogMessage);
        builder.setTitle(R.string.alertDialogTitle);

        //додаємо кнопки
        builder.setPositiveButton(R.string.alertDialogPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //перехід до результатів тренування
            }
        });
        builder.setNegativeButton(R.string.alertDialogNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // нове тренування
            }
        });

        // створюємо сам діалог
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    /**діалог який зявляється коли натиснуто кнопку назад*/
    public void backButtonDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //вибудовуємо контейнери для повідомлення
        builder.setMessage(R.string.backButtonDialogMessage);
        builder.setTitle(R.string.backButtonDialogTitle);

        //додаємо кнопки
        builder.setPositiveButton(R.string.backButtonDialogPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //перехід до головного екрану
                MainTrainingScreen.super.onBackPressed();
            }
        });
        builder.setNegativeButton(R.string.backButtonDialogNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // нічго не змінюється, тренування продовжуються
            }
        });

        // створюємо сам діалог
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    /**конвертація в мілісекунди*/
    private long millisecondsFromSeconds(){
        return timerCount * 1000;
    }
    /**метод для старту чи рестарту тренування*/
    public void startTraining(){
        /**виставляжмо секундний таймер*/
        timerCount = 90;

        /** перший приклад при старті гри*/
        fromDecimalToBinary.convertToBinary();
        taskText.setText(fromDecimalToBinary.getBinaryNumber());

        /**очищаємо рядок*/
        answerString = "";
        answerText.setText(answerString);
    }
    /**для запуску таймеру*/
    private void timerStart(){
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
}
