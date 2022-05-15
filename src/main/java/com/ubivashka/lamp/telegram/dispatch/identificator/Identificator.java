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

	static Identificator fromObject(Object object) {
		if (object instanceof Long)
			return new LongIdentificator((Long) object);
		if (object instanceof Integer)
			return new LongIdentificator((Integer) object);
		if (object instanceof String)
			return new StringIdentificator((String) object);
		return null;
	}

	static Identificator of(long id) {
		return new LongIdentificator(id);
	}

	static Identificator of(String id) {
		return new StringIdentificator(id);
	}
}
