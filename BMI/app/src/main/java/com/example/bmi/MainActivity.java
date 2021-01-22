package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Weight;
    EditText Height;
    TextView display;
    TextView display2;
    SharedPreferences sharedPreferences;

    Button Go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.txtName);
        Weight=findViewById(R.id.txtWeight);
        Height=findViewById(R.id.txtHeight);
        display=findViewById(R.id.txtDisplay1);
        display2=findViewById(R.id.txtDisplay2);
        Go=findViewById(R.id.btnGo);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        if(name != null)
        {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        String total =sharedPreferences.getString("total",null);
        if(total != null)
        {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",Name.getText().toString());
                String txtWeight;
                String txtHeight;

                txtWeight = Weight.getText().toString();
                txtHeight = Height.getText().toString();

                double cont1 = Double.parseDouble(txtWeight);
                double cont2 = Double.parseDouble(txtHeight);

                double total = cont1 / (cont2 * cont2);
                String stotal= String.valueOf(total);

                editor.putString("stotal",stotal);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });



    }


}