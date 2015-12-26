package de.smartdev.application_nosensitivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseRecyclerAdapter;

import de.smartdev.application_nosensitivity.backend.AnzeigeEntry;
import de.smartdev.application_nosensitivity.backend.AnzeigeEntryViewHolder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FourthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "sectionNumber";
    //FirebaseListAdapter<AnzeigeEntry> mAdapter;
    FirebaseRecyclerAdapter<AnzeigeEntry, AnzeigeEntryViewHolder> mAdapter;
    private int mParam1;
    private OnFragmentInteractionListener mListener;
    public FourthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sectionNumber Parameter 1.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance(int sectionNumber) {
        FourthFragment fragment = new FourthFragment();
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
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        final Firebase firebase = new Firebase("https://lob.firebaseio.com/");
        Button test_button = (Button) view.findViewById(R.id.button_getAnzeige_test);
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebase.limitToLast(10).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot anzSnapshot : dataSnapshot.getChildren()) {
                            AnzeigeEntry anzeigeEntry = anzSnapshot.getValue(AnzeigeEntry.class);
                            Log.i("FirebaseUI/4", "Successful read " + anzeigeEntry.getAnzeigenText());
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Log.w("FirebaseUI/4", "The read failed: " + firebaseError.getMessage());
                    }
                });
            }
        });
    /*    ListView messagesView=(ListView) view.findViewById(R.id.listView_anzeigenShow_test);
        mAdapter =new FirebaseListAdapter<AnzeigeEntry>(getActivity(), AnzeigeEntry.class, R.layout.show_anzeige_design, firebase) {
            @Override
            protected void populateView(View view, AnzeigeEntry anzeigeEntry) {
                ((TextView)view.findViewById(R.id.row_anzeige_text)).setText(anzeigeEntry.getAnzeigenText());
                ((TextView)view.findViewById(R.id.row_anzeige_adresse)).setText(anzeigeEntry.getAdresse());
                ((TextView)view.findViewById(R.id.row_anzeige_tags)).setText(anzeigeEntry.getTags());
                ((TextView)view.findViewById(R.id.row_anzeige_id)).setText(anzeigeEntry.getId());
                ((TextView)view.findViewById(R.id.row_anzeige_userId)).setText(anzeigeEntry.getUserAnzeigeId());
                ((TextView)view.findViewById(R.id.row_anzeige_lifetime)).setText(anzeigeEntry.getLifetime());
            }
        };
        messagesView.setAdapter(mAdapter);*/


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listView_anzeigenShow_test);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new FirebaseRecyclerAdapter<AnzeigeEntry, AnzeigeEntryViewHolder>(AnzeigeEntry.class, R.layout.card_view_anzeige, AnzeigeEntryViewHolder.class, firebase) {
            @Override
            public void populateViewHolder(AnzeigeEntryViewHolder entryViewHolder, AnzeigeEntry anzeigeEntry) {
                entryViewHolder.anzeigenText.setText(anzeigeEntry.getAnzeigenText());
                entryViewHolder.anzeigenAdresse.setText(anzeigeEntry.getAdresse());
                entryViewHolder.anzeigenTags.setText(anzeigeEntry.getTags());
                entryViewHolder.anzeigeID.setText(anzeigeEntry.getId());
                entryViewHolder.anzeigeUserID.setText(anzeigeEntry.getUserAnzeigeId());
                entryViewHolder.anzeigeLifeTime.setText(anzeigeEntry.getLifetime());
            }
        };
        recyclerView.setAdapter(mAdapter);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
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
