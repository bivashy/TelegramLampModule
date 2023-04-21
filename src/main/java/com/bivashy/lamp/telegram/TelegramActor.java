package com.bivashy.lamp.telegram;

import com.bivashy.lamp.telegram.core.BaseTelegramActor;
import com.bivashy.lamp.telegram.dispatch.DispatchSource;
import com.pengrad.telegrambot.model.User;

import revxrsal.commands.command.CommandActor;

public interface TelegramActor extends CommandActor {
	default Long getId() {
		return getUser().id();
	}

	default User getUser() {
		return getDispatchSource().getAuthor();
	}

	DispatchSource getDispatchSource();

	static TelegramActor wrap(TelegramCommandHandler commandHandler, DispatchSource dispatchSource) {
		return new BaseTelegramActor(commandHandler, dispatchSource);
	}
}
