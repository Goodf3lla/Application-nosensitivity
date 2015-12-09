package de.smartdev.application_nosensitivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "sectionNumber";
    public int mParam1;
    String Anzeigentext;
    String Anzeigenadresse;
    ArrayList<String> alleTags = new ArrayList();
    ArrayList<String> gewaehlteTags = new ArrayList();
    String auswahlRemove;
    String auswahlAdd;
    private OnFragmentInteractionListener mListener;


    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(int sectionNumber) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_SECTION_NUMBER);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_second, container, false);

        //TODO:make upgradeable with internet
        alleTags.add("Vegetarier");
        alleTags.add("Halal");
        alleTags.add("Koscher");
        alleTags.add("Pescetarier");
        alleTags.add("Veganer");
        Collections.sort(alleTags);
        final ArrayAdapter<String> adapterlinks = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, alleTags); //linke Listview aka die zu wählenden Tags
        final ListView listView_links = (ListView) view.findViewById(R.id.alle_tags_Liste);
        listView_links.setAdapter(adapterlinks);
        final ArrayAdapter<String> adapterrechts = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, gewaehlteTags); //rechte Listview aka die gewählten Tags
        final ListView listView_rechts = (ListView) view.findViewById(R.id.ausgewaehlte_tag_liste);
        listView_rechts.setAdapter(adapterrechts);
        listView_links.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        listView_rechts.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        final Button button_waehlen = (Button) view.findViewById(R.id.wählen);
        final Button button_loeschen = (Button) view.findViewById(R.id.löschen);
        listView_links.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                button_waehlen.setClickable(true);
                auswahlAdd = (String) listView_links.getItemAtPosition(position);
                button_waehlen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gewaehlteTags.add(auswahlAdd);
                        alleTags.remove(auswahlAdd);
                        auswahlAdd = "";
                        Collections.sort(gewaehlteTags);
                        button_waehlen.setClickable(false);
                        adapterlinks.notifyDataSetChanged();
                        adapterrechts.notifyDataSetChanged();
                    }
                });
            }
        });
        listView_rechts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                button_loeschen.setClickable(true);
                auswahlRemove = (String) listView_rechts.getItemAtPosition(position);
                button_loeschen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alleTags.add(auswahlRemove);
                        gewaehlteTags.remove(auswahlRemove);
                        auswahlRemove = "";
                        button_loeschen.setClickable(false);
                        Collections.sort(alleTags);
                        adapterlinks.notifyDataSetChanged();
                        adapterrechts.notifyDataSetChanged();
                    }
                });
            }
        });
        Button button_abschicken = (Button) view.findViewById(R.id.Anzeige_abschicken);
        button_abschicken.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Auslesen des Anzeigentextes
                EditText mEdit_anzeigentext = (EditText) view.findViewById(R.id.edit_Anzeigentext);
                Anzeigentext = mEdit_anzeigentext.getText().toString();
                //Auslesen der Adresse
                EditText mEdit_anzeigenadresse = (EditText) view.findViewById(R.id.editText_Adresseingabe);
                Anzeigenadresse = mEdit_anzeigenadresse.getText().toString();
                mEdit_anzeigentext.getText().clear();
                mEdit_anzeigenadresse.getText().clear();
                //TODO: an DB & Server übergeben-->übergabeAnServer(gewaehlteTags);
                alleTags.addAll(gewaehlteTags);
                Collections.sort(alleTags);
                gewaehlteTags.clear();
                adapterrechts.notifyDataSetChanged();
                adapterlinks.notifyDataSetChanged();
            }
        });
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
