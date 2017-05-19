package com.example.a15017381.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioGroup rgStars;
    RadioButton rb;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.editTextTitle);
        etSingers = (EditText)findViewById(R.id.editTextSingers);
        etYear = (EditText)findViewById(R.id.editTextYear);
        rgStars = (RadioGroup)findViewById(R.id.rgStars);
        btnInsert = (Button)findViewById(R.id.buttonInsert);
        btnShowList = (Button)findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = rgStars.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(selected);
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int rbStars = Integer.parseInt(rb.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);
                long row_affected = db.insertSong(title,singers,year,rbStars);
                db.close();

                if(row_affected != -1 ){
                    Toast.makeText(MainActivity.this, "Song inserted: Title: " + title + ", Singer: " + singers + ", Year: " + year + ", Stars: " + rbStars , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
