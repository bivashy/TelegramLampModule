package com.ubivashka.lamp.telegram.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.ubivashka.lamp.telegram.TelegramCommandHandler;

import revxrsal.commands.core.BaseCommandHandler;

public class TelegramHandler extends BaseCommandHandler implements TelegramCommandHandler {
	private static final List<TelegramHandler> INSTANCES = Collections.synchronizedList(new ArrayList<>());
	private final TelegramBot bot;

	public TelegramHandler(TelegramBot bot) {
		this.bot = bot;
		
		registerDependency(TelegramBot.class, bot);

		registerSenderResolver(TelegramSenderResolver.INSTANCE);
		
		INSTANCES.add(this);
	}

	@Override
	public TelegramBot getBot() {
		return bot;
	}

	public static List<TelegramHandler> getInstances() {
		return Collections.unmodifiableList(INSTANCES);
	}
}
