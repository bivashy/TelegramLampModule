package com.bivashy.lamp.telegram.dispatch;

import com.bivashy.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.User;

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
