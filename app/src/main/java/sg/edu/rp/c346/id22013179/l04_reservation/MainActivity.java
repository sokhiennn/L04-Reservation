package sg.edu.rp.c346.id22013179.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText groupSizeEditText;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private RadioGroup smokingRadioGroup;
    private EditText additionalRequestsEditText;
    private Button bookButton;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameEditText = findViewById(R.id.nameEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        groupSizeEditText = findViewById(R.id.groupSizeEditText);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        smokingRadioGroup = findViewById(R.id.smokingRadioGroup);
        additionalRequestsEditText = findViewById(R.id.additionalRequests);
        bookButton = findViewById(R.id.bookButton);
        resetButton = findViewById(R.id.reset_button);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookTable();
            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetForm();
            }
        });
    }

    private void bookTable() {

        String name = nameEditText.getText().toString();
        String mobile = mobileEditText.getText().toString();
        int groupSize = Integer.parseInt(groupSizeEditText.getText().toString());
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // Month is zero-based, so add 1
        int year = datePicker.getYear();
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        boolean smoking = smokingRadioGroup.getCheckedRadioButtonId() == R.id.smokingYes;
        String additionalRequests = additionalRequestsEditText.getText().toString();


        String message = "Name: " + name +
                "\nMobile: " + mobile +
                "\nGroup size: " + groupSize +
                "\nDate: " + day + "/" + month + "/" + year +
                "\nTime: " + hour + ":" + minute +
                "\nSmoking area: " + (smoking ? "Yes" : "No") +
                "\nAdditional requests: " + additionalRequests;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void resetForm() {
        nameEditText.setText("");
        mobileEditText.setText("");
        groupSizeEditText.setText("");
        Calendar calendar = Calendar.getInstance();
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
        smokingRadioGroup.check(R.id.smokingNo);
        additionalRequestsEditText.setText("");
    }
}