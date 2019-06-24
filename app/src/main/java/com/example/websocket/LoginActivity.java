package com.example.websocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;

public class LoginActivity extends AppCompatActivity {


    private EditText edit_username;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        edit_username = findViewById(R.id.edit_username);
        btn_login= findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = getUid();
                String username = edit_username.getText().toString();
                WebSocketManager.getInstance().login(uid,username);
            }
        });
        WebSocketManager.getInstance();
        EventBus.getDefault().register(this);
    }

    //生成一个假的用户UID
    private String getUid(){
        return new Date().getTime()+""+Math.floor(Math.random()*899+100);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMessage(MessageEvent msg){
        if(msg.Type == MessageEvent.MsgType.LOGIN){
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
