package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    }
}
