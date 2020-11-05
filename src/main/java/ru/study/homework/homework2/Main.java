package ru.study.homework.homework2;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) throws InterruptedException{

//    Сделать telegram бота, которому отправляется текст, а он возвращает ответ, зашифрованный в виде картинки с QR-кодом.
//    Этапы выполнения ДЗ:
//    - найти какую-то библиотеку на JAVA, которая может из текста сделать QR-код;
//    - сгенерировать изображение;
//    - отправить изображение с помощью бота.
//
//    Порядок действий:
//    1. Программа для отправления с помощью Telegram фотографий пользователю;
//    2. Программа по преобразованию текста в картинку (QR-код);
//    3. Объединить обе программы.

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try{
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiRequestException ex){
            ex.printStackTrace();
        }

    }
}