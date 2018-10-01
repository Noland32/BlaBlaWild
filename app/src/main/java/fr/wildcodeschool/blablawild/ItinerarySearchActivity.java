package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);


        Button buttonVariable = findViewById(R.id.buttonSearch); //R=ressources
        buttonVariable.setOnClickListener(new View.OnClickListener()

        { //action au click

            @Override // créé par new OnClickListener pour créer l'action
            public void onClick(View view) {
                EditText edit_Departure = findViewById(R.id.Departure);
                EditText edit_Name = findViewById(R.id.Destination);
                String DepartureString = edit_Departure.getText().toString();
                String DestinationString = edit_Name.getText().toString();
                /**/
                if (DepartureString.equals("") || DestinationString.equals("")) {
                    Context context = getApplicationContext(); //call variable + methode
                    CharSequence text = "Please fill your Departure and Name";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    Intent myIntent = new Intent(view.getContext(), ItineraryListActivity.class); //création de l'object myIntent + getContext = ou on est + Iti ou on va
                    String message = DepartureString + ">>" + DestinationString;
                    myIntent.putExtra(EXTRA_MESSAGE, message); //call l'intent et on put l'extra
                    startActivity(myIntent);
                }
            }
        });


            final Calendar myCalendar = Calendar.getInstance();
            final EditText editDate = findViewById(R.id.Date);
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                private void updateLabel() {
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    editDate.setText(sdf.format(myCalendar.getTime()));
                }
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }
            };

            editDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                }
            });








    }
}
