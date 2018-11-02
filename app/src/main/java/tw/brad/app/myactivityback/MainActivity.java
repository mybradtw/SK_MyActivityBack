package tw.brad.app.myactivityback;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainApp mainApp;
    private TextView test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test1 = findViewById(R.id.test1);

        mainApp = (MainApp) getApplication();
        mainApp.lottery = (int)(Math.random()*49+1);
        mainApp.username = "Brad";

        test1.setText(mainApp.username + ":" + mainApp.lottery);

    }

    public void gotoPage2(View view) {
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("key", "value");

        startActivity(intent);
        //startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                afterPage2(resultCode, data);
                break;
            case 2:
                afterPage3(resultCode, data);
                break;

        }
    }

    private void afterPage2(int rcode, Intent intent){
        int k1 = intent.getIntExtra("k1", -1);
        int k2 = intent.getIntExtra("k2", -1);

        Log.v("brad", rcode + ":" + k1 + ":" + k2);

    }

    private void afterPage3(int rcode, Intent intent){

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        test1.setText(mainApp.username + ":" + mainApp.lottery);
    }
}
