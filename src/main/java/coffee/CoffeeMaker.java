package coffee;

import javax.inject.Inject;

import dagger.Lazy;

class CoffeeMaker {

	/*
	 * Don't want to create a possibly costly heater until we need it.
	 */
	@Inject
	Lazy<Heater> heater;

	@Inject
	Pump pump;

	public void brew() {
		heater.get().on();
		pump.pump();
		System.out.println(" [_]P coffee! [_]P ");
		heater.get().off();
	}
}
