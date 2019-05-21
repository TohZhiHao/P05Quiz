package sg.edu.rp.c346.p05_quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    CheckBox ow;
    CheckBox rt;
    TextView counter;
    Button minus;
    Button plus;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ow = findViewById(R.id.checkBoxOneWay);
        rt = findViewById(R.id.checkBoxRoundTrip);
        minus = findViewById(R.id.buttonMinus);
        plus = findViewById(R.id.buttonAddition);
        submit = findViewById(R.id.buttonSubmit);
        counter = findViewById(R.id.textViewCounter);


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pax = Integer.parseInt(counter.toString());
                pax = pax - 1;
                counter.setText(pax);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pax = Integer.parseInt(counter.toString());
                pax = pax + 1;
                counter.setText(pax);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ow.isChecked() == true && rt.isChecked() ==true){
                    String message = "Please only select one Ticket Type";

                    Context context = getApplicationContext();
                    CharSequence text = message;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(ow.isChecked() == false && rt.isChecked() ==false){
                    String message = "Please select one Ticket Type";

                    Context context = getApplicationContext();
                    CharSequence text = message;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
                else{
                    int pax = Integer.parseInt(counter.toString());
                    int price = 0;
                    if (ow.isChecked() == true){
                        price = pax*100;

                        Intent intent = new Intent(getBaseContext(),FlightDetails.class);
                        intent.putExtra("price", price);
                        startActivity(intent);

                    }

                    else{
                        price = pax*2*100;
                        Intent intent = new Intent(getBaseContext(),FlightDetails.class);
                        intent.putExtra("price", price);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
