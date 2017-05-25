package derkach.andrei.numericaltransfer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainTrainingScreen extends AppCompatActivity {
    /**таймер*/
    TextView timerText;
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

        new CountDownTimer(31000, 1000){

            @Override
            public void onTick(long milisecondsUntillFinish) {
                timerText.setText(milisecondsUntillFinish / 1000 + "");
            }

            @Override
            public void onFinish() {
                timerText.setText("done");
            }
        }.start();
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
    } /**обробник натиснення кнопки ЦИФРА 1*/
    public void numPad1ButtonPush (View view){
        answerText.setText("1");
    }
}
