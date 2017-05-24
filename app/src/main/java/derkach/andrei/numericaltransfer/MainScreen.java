package derkach.andrei.numericaltransfer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

    }
    /**обробник натисенння кнопки СТАРТ*/
    public void startButtonPush(View view){
        // для перевірки роботи
        Toast.makeText(this, "START button is pushed", Toast.LENGTH_SHORT).show();
    }
    /**Обробник натиснення кнопки ІФОРМАЦІЯ*/
    public void informationButtonPush(View view){
        //для перевірки роботи
        Toast.makeText(this, "INFORMATION button is pushed", Toast.LENGTH_SHORT).show();
    }
}
