package com.ubivashka.lamp.telegram.dispatch;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;
import com.ubivashka.lamp.telegram.dispatch.identificator.Identificator;
import com.ubivashka.lamp.telegram.dispatch.identificator.LongIdentificator;

public class MessageDispatchSource implements DispatchSource {
	private final Message message;

	public MessageDispatchSource(Message message) {
		this.message = message;
	}

	@Override
	public String getText() {
		return message.text();
	}

	@Override
	public String getExecutionText() {
		return getText();
	}

	@Override
	public User getAuthor() {
		return message.from();
	}

	@Override
	public Identificator getSourceIdentificator() {
		return new LongIdentificator(message.messageId());
	}

	@Override
	public Identificator getChatIdentficator() {
		return new LongIdentificator(message.chat().id());
	}

	public Message getMessage() {
		return message;
	}
}
