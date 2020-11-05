package ru.study.homework.homework2;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

public class StartCreateQRImage{

    public void getStart (String qrCodeText){

        String filePath = "src/main/java/ru/study/homework/homework2/MyQRCode.png";
        int size = 350;
        String fileType = "png";
        File qrFile = new File(filePath);
        CreateQRImage cqri = new CreateQRImage();

        try {
            cqri.createQRImage(qrFile, qrCodeText, size, fileType);
        }
        catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }
}
