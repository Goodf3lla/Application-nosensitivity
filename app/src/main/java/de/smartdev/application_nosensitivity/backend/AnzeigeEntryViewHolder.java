package de.smartdev.application_nosensitivity.backend;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.smartdev.application_nosensitivity.R;

/**
 * Created by Andi on 26.12.2015.
 */
public class AnzeigeEntryViewHolder extends RecyclerView.ViewHolder {

    public TextView anzeigenText;
    public TextView anzeigenAdresse;
    public TextView anzeigenTags;
    public TextView anzeigeID;
    public TextView anzeigeUserID;
    public TextView anzeigeLifeTime;

    public AnzeigeEntryViewHolder(View view) {
        super(view);
        anzeigenText = (TextView) view.findViewById(R.id.row_anzeige_text);
        anzeigenAdresse = (TextView) view.findViewById(R.id.row_anzeige_adresse);
        anzeigenTags = (TextView) view.findViewById(R.id.row_anzeige_tags);
        anzeigeID = (TextView) view.findViewById(R.id.row_anzeige_id);
        anzeigeUserID = (TextView) view.findViewById(R.id.row_anzeige_userId);
        anzeigeLifeTime = (TextView) view.findViewById(R.id.row_anzeige_lifetime);
    }
}
