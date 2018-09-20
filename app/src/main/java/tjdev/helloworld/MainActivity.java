package tjdev.helloworld;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView message;
    private Button moveOn;
    private EditText input;
    private boolean firstClick;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.message = findViewById(R.id.message);
        this.moveOn = findViewById(R.id.move_on_finish);
        this.input = findViewById(R.id.input);

        input.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (moveOn.isEnabled())
                {
                    moveOn.performClick();
                }
                return true;
            }
        });

        firstClick = true;
        message.setText(R.string.welcome);
        moveOn.setText(R.string.move_on);

        moveOn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (firstClick)
                {
                    message.setText(getString(R.string.hello, input.getText()));
                    input.setVisibility(View.INVISIBLE);
                    moveOn.setText(R.string.finish);
                    firstClick = false;
                }
                else
                {
                    finish();
                }
            }
        });

        input.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                moveOn.setEnabled(s.length() > 0);
            }
        });
        moveOn.setEnabled(false);
    }
}
