package com.ftninfomatika.cas_017;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnNameClickListener {
//    extendsActivity

    private boolean landscape = false;
    private DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList();
        if (findViewById(R.id.flDetail) != null) {
            landscape = true;
            detailsFragment = new DetailsFragment();
            detailsFragment.setId(0);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flDetail, detailsFragment)
                    .commit();
        }
    }

    private void showList() {
        MasterFragment masterFragment = new MasterFragment();
        getSupportFragmentManager()
//                bez Support
                .beginTransaction()
                .replace(R.id.flFrame, masterFragment)
                .addToBackStack(null)
                .commit();

    }

    private void showName(int id) {
        if (landscape) {
            detailsFragment.updateId(id);
        }else{
        DetailsFragment fragment = new DetailsFragment();
        fragment.setId(id);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFrame, fragment)
                .addToBackStack(null)
                .commit();
    }

}

    @Override
    public void onNameClicked(int id) {
        showName(id);

    }
}

//android umesto xandroid