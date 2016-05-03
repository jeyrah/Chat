package com.example.ama.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button mButtonSend;
    private EditText mEditTextMessage;
    private ListView mListViewMessages;
    private Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(this);

        mButtonSend = (Button) findViewById(R.id.btnSend);
        mEditTextMessage = (EditText) findViewById(R.id.edtText);
        mListViewMessages = (ListView) findViewById(R.id.lsvMessages);

        List<String> list = mPresenter.getListMessages();
        final ArrayAdapter<String> listAdapter = mPresenter.setAdapter(list);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addMessageToListMessages(mEditTextMessage.getText().toString());
                mPresenter.changeListMessage(mListViewMessages, listAdapter);
            }
        });
    }
}
