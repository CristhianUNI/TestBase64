package com.macbook.cristhian.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private void code(String strText, TextView textView){
        String base64 = Base64.encodeToString(strText.getBytes(), Base64.DEFAULT);
        textView.setText(base64);
    }

    private void decode(String strCode,TextView textView) {
        byte[] tmp = Base64.decode(strCode, Base64.DEFAULT);
        String strDecode = new String(tmp);
        textView.setText(strDecode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView convertText = (TextView) findViewById(R.id.texto);
        final Button convertButton = (Button) findViewById(R.id.convertButton);
        final EditText convertInputText = (EditText) findViewById(R.id.convertEditText);

        convertText.setVisibility(View.INVISIBLE);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertText.setVisibility(View.VISIBLE);

                if ( convertButton.getText().toString().equals( getString(R.string.code_text) ) ) {
                    code(convertInputText.getText().toString(), convertText);
                    convertButton.setText(R.string.decode_text);
                } else {
                    decode(convertText.getText().toString(), convertText);
                    convertButton.setText(R.string.code_text);
                }

            }
        });

    }
}
