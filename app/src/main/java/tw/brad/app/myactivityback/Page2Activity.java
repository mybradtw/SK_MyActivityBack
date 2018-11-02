package tw.brad.app.myactivityback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private MainApp mainApp;
    private TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        test2 = findViewById(R.id.test2);
        mainApp = (MainApp)getApplication();
        test2.setText(mainApp.username + ":" + mainApp.lottery);
    }


    @Override
    public void finish() {
        Intent intent2 = new Intent();
        intent2.putExtra("k1", 333);
        intent2.putExtra("k2", 444);

        setResult(123, intent2);

        mainApp.lottery = 100;
        mainApp.username = "Sakura";

        super.finish();
    }
}
