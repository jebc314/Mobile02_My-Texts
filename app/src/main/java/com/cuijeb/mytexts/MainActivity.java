package com.cuijeb.mytexts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mDisplayName;
    private EditText mEditFirstName;
    private EditText mEditLastName;
    private Button mSubmitButton;

    private TextView mWarningMessage;
    private Button mForibiddenButton;
    private String[] messages;
    private int position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayName = findViewById(R.id.displayTextView);
        mEditFirstName = findViewById(R.id.firstNameEditText);
        mEditLastName = findViewById(R.id.lastNameEditText);
        mSubmitButton = findViewById(R.id.submitButton);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditFirstName != null && mEditLastName != null) {
                    String name = mEditFirstName.getText().toString() + " " + mEditLastName.getText().toString();
                    mDisplayName.setText(name);
                }
                mDisplayName.setTextColor(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
                mSubmitButton.setTextColor(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
                mDisplayName.setTextSize(TypedValue.COMPLEX_UNIT_SP, (int)(Math.random()*30 + 15));
            }
        });

        mWarningMessage = findViewById(R.id.warningTextView);
        mForibiddenButton = findViewById(R.id.forbidden_button);
        Resources res = getResources();
        messages = res.getStringArray(R.array.message_array);

        mForibiddenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWarningMessage != null && messages != null) {
                    mWarningMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    position++;
                    if (position == messages.length) {
                        position = 0;
                        mForibiddenButton.setText(getString(R.string.forbidden_button_value));
                    }else{
                        mForibiddenButton.setText(">>:((");
                    }
                    mWarningMessage.setText(messages[position]);
                    mWarningMessage.setTextColor(Color.rgb((int)((double)position/messages.length*255),0,0));
                }
            }
        });
    }
}