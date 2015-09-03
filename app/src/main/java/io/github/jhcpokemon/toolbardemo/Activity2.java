package io.github.jhcpokemon.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

import butterknife.Bind;

/**
 * Created by jhcpokemon on 09/03/15.
 */
public class Activity2 extends AppCompatActivity implements MyFragment.OnButtonClicked{
    @Bind(R.id.check_box)
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_2);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onClick() {
        return checkBox.isChecked();
    }
}
