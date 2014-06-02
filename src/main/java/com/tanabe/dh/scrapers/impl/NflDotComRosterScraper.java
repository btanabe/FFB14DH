package com.tanabe.dh.scrapers.impl;

import com.tanabe.dh.helpers.DateHelper;
import com.tanabe.dh.helpers.UrlHelper;
import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.NflPlayerFactory;
import com.tanabe.dh.nfl.player.Position;
import com.tanabe.dh.nfl.team.NflTeam;
import com.tanabe.dh.web.WebRequest;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by BTanabe on 5/29/2014.
 */
public class NflDotComRosterScraper {
    protected NflTeam[] nflTeam;
    protected ArrayList<NflPlayerData> players;

    //region CONSTRUCTORS:
    public NflDotComRosterScraper(){
        nflTeam = NflTeam.getAllNflTeams();
    }

    public NflDotComRosterScraper(NflTeam nflTeam){
        this.nflTeam = new NflTeam[] { nflTeam };
    }
    //endregion

    public void getPlayerRosterDataForAllPlayers() throws IOException {
        ArrayList<NflPlayerData> players = new ArrayList<NflPlayerData>(900);

        for(NflTeam nflTeam : this.nflTeam){
            players.addAll(getPlayerRosterDataForPlayersOnNflTeam(nflTeam));
        }

        this.players = players;
    }

        protected ArrayList<NflPlayerData> getPlayerRosterDataForPlayersOnNflTeam(NflTeam nflTeam) throws IOException{
            Document rosterPage = getRosterPage(nflTeam);
            Elements playerElements = getPlayerElements(rosterPage);
            return serializeNflPlayerDataFromPlayerElements(playerElements, nflTeam);
        }

            protected Document getRosterPage(NflTeam nflTeam) throws IOException {
                String url = UrlHelper.getNflTeamRosterUrl(nflTeam);
                return WebRequest.getDocumentFromUrl(url);
            }

            protected Elements getPlayerElements(Document rosterPage){
                // Get all players on team:
                Elements allPlayerElements = rosterPage.select("tr.odd, tr.even");
                return allPlayerElements;
            }

            protected ArrayList<NflPlayerData> serializeNflPlayerDataFromPlayerElements(Elements playerElements, NflTeam currentTeam){
                ArrayList<NflPlayerData> players = new ArrayList<NflPlayerData>(90);

                for(Element player : playerElements){
                    NflPlayerData playerToAdd = getNflPlayerDataFromElement(player, currentTeam);
                    if(playerToAdd != null) {
                        players.add(playerToAdd);
                    }
                }

                return players;
            }

                protected NflPlayerData getNflPlayerDataFromElement(Element playerElement, NflTeam currentTeam){
                    Position position = Position.whatPosition(playerElement.select("td").get(2).text());
                    String firstName = NflPlayerFactory.getFirstNameFromLastCommaFirst(playerElement.select("a[href^=/player/]").text());
                    String lastName = NflPlayerFactory.getLastNameFromLastCommaFirst(playerElement.select("a[href^=/player/]").text());
                    int height = NflPlayerFactory.getHeightInInchesAsIntegerFromString(playerElement.select("td").get(4).text());
                    int weight = NflPlayerFactory.getWeightInPoundsAsIntegerFromString(playerElement.select("td").get(5).text());
                    Calendar birthday = DateHelper.getCalendarObjectFromMMDDYYYYString(playerElement.select("td").get(6).text());
                    int experience = NflPlayerFactory.getExperienceFromString(playerElement.select("td").get(7).text());
                    String college = playerElement.select("td").get(8).text();
                    String id = NflPlayerFactory.getPlayerId(lastName, firstName, birthday);

                    NflPlayerData playerToAdd = NflPlayerFactory.createNflPlayerData(id, firstName, lastName, currentTeam, position, experience, birthday, weight, height, college, -1, -1);

                    if(NflPlayerFactory.areIdNameTeamPositionLegal(playerToAdd))
                        return playerToAdd;
                    else
                        return null;
                }

    // GETTERS:
    public ArrayList<NflPlayerData> getPlayers(){
        return players;
    }
}
