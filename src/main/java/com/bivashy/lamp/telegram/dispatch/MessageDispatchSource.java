package com.bivashy.lamp.telegram.dispatch;

import com.bivashy.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;

public class MessageDispatchSource implements DispatchSource {
	private final Message message;
	private String messageText;

	public MessageDispatchSource(Message message) {
		this.message = message;
		if(message.text()!=null)
			messageText = message.text();
		if(message.caption()!=null)
			messageText = message.caption();
	}

	@Override
	public String getText() {
		return messageText;
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
		return Identificator.of(message.messageId());
	}

	@Override
	public Identificator getChatIdentficator() {
		return Identificator.of(message.chat().id());
	}

	public Message getMessage() {
		return message;
	}
}
