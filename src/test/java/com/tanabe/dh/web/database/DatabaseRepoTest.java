package com.tanabe.dh.web.database;

import com.tanabe.dh.helpers.DateHelper;
import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.NflPlayerFactory;
import com.tanabe.dh.nfl.player.Position;
import com.tanabe.dh.nfl.team.NflTeam;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.List;


@EnableAutoConfiguration
public class DatabaseRepoTest extends TestCase {
    @Autowired
    private NflPlayerDataRepository repository;

    public void testAddingObject(){
        NflPlayerData brianTanabe = NflPlayerFactory.createNflPlayerData("TANABEBRIAN19890320", "Brian", "Tanabe", NflTeam.BRONCOS, Position.KICKER, 3, DateHelper.getCalendarObjectFromMMDDYYYYString("03/20/1989"), 125, 66, "Illinois", 4.9, NflPlayerFactory.calcualteSpeedScoreFromFortyTimeInSecondsAndWeightInPounds(4.9, 125));

        repository.deleteAll();
        repository.save(brianTanabe);

        List<NflPlayerData> playersInRepo = repository.findAll();
        for(NflPlayerData player : playersInRepo){
            System.out.println(player.toString());
        }

        NflPlayerData brianTanabePlayerData = repository.findByPlayerLastName("Tanabe").get(0);
        if(brianTanabePlayerData == null || NflPlayerFactory.areAllArgumentsLegal(brianTanabePlayerData)){
            fail("FAILED TO FIND A STORED BRIAN TANABE OBJECT");
        }
    }
}