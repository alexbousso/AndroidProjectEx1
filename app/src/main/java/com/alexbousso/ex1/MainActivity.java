package com.alexbousso.ex1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    EditText editText;
    Button makeOrderButton;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        makeOrderButton = (Button) findViewById(R.id.makeOrderButton);
        makeOrderButton.setEnabled(false);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        editText.addTextChangedListener(new TextWatcher() {
            boolean ignoreChange = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ignoreChange) {
                    String str = s.toString();
                    str = str.replace(".", "");
                    ignoreChange = true;
                    editText.setText(str);
                    editText.setSelection(editText.getText().length());
                    ignoreChange = false;
                    if (str.length() > 0 && Integer.parseInt(str) > 0) {
                        makeOrderButton.setEnabled(true);
                    } else {
                        makeOrderButton.setEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText.setText(String.format("%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
