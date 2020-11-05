package ru.study.lesson.lesson2.task1;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());

            if(update.getMessage().getText().equalsIgnoreCase("Привет")) {
                sendMessage.setText("Привет :)");

            }else if (update.getMessage().getText().equalsIgnoreCase("Как дела?")) {
                sendMessage.setText("Отлично, как сам?");

            }else {
                sendMessage.setText("Я вас не понял");

            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "get_stat_covid_19_bot";
    }

    @Override
    public String getBotToken() {
        return "1285016709:AAG4JfaQ_LKk-rhE3nAMOEFOSuUlZB4jA4w";
    }
}
