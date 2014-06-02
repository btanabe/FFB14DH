package com.tanabe.dh.dataproviders;

import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.scrapers.impl.NflCombineResultsDotComScraper;
import com.tanabe.dh.scrapers.impl.NflDotComRosterScraper;
import com.tanabe.dh.web.database.NflPlayerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;

/**
 * Created by Brian on 5/29/2014.
 */
@EnableAutoConfiguration
public class NflPlayerDataProvider {
    protected NflPlayerDataRepository repository;

    protected NflDotComRosterScraper nflDotComRosterScraper;
    protected NflCombineResultsDotComScraper nflCombineResultsDotComScraper;

    public NflPlayerDataProvider(){}

    public void scrapeForPlayerData(){
        ArrayList<NflPlayerData> rosterScraperNflPlayerData = nflDotComRosterScraper.getPlayers();
        ArrayList<NflPlayerData> fortyTimeNflPlayerData = nflCombineResultsDotComScraper.getPlayers();

        NflPlayerData sammyWatkinsFromRosterScraper = null;
        NflPlayerData sammyWatkinsFromFortyScraper = null;

        for(NflPlayerData player : rosterScraperNflPlayerData){
            if(player.getPlayerFullName().equalsIgnoreCase("Sammy Watkins")){
                sammyWatkinsFromRosterScraper = player;
                break;
            }
        }

        for(NflPlayerData player : fortyTimeNflPlayerData){
            if(player.getPlayerFullName().equalsIgnoreCase("Sammy Watkins")){
                sammyWatkinsFromFortyScraper = player;
                break;
            }
        }

        System.out.println("ROSTER Sammy Watkins - 40: " + sammyWatkinsFromRosterScraper.getFortyTimeInSeconds() + " Speed Score: " + sammyWatkinsFromRosterScraper.getSpeedScore());
        System.out.println("FORTY  Sammy Watkins - College: " + sammyWatkinsFromFortyScraper.getCollege());
    }

    //region SETTERS:
    public void setNflDotComRosterScraper(NflDotComRosterScraper nflDotComRosterScraper){
        this.nflDotComRosterScraper = nflDotComRosterScraper;
    }

    public void setNflCombineResultsDotComScraper(NflCombineResultsDotComScraper nflCombineResultsDotComScraper){
        this.nflCombineResultsDotComScraper = nflCombineResultsDotComScraper;
    }
    //endregion
}
