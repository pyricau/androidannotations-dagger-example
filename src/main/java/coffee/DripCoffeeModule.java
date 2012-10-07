package coffee;

import javax.inject.Singleton;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module(entryPoints = CoffeeActivity_.class, includes = PumpModule.class)
class DripCoffeeModule {

	private final Context context;

	public DripCoffeeModule(Context context) {
		this.context = context.getApplicationContext();
	}

	@Provides
	@Singleton
	Context applicationContext() {
		return context;
	}

	@Provides
	@Singleton
	Heater provideHeater() {
		/*
		 * Since there's no AndroidAnnotations - Dagger integration layer, we
		 * need to instantiate the AA generated classes manually.
		 */
		return ElectricHeater_.getInstance_(applicationContext());
	}
}
