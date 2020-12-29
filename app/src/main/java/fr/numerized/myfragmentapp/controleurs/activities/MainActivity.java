package fr.numerized.myfragmentapp.controleurs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import fr.numerized.myfragmentapp.R;
import fr.numerized.myfragmentapp.controleurs.fragments.DetailFragment;
import fr.numerized.myfragmentapp.controleurs.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    // 1 - Declare mainFragment and detailFragment
    private MainFragment mainFragment;
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 - Configure and show home fragment

        this.configureAndShowMainFrgament();
        this.configureAndShowDetailFragment();
    }


    /**
     * CALLBack
     * @param view
     */
    @Override
    public void onButtonClicked(View view) {

        // 1 - Retreive button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());

        // 2 - Check if DetailFragment is visible (Tablet)

        Log.e(getClass().getSimpleName(), "Button clicked");
        if(detailFragment != null && detailFragment.isVisible() ){
            // 2.1 Tablet : Upadte directly TextView
            detailFragment.updateTextView(buttonTag);

            // SI detailFragment == null, cela veut dire que le fichier  xml w66dp(contenta les deux fragments)
            // n'est pas utilisé et donc on est en mode SmartPhone


        } else{

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(intent);
        }

    }

    /**
     * MANAGE FRAGMENTS
     */
    private void configureAndShowMainFrgament(){
       // A - Get FragmentManager (Support) and Try to find existing instance
        //of fragment in FrameLyout container

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if(mainFragment == null){
            //B - Create new main fragment
            mainFragment = new MainFragment();
            //C- Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance
        //of fragment in FrameLyout container

        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if(detailFragment == null && findViewById(R.id.frame_layout_detail) != null ){
            //B - Create new detail fragment
            detailFragment = new DetailFragment();
            //C- Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }
}
