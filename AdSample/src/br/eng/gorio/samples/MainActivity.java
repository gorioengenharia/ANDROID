package br.eng.gorio.samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

	/** The view to show the ad. */
	private AdView ads;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create an Banner
		ads = (AdView) findViewById(R.id.ads);

		// Create an ad request. Check logcat output for the hashed device
		// ID to
		// get test ads on a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

		// Start loading the ad in the background.
		ads.loadAd(adRequest);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the 
		// action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onResume() {
		super.onResume();

		if (ads != null) {
			ads.resume();
		}
	}

	@Override
	public void onPause() {
		if (ads != null) {
			ads.pause();
		}
		super.onPause();
	}

	@Override
	public void onDestroy() {
		if (ads != null) {
			// Destroy the AdView.
			ads.destroy();
		}
		super.onDestroy();
	}

}
