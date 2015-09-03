package io.github.jhcpokemon.toolbardemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;

/**
 * Created by jhcpokemon on 09/03/15.
 */
public class MyFragment extends Fragment {
    boolean checkState;
    OnButtonClicked myCallback;
    @Bind(R.id.frag_btn)
    Button btnSend;
    @Bind(R.id.msg_text)
    TextView msgTextView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myCallback = (OnButtonClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnButtonClicked interface");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkState = myCallback.onClick();
            }
        });
        if (checkState) {
            msgTextView.setText("CheckBox 勾选");
        } else {
            msgTextView.setText("CheckBox 未勾选");
        }
    }

    public interface OnButtonClicked {
        boolean onClick();
    }
}
