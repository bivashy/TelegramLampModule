package com.ubivashka.lamp.telegram.core;

import java.util.UUID;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.SendMessage;
import com.ubivashka.lamp.telegram.TelegramActor;
import com.ubivashka.lamp.telegram.TelegramCommandHandler;
import com.ubivashka.lamp.telegram.dispatch.DispatchSource;

import revxrsal.commands.CommandHandler;

public class BaseTelegramActor implements TelegramActor {

	private final Supplier<UUID> uuidSupplier = MemoizingSupplier.memoize(() -> new UUID(0, getId()));
	private final TelegramCommandHandler commandHandler;
	private final DispatchSource dispatchSource;

	public BaseTelegramActor(TelegramCommandHandler commandHandler, DispatchSource dispatchSource) {
		this.commandHandler = commandHandler;
		this.dispatchSource = dispatchSource;
	}

	@Override
	public @NotNull String getName() {
		return getUser().firstName();
	}

	@Override
	public @NotNull UUID getUniqueId() {
		return uuidSupplier.get();
	}

	@Override
	public void reply(@NotNull String message) {
		SendMessage sendMessage = new SendMessage(dispatchSource.getChatIdentficator().asObject(),
				commandHandler.getMessagePrefix() + message);
		commandHandler.getBot().execute(sendMessage);
	}

	@Override
	public void error(@NotNull String message) {
		reply(message);
	}

	@Override
	public CommandHandler getCommandHandler() {
		return commandHandler;
	}

	@Override
	public User getUser() {
		return dispatchSource.getAuthor();
	}

	@Override
	public DispatchSource getDispatchSource() {
		return dispatchSource;
	}

}
