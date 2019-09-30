package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.Fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.Fragments.MenuFragment;

public  class MainActivity extends AppCompatActivity implements
        MenuFragment.OnFragmentInteractionListener,
        BrocaIndexFragment.OnFragmentInteractionListener{

	private AboutFragment aboutFragment;
    private BrocaIndexFragment brocaIndexFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        MenuFragment menuFragment = new MenuFragment();
        brocaIndexFragment = new BrocaIndexFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit();
	}

    @Override
    public void onBrocaIndexButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, brocaIndexFragment)
                .commit();
    }

    @Override
    public void onBodyMassIndexButtonClicked() {

    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		aboutFragment = AboutFragment.newInstance("Agus Subaktiar");
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == R.id.menu_about) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}

		return super.onOptionsItemSelected(item);
	}

    @Override
    public void onCalculateBrocaIndexClicked(float index) {

    }
}

