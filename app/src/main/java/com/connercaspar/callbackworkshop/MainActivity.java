package com.connercaspar.callbackworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass{

    private CallbackFragment callbackFragment;

    @BindView(R.id.callback_message_textview)
    protected TextView callbackMessageTextview;

    @BindView(R.id.activity_layout)
    protected ConstraintLayout activityLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "The main activity is toasing the fragment.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void changeTextview() {
        callbackMessageTextview.setText("Callback recieved");
    }

    @Override
    public void changeBackgroundColor() {
        activityLayout.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();
    }

    @OnClick(R.id.fragment_launcher_button)
    protected void fragmentLauncherButtonClicked() {
        callbackFragment = CallbackFragment.newInstance();
        callbackFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, callbackFragment).commit();
    }
}
