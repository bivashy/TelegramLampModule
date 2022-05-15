package com.ubivashka.lamp.telegram.dispatch.identificator;

public class StringIdentificator implements Identificator {
	private final String identificator;

	public StringIdentificator(String identificator) {
		this.identificator = identificator;
	}

	@Override
	public String asString() {
		return identificator;
	}

	@Override
	public boolean isString() {
		return true;
	}
}
