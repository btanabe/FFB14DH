package com.tanabe.dh.web.database;

import com.tanabe.dh.helpers.DateHelper;
import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.NflPlayerFactory;
import com.tanabe.dh.nfl.player.Position;
import com.tanabe.dh.nfl.team.NflTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by BTanabe on 6/3/2014.
 */
@EnableAutoConfiguration
public class DatabaseInterface {
    @Autowired
//    private NflPlayerDataRepository repository;

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");

        NflPlayerData brianTanabe = NflPlayerFactory.createNflPlayerData("TANABEBRIAN19890320", "Brian", "Tanabe", NflTeam.BRONCOS, Position.KICKER, 3, DateHelper.getCalendarObjectFromMMDDYYYYString("03/20/1989"), 125, 66, "Illinois", 4.9, NflPlayerFactory.calcualteSpeedScoreFromFortyTimeInSecondsAndWeightInPounds(4.9, 125));

        mongoOperations.save(brianTanabe);

        NflPlayerData foundTanabe = mongoOperations.findOne(new Query(Criteria.where("lastName").is("Tanabe")), NflPlayerData.class);

        System.out.println(foundTanabe.toString());
        /*
        NflPlayerData brianTanabe = NflPlayerFactory.createNflPlayerData("TANABEBRIAN19890320", "Brian", "Tanabe", NflTeam.BRONCOS, Position.KICKER, 3, DateHelper.getCalendarObjectFromMMDDYYYYString("03/20/1989"), 125, 66, "Illinois", 4.9, NflPlayerFactory.calcualteSpeedScoreFromFortyTimeInSecondsAndWeightInPounds(4.9, 125));

        repository.deleteAll();
        repository.save(brianTanabe);

        List<NflPlayerData> playersInRepo = repository.findAll();
        for(NflPlayerData player : playersInRepo){
            System.out.println(player.toString());
        }

        NflPlayerData brianTanabePlayerData = repository.findByPlayerLastName("Tanabe").get(0);
        if(brianTanabePlayerData == null || NflPlayerFactory.areAllArgumentsLegal(brianTanabePlayerData)){
            System.out.println("FAILED TO FIND A STORED BRIAN TANABE OBJECT");
        }
        */
    }
}

//http://www.mkyong.com/mongodb/spring-data-mongodb-hello-world-example/
