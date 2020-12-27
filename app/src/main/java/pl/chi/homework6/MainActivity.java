package pl.chi.homework6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements fragment_list.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_list fragmentA = new fragment_list();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState == null) {
            ft.add(R.id.flContainer, fragmentA);
        } else {
            ft.replace(R.id.flContainer, fragmentA);
        }
        ft.commit();


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment_detail fragmentB = new fragment_detail();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            fragmentB.setArguments(args);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, fragmentB)
                    .commit();
        }


    }


    public void onItemSelected(int position) {
        fragment_detail fragmentB = new fragment_detail();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragmentB.setArguments(args);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, fragmentB)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, fragmentB)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
