package com.tanabe.dh.nfl.player;

import com.tanabe.dh.nfl.team.NflTeam;

import org.springframework.data.annotation.Id;
import java.util.Calendar;

/**
 * Created by BTanabe on 5/29/2014.
 */
public class NflPlayerData {
    // Database id:
    @Id
    protected String id;

    // Biography and roster info:
    protected String playerFirstName;
    protected String playerLastName;
    protected NflTeam currentTeam;
    protected Position position;
    protected int experience;
    protected Calendar birthday;
    protected int weightInPounds;
    protected int heightInInches;
    protected String college;

    // Combine data:
    protected double fortyTimeInSeconds;
    protected double speedScore;

    public NflPlayerData(String id, String playerFirstName, String playerLastName, NflTeam currentTeam, Position position, int experience, Calendar birthday, int weightInPounds, int heightInInches, String college, double fortyTimeInSeconds, double speedScore){
        this.id = id;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.currentTeam = currentTeam;
        this.position = position;
        this.experience = experience;
        this.birthday = birthday;
        this.weightInPounds = weightInPounds;
        this.heightInInches = heightInInches;
        this.college = college;
        this.fortyTimeInSeconds = fortyTimeInSeconds;
        this.speedScore = speedScore;
    }

    public String getId(){
        return id;
    }

    public void setId(String newId){
        this.id = id;
    }

    public NflTeam getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(NflTeam currentTeam) {
        this.currentTeam = currentTeam;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerFullName(){
        return getPlayerFirstName() + " " + getPlayerLastName();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public double getFortyTimeInSeconds() {
        return fortyTimeInSeconds;
    }

    public void setFortyTimeInSeconds(double fortyTimeInSeconds) {
        this.fortyTimeInSeconds = fortyTimeInSeconds;
    }

    public double getSpeedScore() {
        return speedScore;
    }

    public void setSpeedScore(double speedScore) {
        this.speedScore = speedScore;
    }

    @Override
    public String toString() {
        return getPlayerFullName() + " (" + getCurrentTeam() + ") - " + getPosition().toString() + " - " + getId();
    }
}
