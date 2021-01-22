package com.example.bmi;

        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.widget.TextView;
        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView dname , dtotal;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dname = findViewById(R.id.display);
        dtotal = findViewById(R.id.display2);

        sharedPref = getSharedPreferences("pref", MODE_PRIVATE);

        String name = sharedPref.getString("name", null);
        String total = sharedPref.getString("stotal", null);
        dname.setText(name);
        dtotal.setText(total);
    }

}