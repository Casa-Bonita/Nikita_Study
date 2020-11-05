package ru.study.lesson.lesson2.task2;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String inputTxt = update.getMessage().getText();

            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("Привет");

            if(inputTxt.equalsIgnoreCase("/start") || inputTxt.contains("Back")) {
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

                KeyboardRow keyboardRow1 = new KeyboardRow();
                KeyboardRow keyboardRow2 = new KeyboardRow();

                keyboardRow1.add("Key 1" + "\uD83D\uDCA4");
                keyboardRow1.add("Key 2");

                keyboardRow2.add("Key 3");
                keyboardRow2.add("Key 4");
                keyboardRow2.add("Key 5");

                replyKeyboardMarkup.setKeyboard(Arrays.asList(keyboardRow1, keyboardRow2));

                sendMessage.setReplyMarkup(replyKeyboardMarkup);

            }
            else if(inputTxt.contains("Key 1")){
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

                KeyboardRow keyboardRow1 = new KeyboardRow();
                KeyboardRow keyboardRow2 = new KeyboardRow();

                keyboardRow1.add("1" + "\uD83D\uDCA4");
                keyboardRow1.add("2");

                keyboardRow2.add("Back");

                replyKeyboardMarkup.setKeyboard(Arrays.asList(keyboardRow1, keyboardRow2));

                sendMessage.setReplyMarkup(replyKeyboardMarkup);
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
