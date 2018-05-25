package com.example.lenovo.text5;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SecondActivity extends AppCompatActivity {
    private TextView nameText;
    private EditText numberText;
    private Button saveButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        nameText = (TextView)findViewById(R.id.nameText);
        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        nameText.setText(Name);
        numberText = (EditText)findViewById(R.id.number);
        saveButton = (Button)findViewById(R.id.saveBut);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        String number = pref.getString(nameText.getText().toString(),"");
        if(number!=null){
            numberText.setText(number);
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                SharedPreferences temp = getSharedPreferences("data", MODE_PRIVATE);
                if (temp.getString(nameText.getText().toString(), "") != null) {
                    editor.remove(nameText.getText().toString());
                }
                editor.putString(nameText.getText().toString(), numberText.getText().toString());
                ;
                editor.commit();
                Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
            }
        });

    }

}

