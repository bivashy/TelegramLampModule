package com.ubivashka.lamp.telegram.dispatch;

import com.pengrad.telegrambot.model.User;
import com.ubivashka.lamp.telegram.dispatch.identificator.Identificator;

public interface DispatchSource {
	String getText();

	String getExecutionText();

	Identificator getChatIdentficator();

	Identificator getSourceIdentificator();

	User getAuthor();

	default <T extends DispatchSource> T as(Class<T> clazz) {
		return clazz.cast(this);
	}
}
