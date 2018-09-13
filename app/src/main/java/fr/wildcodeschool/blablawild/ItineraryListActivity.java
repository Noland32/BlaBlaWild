package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ItineraryListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent(); //on recupere l'intent
        String message = intent.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE); // on recupere l'extra

        setTitle(message);


    }
}
