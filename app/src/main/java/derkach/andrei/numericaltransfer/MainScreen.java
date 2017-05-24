package derkach.andrei.numericaltransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    /**Для виклику інших activity*/
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }
    /**обробник натисенння кнопки СТАРТ*/
    public void startButtonPush(View view){
        /**Запускаємо новий activity*/
        intent = new Intent(this, MainTrainingScreen.class); // контекст і клас який викликаємо
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // завершує роботу activity у фоні
        startActivity(intent); // запуск
    }
    /**Обробник натиснення кнопки ІФОРМАЦІЯ*/
    public void informationButtonPush(View view){
        /**Запускаємо новий activity*/
        intent = new Intent(this, InformationScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
