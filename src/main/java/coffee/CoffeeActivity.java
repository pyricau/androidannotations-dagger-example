package coffee;

import info.piwai.androidannotations.dagger.example.R;

import javax.inject.Inject;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;

import dagger.ObjectGraph;

@EActivity(R.layout.main)
public class CoffeeActivity extends Activity {

	@App
	CoffeeApplication coffeeApplication;

	@Inject
	CoffeeMaker coffeeMaker;

	@AfterInject
	void daggerInject() {
		ObjectGraph objectGraph = coffeeApplication.getObjectGraph();
		long start = SystemClock.elapsedRealtime();
		objectGraph.inject(this);
		long duration = SystemClock.elapsedRealtime() - start;
		Log.d("CoffeeActivity", "CoffeeActivity Dagger injection duration in ms: " + duration);
	}

	@Click
	@Background
	void brewButtonClicked() {
		coffeeMaker.brew();
		coffeeBrewed();
	}

	@UiThread
	void coffeeBrewed() {
		Toast.makeText(this, "Get your coffee in the logs!", Toast.LENGTH_LONG).show();
	}

}
