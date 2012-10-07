package coffee;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;

import com.googlecode.androidannotations.annotations.EApplication;

import dagger.ObjectGraph;

@EApplication
public class CoffeeApplication extends Application {

	private ObjectGraph objectGraph;

	@Override
	public void onCreate() {
		super.onCreate();

		long start = SystemClock.elapsedRealtime();
		objectGraph = ObjectGraph.get(new DripCoffeeModule(this));
		long duration = SystemClock.elapsedRealtime() - start;
		Log.d("CoffeeApplication", "Building ObjectGraph duration in ms: " + duration);
	}

	public ObjectGraph getObjectGraph() {
		return objectGraph;
	}

}
