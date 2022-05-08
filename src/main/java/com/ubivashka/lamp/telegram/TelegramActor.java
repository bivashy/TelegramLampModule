package com.ubivashka.lamp.telegram;

import com.pengrad.telegrambot.model.User;
import com.ubivashka.lamp.telegram.core.BaseTelegramActor;
import com.ubivashka.lamp.telegram.dispatch.DispatchSource;

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
