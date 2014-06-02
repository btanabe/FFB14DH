package com.tanabe.dh.scrapers.impl;

import com.tanabe.dh.helpers.DateHelper;
import com.tanabe.dh.helpers.UrlHelper;
import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.NflPlayerFactory;
import com.tanabe.dh.web.WebRequest;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

/**
 * Created by BTanabe on 5/29/2014.
 */
public class NflCombineResultsDotComScraper {
    protected ArrayList<NflPlayerData> players;
    protected LinkedHashMap<Integer, Document> combineResultPageKeyedByYearsSinceTheCurrentYear = new LinkedHashMap<Integer, Document>(10);

    public NflCombineResultsDotComScraper(){}

    public void setPlayerToScrapeFortyTimesFor(ArrayList<NflPlayerData> playersToScrapeFor){
        this.players = playersToScrapeFor;
    }

    public void scrapeFortyTimes() throws IOException {
        sortPlayersByExperience();
        for(NflPlayerData player : players){
            scrapeForPlayer(player);
        }
    }

    //region PROTECTED HELPER FUNCTIONS:
    protected void sortPlayersByExperience(){
            // Sort by experience:
            Collections.sort(players, new Comparator<NflPlayerData>() {
                @Override
                public int compare(NflPlayerData lhs, NflPlayerData rhs) {
                    return lhs.getExperience() - rhs.getExperience();
                }
            });
        }

        protected void scrapeForPlayer(NflPlayerData playerToScrapeFor) throws IOException {
            Document combineResultsPage = getCombinePageForPlayerOfParameterizedExperience(playerToScrapeFor.getExperience());
            Elements playerElements = combineResultsPage.select("tr:contains(" + playerToScrapeFor.getPlayerFullName() + ")");
            setFortyTimeAndSpeedScoreFromPlayersPageElement(playerToScrapeFor, playerElements);
        }

            protected Document getCombinePageForPlayerOfParameterizedExperience(int experience) throws IOException {
                if(combineResultPageKeyedByYearsSinceTheCurrentYear.containsKey(experience))
                    return combineResultPageKeyedByYearsSinceTheCurrentYear.get(experience);
                else {
                    putNewCombineResultsPageInLinkedHashMap(experience);
                    return getCombinePageForPlayerOfParameterizedExperience(experience);
                }
            }

                protected void putNewCombineResultsPageInLinkedHashMap(int experience) throws IOException {
                    int combineYear = DateHelper.getCurrentYearAsYYYY() - experience;
                    String url = UrlHelper.getFourtyTimeBaseUrlForYear(combineYear);
                    combineResultPageKeyedByYearsSinceTheCurrentYear.put(experience, WebRequest.getDocumentFromUrl(url));
                }

            protected void setFortyTimeAndSpeedScoreFromPlayersPageElement(NflPlayerData player, Elements playerElements){
                double fortyTime = NflPlayerFactory.getFortyTimeInSecondsFromString(playerElements.select("td").get(7).text());
                player.setFortyTimeInSeconds(fortyTime);
                player.setSpeedScore(NflPlayerFactory.calcualteSpeedScoreFromFortyTimeInSecondsAndWeightInPounds(fortyTime, player.getWeightInPounds()));
            }
    //endregion

    //region GETTERS:
    public ArrayList<NflPlayerData> getPlayers(){
        return players;
    }
    //endregion
}
