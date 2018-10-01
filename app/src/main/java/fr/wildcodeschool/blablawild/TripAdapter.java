package fr.wildcodeschool.blablawild;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // AFFICHAGE DU LAYOUT + CALL DES ELEMENTS + GETTERS
        TextView textDate = (TextView) convertView.findViewById(R.id.date);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss", Locale.FRANCE);
        String date = fmt.format(trip.getDateHeure());
        textDate.setText(date);

        TextView textFirstName = (TextView) convertView.findViewById(R.id.firstName);
        textFirstName.setText(trip.getFirstName()); //SETTER

        TextView textLastName = (TextView) convertView.findViewById(R.id.lastName);
        textLastName.setText(trip.getLastName()); // SETTER

        TextView textPrice = (TextView) convertView.findViewById(R.id.price);
        textPrice.setText(String.valueOf(trip.getPrice()));

        // Return the completed view to render on screen
        return convertView;
    }
}
