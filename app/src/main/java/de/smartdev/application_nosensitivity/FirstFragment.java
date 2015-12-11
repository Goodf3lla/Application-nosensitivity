package de.smartdev.application_nosensitivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import de.smartdev.application_nosensitivity.backend.AnzeigeEntry;
import de.smartdev.application_nosensitivity.backend.AnzeigenDbHelper;
import de.smartdev.application_nosensitivity.backend.ListDataAdapter;


public class FirstFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "sectionNumber"; //changed from default to fit to int position
    public ArrayList<String> alleTags = new ArrayList();
    private int mParam1;
    private OnFragmentInteractionListener mListener;


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(int sectionNumber) {
        FirstFragment fragment = new FirstFragment();
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        alleTags.add("Vegetarier");
        alleTags.add("Halal");
        alleTags.add("Test Clickable");
        alleTags.add("Test Scrollable");
        AnzeigenDbHelper helper;
        SQLiteDatabase db;
        Cursor cursor;
        ListView listView_show = (ListView) view.findViewById(R.id.listView_anzeigenShow);
        ListDataAdapter adapter_show = new ListDataAdapter(getActivity(), R.layout.show_anzeige_design);
        listView_show.setAdapter(adapter_show);
        helper = new AnzeigenDbHelper(getActivity());
        db = helper.getReadableDatabase();
        cursor = helper.getAnzeigenInfo(db);
        if (cursor.moveToFirst()) {
            do {
                String id, text, tags, adresse, lifetime, userId;
                id = cursor.getString(0);
                text = cursor.getString(1);
                tags = cursor.getString(2);
                adresse = cursor.getString(3);
                lifetime = cursor.getString(4);
                userId = cursor.getString(5);
                AnzeigeEntry entry = new AnzeigeEntry(id, text, tags, adresse, lifetime, userId);
                adapter_show.add(entry);
            } while (cursor.moveToNext());
        }
        listView_show.setAdapter(adapter_show);
        final Button button_show_Anzeige = (Button) view.findViewById(R.id.button_getAnzeige);
        button_show_Anzeige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "blubb", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        listView_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("position", position);
                new Handler().post(new Runnable() {                                                 //TODO: pass sign in token to detail & back to main
                    @Override
                    public void run() {
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
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
