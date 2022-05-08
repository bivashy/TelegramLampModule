package com.ubivashka.lamp.telegram.dispatch.identificator;

public interface Identificator {
	default boolean isString() {
		return false;
	}

	default boolean isLong() {
		return false;
	}

	default long asLong() {
		throw new UnsupportedOperationException("Cannot represent identificator as long");
	}

	default String asString() {
		throw new UnsupportedOperationException("Cannot represent identificator as long");
	}

	default Object asObject() {
		if (isLong())
			return asLong();
		if (isString())
			return asString();
		return null;
	}
}
