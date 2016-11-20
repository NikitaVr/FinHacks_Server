package com.example.angeloaustria.buddylending;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        balance =  (TextView) findViewById(R.id.textView4);
        displayBalance();
    }

    @Override
    protected void onResume(){
        super.onResume();
        displayBalance();
    }

    public void onReceiveClick(View view){
        // Launch receiving activity
        Intent intent = new Intent(MenuActivity.this, TransactionActivity.class);
        intent.putExtra("Mode", 1);
        intent.putExtra("username", getIntent().getStringExtra("username"));
        startActivity(intent);
    }

    public void onSendClick(View view) {
        // Launch sending activity
        Intent intent = new Intent(MenuActivity.this, TransactionActivity.class);
        intent.putExtra("Mode", 0);
        intent.putExtra("username", getIntent().getStringExtra("username"));
        startActivity(intent);
    }

    private void displayBalance(){
        balance.setText("$0.00");
        HttpRequest request = new HttpRequest(this);
        request.getAccountBalance(getIntent().getStringExtra("username"), new ResultCallback() {
            @Override
            public void run() {
                if(isSuccess()){
                    double money = (double) getData();
                    balance.setText("$" + Double.toString(money));
                }
                else{
                    balance.setText("Undefined");
                    Log.d("DEBUG", getErr());
                }
            }
        });
    }
}
