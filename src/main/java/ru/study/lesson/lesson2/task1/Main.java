package ru.study.lesson.lesson2.task1;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try{
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiRequestException ex){
            ex.printStackTrace();
        }

    }
}