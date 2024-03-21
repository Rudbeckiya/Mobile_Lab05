package g313.avchuhov.lab_05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText et_data;
    CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_data = findViewById(R.id.et_data);
        cb1 = findViewById(R.id.cb_first);
        cb2 = findViewById(R.id.cb_second);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 555)
        {
            if (data != null)
            {
                String s = data.getStringExtra("act1_s");
                boolean switch1 = data.getBooleanExtra("act1_c1", false);
                boolean switch2 = data.getBooleanExtra("act1_c2", false);

                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

                et_data.setText(s);
                cb1.setChecked(switch1);
                cb2.setChecked(switch2);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void open_click(View v)
    {
        String s = et_data.getText().toString();
        Boolean check1 = cb1.isChecked();
        Boolean check2 = cb2.isChecked();

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("main_s", s);
        i.putExtra("main_c1", check1);
        i.putExtra("main_c2", check2);

        startActivityForResult(i,555);
    }

    public void exit_click(View v)
    {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        AlertDialog dlg = bld.create();
        dlg.setTitle("Выход");
        dlg.setMessage("Закрыть приложение?");
        dlg.setIcon(R.drawable.exit_icon);
        dlg.setButton(Dialog.BUTTON_POSITIVE,"Да", (dialog, id) -> finish());
        dlg.setButton(Dialog.BUTTON_NEGATIVE,"Нет", (dialog, id) -> dialog.cancel());
        dlg.show();
    }

}