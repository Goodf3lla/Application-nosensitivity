package de.smartdev.application_nosensitivity.backend;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.smartdev.application_nosensitivity.R;

/**
 * Created by lukas on 08.12.15.
 */
public class ListDataAdapter extends ArrayAdapter {


    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);                  //TODO: check warnings !!!!
        list.add(object);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;

        if (row == null) {

            Log.e("DATABASE OPERATION", "no rows");

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.show_anzeige_design, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.ID = (TextView) row.findViewById(R.id.row_anzeige_id);
            layoutHandler.TEXT = (TextView) row.findViewById(R.id.row_anzeige_text);
            layoutHandler.TAGS = (TextView) row.findViewById(R.id.row_anzeige_tags);
            layoutHandler.ADRESSE = (TextView) row.findViewById(R.id.row_anzeige_adresse);
            layoutHandler.LIFETIME = (TextView) row.findViewById(R.id.row_anzeige_lifetime);
            layoutHandler.USERID = (TextView) row.findViewById(R.id.row_anzeige_userId);

            row.setTag(layoutHandler);
        } else {
            layoutHandler = (LayoutHandler) row.getTag();
        }

        Log.e("DATABASE OPERATION", "row available");

        AnzeigeEntry entries = (AnzeigeEntry) this.getItem(position);
        layoutHandler.ID.setText(entries.getId());
        layoutHandler.TEXT.setText(entries.getAnzeigenText());
        layoutHandler.TAGS.setText(entries.getTags());
        layoutHandler.ADRESSE.setText(entries.getAdresse());
        layoutHandler.LIFETIME.setText(entries.getLifetime());
        layoutHandler.USERID.setText(entries.getUserAnzeigeId());

        return row;

    }

    static class LayoutHandler {

        TextView ID, TEXT, TAGS, ADRESSE, LIFETIME, USERID;
    }
}

