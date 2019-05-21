package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {
TextView tvanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        tvanswer = findViewById(R.id.textView);
        Intent intentReceived = getIntent();
        int receive = intentReceived.getIntExtra("price", 0);
        tvanswer.setText(receive);
    }
}
