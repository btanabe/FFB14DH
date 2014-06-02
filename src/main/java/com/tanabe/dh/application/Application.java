package com.tanabe.dh.application;

import com.tanabe.dh.helpers.DateHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by BTanabe on 5/28/2014.
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("Application started: " + DateHelper.getHumanReadableDateAndTimeMMddyyyyHHmmss());

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-integration.xml");
        DatabaseInterface databaseInterface = context.getBean("databaseInterface", DatabaseInterface.class);


        /*
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-integration.xml");
        NflPlayerDataProvider dataProvider = context.getBean("nflPlayerDataProvider", NflPlayerDataProvider.class);
        dataProvider.scrapeForPlayerData();
        */
    }
}
