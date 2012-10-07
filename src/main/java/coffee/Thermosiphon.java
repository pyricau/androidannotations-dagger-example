package coffee;

import javax.inject.Inject;

class Thermosiphon implements Pump {
	private final Heater heater;

	@Inject
	Thermosiphon(Heater heater) {
		this.heater = heater;
	}

	@Override
	public void pump() {
		if (heater.isHot()) {
			System.out.println("=> => pumping => =>");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
