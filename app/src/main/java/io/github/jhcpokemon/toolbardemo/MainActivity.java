package io.github.jhcpokemon.toolbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup group;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        group = (RadioGroup)findViewById(R.id.btn_group);
        button = (Button)findViewById(R.id.show_dialog_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.alert_dialog_btn:
                        MyDialogFragment f = MyDialogFragment.newInstance(MyDialogFragment.alert_dialog);
                        f.show(getFragmentManager(),"Alter Dialog");
                        break;
                    case R.id.date_picker_btn:
                        f = MyDialogFragment.newInstance(MyDialogFragment.date_picker_dialog);
                        f.show(getFragmentManager(),"Date Picker Dialog");
                        break;
                    case R.id.time_picker_btn:
                        f = MyDialogFragment.newInstance(MyDialogFragment.time_picker_dialog);
                        f.show(getFragmentManager(),"Time Picker Dialog");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
