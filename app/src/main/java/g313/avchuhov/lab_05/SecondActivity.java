package g313.avchuhov.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity
{

    EditText et_data2;
    Switch sw1, sw2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_data2 = findViewById(R.id.et_data2);
        sw1 = findViewById(R.id.sw_first);
        sw2 = findViewById(R.id.sw_second);

        Intent i = getIntent();

        String s = i.getStringExtra("main_s");
        boolean check1 = i.getBooleanExtra("main_c1", false);
        boolean check2 = i.getBooleanExtra("main_c2", false);

        et_data2.setText(s);
        if (check1) sw1.setChecked(true);
        if (check2) sw2.setChecked(true);
    }

    public void OK_click(View v)
    {
        Intent i = new Intent();

        String s = et_data2.getText().toString();
        Boolean switch1 = sw1.isChecked();
        Boolean switch2 = sw2.isChecked();

        i.putExtra("act1_s", s);
        i.putExtra("act1_c1", switch1);
        i.putExtra("act1_c2", switch2);

        setResult(RESULT_OK, i);
        finish();
    }

    public void cancel_click(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}