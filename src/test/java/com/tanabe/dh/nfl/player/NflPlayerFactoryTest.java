package com.tanabe.dh.nfl.player;

import com.tanabe.dh.helpers.DateHelper;
import junit.framework.TestCase;

import java.util.Calendar;

public class NflPlayerFactoryTest extends TestCase {

    public void testGetPlayerIdMarchSecond (){
        String goldValue = "TANABEBRIAN19890302";

        Calendar birthday = DateHelper.getCalendarObjectFromMMDDYYYYString("3/2/1989");
        String idFromFunction = NflPlayerFactory.getPlayerId("Tanabe", "Brian", birthday);

        if(!idFromFunction.equals(goldValue)){
            String errorMessage = "\r\nFailed to generate ID correctly for Brian Tanabe 3/2/1989\r\n";
            errorMessage += "GOT:\t\t" + idFromFunction + "\r\n";
            errorMessage += "EXPECTED:\t" + goldValue;

            fail(errorMessage);
        }
    }

    public void testGetHeightClean(){
        String heightString = "5'8\"";
        int goldValue = 68;
        int heightFromFunction = NflPlayerFactory.getHeightInInchesAsIntegerFromString(heightString);

        if(goldValue != heightFromFunction){
            String errorMessage = "\r\nFailed to calcualte height properly for " + heightString + "\r\n";
            errorMessage += "GOT:\t\t" + heightFromFunction + "\r\n";
            errorMessage += "EXPECTED:\t" + goldValue;

            fail(errorMessage);
        }
    }

    public void testGetHeightDoubleDigits(){
        String heightString = "6'10\"";
        int goldValue = 82;
        int heightFromFunction = NflPlayerFactory.getHeightInInchesAsIntegerFromString(heightString);

        if(goldValue != heightFromFunction){
            String errorMessage = "\r\nFailed to calcualte height properly for " + heightString + "\r\n";
            errorMessage += "GOT:\t\t" + heightFromFunction + "\r\n";
            errorMessage += "EXPECTED:\t" + goldValue;

            fail(errorMessage);
        }
    }

    public void testGetHeightIllegalNoFootTick(){
        String heightString = "610";
        int goldValue = -1;
        int heightFromFunction = NflPlayerFactory.getHeightInInchesAsIntegerFromString(heightString);

        if(goldValue != heightFromFunction){
            String errorMessage = "\r\nFailed to calcualte height properly for " + heightString + "\r\n";
            errorMessage += "GOT:\t\t" + heightFromFunction + "\r\n";
            errorMessage += "EXPECTED:\t" + goldValue;

            fail(errorMessage);
        }
    }
}