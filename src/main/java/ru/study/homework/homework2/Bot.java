package ru.study.homework.homework2;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Bot extends TelegramLongPollingBot {

    String qrCodeText = "";

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMessage = update.getMessage();
            String qrCodeText = inMessage.getText();

            if(qrCodeText.equalsIgnoreCase("/start")){
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(inMessage.getChatId());
                outMessage.setText("Привет! Этот бот поможет Вам создать QR-код Вашего сообщения!");
                SendMessage outMessage1 = new SendMessage();
                outMessage1.setChatId(inMessage.getChatId());
                outMessage1.setText("Введите текст, который нужно закодировать:");
                try{
                    execute(outMessage);
                    execute(outMessage1);
                }catch(TelegramApiException ex){
                    ex.printStackTrace();
                }
            }
            else if(qrCodeText.length() > 0){
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(inMessage.getChatId());
                outMessage.setText("Отлично! Сообщение \"" + qrCodeText + "\" будет преобразовано в QR код");
                StartCreateQRImage startCreateQRImage = new StartCreateQRImage();
                startCreateQRImage.getStart(qrCodeText);

                try{
                    execute(outMessage);
                }catch(TelegramApiException ex){
                    ex.printStackTrace();
                }

                SendPhoto sendPhoto = null;
                try{
                    sendPhoto = new SendPhoto().setPhoto("QR-code", new FileInputStream(new File("src/main/java/ru/study/homework/homework2/MyQRCode.png"))).setChatId(inMessage.getChatId());
                }catch(IOException ex){
                    ex.printStackTrace();
                }

                try{
                    execute(sendPhoto);
                }catch(TelegramApiException ex){
                    ex.printStackTrace();
                }

            } else {
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(inMessage.getChatId());
                outMessage.setText("Я Вас не понял");
            }
        }
    }


    // метод возвращает имя пользователя бота
    @Override
    public String getBotUsername() {
        return "this_my_qr_bot";
    }

    // метод возвращает токен, выданный Bot Father
    @Override
    public String getBotToken() {
        return "1285937153:AAFu2U1I_4brwmNwTwW3MZzaInn2pw7Fmv8";
    }
}
