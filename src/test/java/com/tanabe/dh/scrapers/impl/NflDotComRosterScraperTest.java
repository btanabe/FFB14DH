package com.tanabe.dh.scrapers.impl;

import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.NflPlayerFactory;
import com.tanabe.dh.nfl.team.NflTeam;
import junit.framework.TestCase;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NflDotComRosterScraperTest extends TestCase {

    //region Test getRosterPage for each NflTeam:
    public void testGetRosterPageForBills() throws Exception {
        testGetRosterPage(NflTeam.BILLS);
    }

    public void testGetRosterPageForDolphins() throws Exception {
        testGetRosterPage(NflTeam.DOLPHINS);
    }

    public void testGetRosterPageForPatriots() throws Exception {
        testGetRosterPage(NflTeam.PATRIOTS);
    }

    public void testGetRosterPageForJets() throws Exception {
        testGetRosterPage(NflTeam.JETS);
    }

    public void testGetRosterPageForRavens() throws Exception {
        testGetRosterPage(NflTeam.RAVENS);
    }

    public void testGetRosterPageForBengals() throws Exception {
        testGetRosterPage(NflTeam.BENGALS);
    }

    public void testGetRosterPageForBrowns() throws Exception {
        testGetRosterPage(NflTeam.BROWNS);
    }

    public void testGetRosterPageForSteelers() throws Exception {
        testGetRosterPage(NflTeam.STEELERS);
    }

    public void testGetRosterPageForTexans() throws Exception {
        testGetRosterPage(NflTeam.TEXANS);
    }

    public void testGetRosterPageForColts() throws Exception {
        testGetRosterPage(NflTeam.COLTS);
    }

    public void testGetRosterPageForJaguars() throws Exception {
        testGetRosterPage(NflTeam.JAGUARS);
    }

    public void testGetRosterPageForTitans() throws Exception {
        testGetRosterPage(NflTeam.TITANS);
    }

    public void testGetRosterPageForBroncos() throws Exception {
        testGetRosterPage(NflTeam.BRONCOS);
    }

    public void testGetRosterPageForChiefs() throws Exception {
        testGetRosterPage(NflTeam.CHIEFS);
    }

    public void testGetRosterPageForRaiders() throws Exception {
        testGetRosterPage(NflTeam.RAIDERS);
    }

    public void testGetRosterPageForChargers() throws Exception {
        testGetRosterPage(NflTeam.CHARGERS);
    }

    public void testGetRosterPageForCowboys() throws Exception {
        testGetRosterPage(NflTeam.COWBOYS);
    }

    public void testGetRosterPageForGiants() throws Exception {
        testGetRosterPage(NflTeam.GIANTS);
    }

    public void testGetRosterPageForEagles() throws Exception {
        testGetRosterPage(NflTeam.EAGLES);
    }

    public void testGetRosterPageForRedskins() throws Exception {
        testGetRosterPage(NflTeam.REDSKINS);
    }

    public void testGetRosterPageForBears() throws Exception {
        testGetRosterPage(NflTeam.BEARS);
    }

    public void testGetRosterPageForLions() throws Exception {
        testGetRosterPage(NflTeam.LIONS);
    }

    public void testGetRosterPageForPackers() throws Exception {
        testGetRosterPage(NflTeam.PACKERS);
    }

    public void testGetRosterPageForVikings() throws Exception {
        testGetRosterPage(NflTeam.VIKINGS);
    }

    public void testGetRosterPageForFalcons() throws Exception {
        testGetRosterPage(NflTeam.FALCONS);
    }

    public void testGetRosterPageForPanthers() throws Exception {
        testGetRosterPage(NflTeam.PANTHERS);
    }

    public void testGetRosterPageForSaints() throws Exception {
        testGetRosterPage(NflTeam.SAINTS);
    }

    public void testGetRosterPageForBuccaneers() throws Exception {
        testGetRosterPage(NflTeam.BUCCANEERS);
    }

    public void testGetRosterPageForCardinals() throws Exception {
        testGetRosterPage(NflTeam.CARDINALS);
    }

    public void testGetRosterPageForRams() throws Exception {
        testGetRosterPage(NflTeam.RAMS);
    }

    public void testGetRosterPageForFortyNiners() throws Exception {
        testGetRosterPage(NflTeam.FORTYNINERS);
    }

    public void testGetRosterPageForSeahawks() throws Exception {
        testGetRosterPage(NflTeam.SEAHAWKS);
    }
        protected void testGetRosterPage(NflTeam nflTeam) throws Exception {
            NflDotComRosterScraper rosterScraper = new NflDotComRosterScraper(nflTeam);
            Document rosterPageDocument = rosterScraper.getRosterPage(nflTeam);

            String pageHeader = rosterPageDocument.head().text();
            String goldHeaderText = nflTeam.getPrettyPrintedTeamName() + " Roster at NFL.com";

            if(!pageHeader.equals(goldHeaderText))
                fail("FAILED TO GRAB NFL.COM ROSTER TEAM PAGE FOR " + nflTeam.getPrettyPrintedTeamName().toUpperCase());
        }
    //endregion

    //region Test getPlayerElements for Broncos:
    public void testGetPlayerElementsForBroncos() throws IOException {
        NflDotComRosterScraper rosterScraper = new NflDotComRosterScraper(NflTeam.BRONCOS);

        Document rosterPage = rosterScraper.getRosterPage(NflTeam.BRONCOS);
        Elements playerElements = rosterScraper.getPlayerElements(rosterPage);

        if(playerElements == null || playerElements.size() == 0)
            fail("FAILED TO GET THE PROPER NUMBER OF PLAYERS ON THE BRONCOS");
    }
    //endregion

    //region Test serializeNflPlayerDataFromPlayerElements for Broncos:
    public void testSerializeNflPlayerDataFromPlayerElements() throws IOException {
        NflDotComRosterScraper rosterScraper = new NflDotComRosterScraper(NflTeam.BRONCOS);

        Document rosterPage = rosterScraper.getRosterPage(NflTeam.BRONCOS);
        Elements playerElements = rosterScraper.getPlayerElements(rosterPage);
        ArrayList<NflPlayerData> players = rosterScraper.serializeNflPlayerDataFromPlayerElements(playerElements, NflTeam.BRONCOS);

        if(players.size() == 0)
            fail("FAILED TO SERIALIZE ANY PLAYERS ON THE BRONCOS");

        int numberOfPlayersToCheckBeforeDeclaringWeFailed = 5;
        for(NflPlayerData player : players){
            if(!NflPlayerFactory.areAllArgumentsLegal(player))
                numberOfPlayersToCheckBeforeDeclaringWeFailed = numberOfPlayersToCheckBeforeDeclaringWeFailed - 1;
            if(numberOfPlayersToCheckBeforeDeclaringWeFailed <= 0){
                fail("FAILED TO SERIALIZE PLAYERS CORRECTLY");
                break;
            }
        }
    }
    //endregion
}