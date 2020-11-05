package ru.study.lesson.lesson2.task3.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.study.lesson.lesson2.task3.database.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Parse {
    public void start(){

        //TODO
        try{
            final String URL = "https://coronavirus-control.ru";
            Document document = Jsoup.connect(URL).get();
            Elements tbodys = document.getElementsByTag("tbody");
            Element tbody = tbodys.get(0);
            Elements trs = tbody.getElementsByTag("tr");

            //language = SQL

            Connection connection = DataBase.initConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("DELETE FROM covid19 WHERE true = true;");
            statement.close();

            String sql = "INSERT INTO covid19 VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < trs.size(); i++) {
                Element tr = trs.get(i);
                Elements ths = tr.getElementsByTag("th");

                Element regionNameElement = ths.get(0);
                String regionName = regionNameElement.text();
                System.out.print(regionName + "\t");

                Element illElement = ths.get(1);
                String ill = illElement.ownText();
                System.out.print("Всего: " + ill + "\t");

                Elements illSpan = illElement.getElementsByTag("span");
                if(illSpan.size() > 0){
                    String illNew = illSpan.get(0).ownText();
                    System.out.print("Новых: " + illNew + "\t");
                }else{
                    String illNew = "0";
                    System.out.print("Новых: " + illNew + "\t");
                }

                Element currentIllElement = ths.get(2);
                String currentIll = currentIllElement.ownText();
                System.out.print("Всего болеет: " + currentIll + "\t");

                Element deadElement = ths.get(3);
                String dead = deadElement.ownText();
                System.out.print("Погибло всего: " + dead + "\t");

                Elements deadSpan = deadElement.getElementsByTag("span");
                if(deadSpan.size() > 0){
                    String deadNew = deadSpan.get(0).ownText();
                    System.out.print("Погибло сегодня: " + deadNew + "\t");
                }else{
                    String deadNew = "0";
                    System.out.print("Погибло сегодня: " + deadNew + "\t");
                }

                Element healthElement = ths.get(4);
                String health = healthElement.ownText();
                System.out.print("Выздровело всего: " + health + "\t");

                Elements healthSpan = healthElement.getElementsByTag("span");
                if(healthSpan.size() > 0){
                    String healthNew = healthSpan.get(0).ownText();
                    System.out.print("Выздровело сегодня: " + healthNew + "\t");
                }else{
                    String healthNew = "0";
                    System.out.print("Выздровело сегодня: " + healthNew + "\t");
                }

                preparedStatement.setString(1, regionName);

                System.out.println();
            }




        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
