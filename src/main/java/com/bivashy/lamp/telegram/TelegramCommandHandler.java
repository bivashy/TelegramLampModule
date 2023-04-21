package com.bivashy.lamp.telegram;

import com.pengrad.telegrambot.TelegramBot;

import revxrsal.commands.CommandHandler;

public interface TelegramCommandHandler extends CommandHandler {
	TelegramBot getBot();
}
