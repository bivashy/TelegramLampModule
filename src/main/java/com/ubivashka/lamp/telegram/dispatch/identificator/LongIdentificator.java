package com.ubivashka.lamp.telegram.dispatch.identificator;

public class LongIdentificator implements Identificator {
	private final long identificator;

	public LongIdentificator(long identificator) {
		this.identificator = identificator;
	}

	@Override
	public long asLong() {
		return identificator;
	}

	@Override
	public boolean isLong() {
		return true;
	}
}
