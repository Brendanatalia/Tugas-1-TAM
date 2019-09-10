package com.kel7.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_tinggi,et_berat;
    private Button btn_hasil;
    private TextView tv_hasil;

    private Button btn_move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_tinggi=(EditText)findViewById(R.id.ettinggi);
        et_berat=(EditText)findViewById(R.id.etberat);
        btn_hasil=(Button) findViewById(R.id.btnhasil);
        tv_hasil=(TextView)findViewById(R.id.tvhasil);
        btn_hasil.setOnClickListener(this);

        btn_move=(Button)findViewById(R.id.btnmove);
        btn_move.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btnhasil){
            String tgg=et_tinggi.getText().toString().trim();
            String brt=et_berat.getText().toString().trim();
            boolean isEmptyFields=false;
            if(TextUtils.isEmpty(tgg)){
                isEmptyFields=true;
                et_tinggi.setError("Tidak Boleh Kosong");
            }
            if(TextUtils.isEmpty(brt)){
                isEmptyFields=true;
                et_berat.setError("Tidak Boleh Kosong");
            }
            if(!isEmptyFields){
                double t=Double.parseDouble(tgg)/100;
                double b=Double.parseDouble(brt);
                double hsl=b/(t*t);
                tv_hasil.setText(String.valueOf(hsl));
            }
        }
        switch (v.getId()){
            case R.id.btnmove:
                Intent moveIntent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}
