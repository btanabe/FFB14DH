package com.tanabe.dh.nfl.player;

import com.tanabe.dh.helpers.StringHelper;
import com.tanabe.dh.nfl.team.NflTeam;

import java.util.Calendar;

/**
 * Created by BTanabe on 5/30/2014.
 */
public class NflPlayerFactory {

    public static NflPlayerData createNflPlayerData(String id, String playerFirstName, String playerLastName, NflTeam currentTeam, Position position, int experience, Calendar birthday, int weightInPounds, int heightInInches, String college, double fortyTimeInSeconds, double speedScore){
        return new NflPlayerData(id, playerFirstName, playerLastName, currentTeam, position, experience, birthday, weightInPounds, heightInInches, college, fortyTimeInSeconds, speedScore);
    }

    //region ARGUMENT LEGALITY CHECKERS:
    public static boolean areAllArgumentsLegal(NflPlayerData player){
        return isIdLegal(player) && isFirstNameLegal(player) && isLastNameLegal(player) && isCurrentTeamLegal(player) && isPositionLegal(player) && isExperienceLegal(player) && isBirthdayLegal(player) && isWeightInPoundsLegal(player) && isHeightInInchesLegal(player) && isCollegeLegal(player) && isFortyTimeInSecondsLegal(player) && isSpeedScoreLegal(player);
    }

    public static boolean areIdNameTeamPositionLegal(NflPlayerData player){
        return isIdLegal(player) && isFirstNameLegal(player) && isLastNameLegal(player) && isCurrentTeamLegal(player) && isPositionLegal(player);
    }

        protected static boolean isIdLegal(NflPlayerData player){
            return (player.getId() != null) && (!player.getId().contains("XXXXXXXX"));
        }

        protected static boolean isFirstNameLegal(NflPlayerData player){
            return (player.getPlayerFirstName() != null) && (!player.getPlayerFirstName().isEmpty());
        }

        protected static boolean isLastNameLegal(NflPlayerData player){
            return (player.getPlayerLastName() != null) && (!player.getPlayerLastName().isEmpty());
        }

        protected static boolean isCurrentTeamLegal(NflPlayerData player){
            return (player.getCurrentTeam() != null) && (player.getCurrentTeam() != NflTeam.UNKNOWN);
        }

        protected static boolean isPositionLegal(NflPlayerData player){
            return (player.getPosition() != null) && (player.getPosition() != Position.UNKNOWN);
        }

        protected static boolean isExperienceLegal(NflPlayerData player){
            return player.getExperience() >= 0;
        }

        protected static boolean isBirthdayLegal(NflPlayerData player){
            return (player.getBirthday() != null) && (player.getBirthday().get(Calendar.YEAR) > 1960);
        }

        protected static boolean isWeightInPoundsLegal(NflPlayerData player){
            return player.getWeightInPounds() > 0;
        }

        protected static boolean isHeightInInchesLegal(NflPlayerData player){
            return player.getHeightInInches() > 0;
        }

        protected static boolean isCollegeLegal(NflPlayerData player){
            return (player.getCollege() != null) && (!player.getCollege().isEmpty());
        }

        protected static boolean isFortyTimeInSecondsLegal(NflPlayerData player){
            return player.getFortyTimeInSeconds() > 0;
        }

        protected static boolean isSpeedScoreLegal(NflPlayerData player){
            return player.getSpeedScore() > 0;
        }
    //endregion

    //region GETTERS:
    public static String getFirstNameFromLastCommaFirst(String fullName){
        try {
            String[] names = fullName.split(",");
            return names[1].trim();
        } catch (Exception ex){
            return "";
        }
    }

    public static String getLastNameFromLastCommaFirst(String fullName){
        try {
            String[] names = fullName.split(",");
            return names[0].trim();
        } catch (Exception ex){
            return "";
        }
    }

    public static int getWeightInPoundsAsIntegerFromString(String weightString){
        try {
            return Integer.parseInt(weightString);
        } catch(Exception ex){
            return -1;
        }
    }

    public static int getHeightInInchesAsIntegerFromString(String heightString){
        try {
            String[] feetAndInches = heightString.split("'");
            return Integer.parseInt(feetAndInches[0]) * 12 + Integer.parseInt(feetAndInches[1].replace("\"", ""));
        } catch(Exception ex){
            return -1;
        }
    }

    public static int getExperienceFromString(String experienceString){
        try {
            return Integer.parseInt(experienceString);
        } catch(Exception ex){
            return -1;
        }
    }

    public static double getFortyTimeInSecondsFromString(String fortyTimeInSecondsString){
        try {
            return Double.parseDouble(fortyTimeInSecondsString);
        } catch(NumberFormatException ex){
            return -1;
        }
    }

    public static double calcualteSpeedScoreFromFortyTimeInSecondsAndWeightInPounds(double fortyTimeInSeconds, double weightInPounds){
        if(fortyTimeInSeconds > 0 && weightInPounds > 0)
            return (200 * weightInPounds) / Math.pow(fortyTimeInSeconds, 4);
        else
            return -1;
    }

    public static String getPlayerId(String lastName, String firstName, Calendar birthday){
        if(birthday != null){
            int birthMonth = birthday.get(Calendar.MONTH) + 1;
            String birthMonthString = (birthMonth > 9) ? String.valueOf(birthMonth) : "0" + birthMonth;

            int dayOfMonth = birthday.get(Calendar.DAY_OF_MONTH);
            String dayOfMonthString = (dayOfMonth > 9) ? String.valueOf(dayOfMonth) : "0" + dayOfMonth;

            int yearString = birthday.get(Calendar.YEAR);
            return StringHelper.replaceIllegalCharacters(lastName.toUpperCase() + firstName.toUpperCase() + yearString + birthMonthString + dayOfMonthString);
        } else {
            return StringHelper.replaceIllegalCharacters(lastName.toUpperCase() + firstName.toUpperCase() + "XXXXXXXX");
        }
    }
    //endregion
}
