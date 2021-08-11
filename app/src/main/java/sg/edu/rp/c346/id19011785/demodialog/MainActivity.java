package sg.edu.rp.c346.id19011785.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.btn1);
        btnDemo2 = findViewById(R.id.btn2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.btn3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnEx3 = findViewById(R.id.btn4);
        tvEx3 = findViewById(R.id.tvExercise3);
        btnDemo4 = findViewById(R.id.btn5);
        tvDemo4 = findViewById(R.id.tvDemo4);
        btnDemo5 = findViewById(R.id.btn6);
        tvDemo5 = findViewById(R.id.tvDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set dialog details
                /*myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();*/

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box! :D"); // added some punctuations and emoticon
                myBuilder.setCancelable(true);
                //myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog dialog1 = myBuilder.create();
                dialog1.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 - Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                // Configure 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // previously text is 'Positive'
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive");
                    }
                });

                // Configure 'negative' button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() { // previously text is 'Negative'
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have select Negative");
                    }
                });

                // Configure 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain UI component in the input.xml layout
                // Needs to be defined as "final", so that it can be used in the onClick() method

                final EditText etInput = viewDialog.findViewById(R.id.inputText);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // Sets the view of the dialog
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by user
                        String message = etInput.getText().toString();
                        // Set the text into the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        // Exercise 3
        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3input, null);

                final EditText etN1 = viewDialog.findViewById(R.id.etNum1);
                final EditText etN2 = viewDialog.findViewById(R.id.etNum2);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewDialog);
                builder.setTitle("Exercise 3");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int num1 = Integer.parseInt(etN1.getText().toString());
                        int num2 = Integer.parseInt(etN2.getText().toString());
                        final int total = num1 + num2;
                        tvEx3.setText(String.valueOf(total));
                    }
                });
                builder.setNegativeButton("CANCEL", null);
                AlertDialog mDialog = builder.create();
                mDialog.show();

            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the Date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                /*DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);
                myDateDialog.show();*/

                // Create the Date Picker Dialog to show current date when it first appears
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();

            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                /*TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, false);
                myTimeDialog.show();*/

                // Create the Time Picker Dialog to show the current time when it first appears
                Calendar current = Calendar.getInstance();
                int hour = current.get(Calendar.HOUR_OF_DAY); // Current Hour
                int minute = current.get(Calendar.MINUTE); // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, minute, true);
                myTimeDialog.show();
            }
        });

    }
}