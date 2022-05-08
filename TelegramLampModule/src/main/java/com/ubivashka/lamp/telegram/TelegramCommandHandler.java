package com.ubivashka.lamp.telegram;

import com.pengrad.telegrambot.TelegramBot;

import revxrsal.commands.CommandHandler;

public interface TelegramCommandHandler extends CommandHandler {
	TelegramBot getBot();
}
