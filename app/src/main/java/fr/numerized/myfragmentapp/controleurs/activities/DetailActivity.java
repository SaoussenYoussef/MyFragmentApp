package fr.numerized.myfragmentapp.controleurs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.numerized.myfragmentapp.R;
import fr.numerized.myfragmentapp.controleurs.fragments.DetailFragment;
import fr.numerized.myfragmentapp.controleurs.fragments.MainFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_BUTTON_TAG = "fr.numerized.myfragmentapp.controleurs.activities.DetailActivity";
    //1- Declare detail fragment
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // 2 - Configure and show home fragment
        this.configureAndShowDetailFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 3 - Call update method here beacause we are sure that Detail Fragment is visible
        this.updateDetailFragmenTeextViewWithIntentTag();
    }

    /**
     * Fragments
     */
    private void configureAndShowDetailFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance
        //of fragment in FrameLyout container

        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if(detailFragment == null){
            //B - Create new detail fragment
            detailFragment = new DetailFragment();
            //C- Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }

    private void updateDetailFragmenTeextViewWithIntentTag(){
        // Get button's tag from intent
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        // Update DeatilFragment's TextView
        detailFragment.updateTextView(buttonTag);
    }
}