package ninja.farhood.dailyfortune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checks if it is the first time that the application is being run and will prompt the user to enter a name in order to save it
        // in the shared preferences for future use
        MyPreferences pref = new MyPreferences(MainActivity.this);
        if(!pref.isFirstTime()) {
            Intent i = new Intent(getApplicationContext(),
                    FortuneActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
            finish();
        }

        Button btn_startService = (Button)findViewById(R.id.button2);

        final Intent serviceIntent = new Intent(MainActivity.this,BackgroundService.class);

        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(serviceIntent);
            }
        });
        Button btn_stopService = (Button)findViewById(R.id.button3);
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
            }
        });
    }

    public void SaveUserName(View v) {
        EditText usrName = (EditText)findViewById(R.id.editText1);
        MyPreferences pref = new MyPreferences(MainActivity.this);
        pref.setUserName(usrName.getText().toString().trim());
        Intent i  =new Intent(getApplicationContext(), FortuneActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
        finish();
    }

}
