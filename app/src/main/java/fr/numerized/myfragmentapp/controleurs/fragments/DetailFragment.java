package fr.numerized.myfragmentapp.controleurs.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.numerized.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // 1 - Declare TextView
    private TextView textView;
    private int buttonTag;
    public static final String KEY_EXTRA_TAG =
            "fr.numerized.myfragmentapp.controleurs.fragments.DetailFragment.KEY_EXTRA_TAG";

    public DetailFragment() {
        // Required empty public constructor
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        //2 - Get textView from layout (don't forget to creat ID in fragment_detail.xml)
        this.textView = (TextView) view.findViewById(R.id.fragment_detail_text_view);

        return (view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //5- restore buttonTag if possible
        if(savedInstanceState != null){
            int buttonTagRestored = savedInstanceState.getInt(KEY_EXTRA_TAG, 0);
            this.updateTextView(buttonTagRestored);
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 4- Save buttonTag in Bundle when fragment is destroyed
        outState.putInt(KEY_EXTRA_TAG, buttonTag);
    }

    // 3 - Update TextView depending on TAG's Button
    public void updateTextView(int btnTag) {

        switch (btnTag){

            case 10:
                this.textView.setText(" What about new color");
                break;
            case 20:
                this.textView.setText("Yellow Color");
                break;
            case 30:
                this.textView.setText(" or other Color");
                break;
            default:
                break;
         }
    }
 }