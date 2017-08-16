package kr.ac.korea.kucc.study7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import kr.ac.korea.kucc.study7.R;

public class ResultActivity extends AppCompatActivity {
    public static final String KEY_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        TextView resultView = (TextView) findViewById(R.id.text_result);
        Intent intent = getIntent();
        resultView.setText(intent.getStringExtra(KEY_RESULT));
    }
}
