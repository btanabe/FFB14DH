package com.tanabe.dh.helpers;

import com.tanabe.dh.nfl.team.NflTeam;

/**
 * Created by BTanabe on 5/29/2014.
 */
public class UrlHelper {

    //region DATABASE:
    public static String getDatabaseAddress(){
        return "10.0.2.15";
    }

    public static String getDatabasePort(){
        return "20100";
    }

    public static String getDatabaseName(){
        return "ffb14db";
    }
    //endregion

    //region WEB PAGES:
    public static String getFourtyTimeBaseUrlForYear(int year){
        return "http://nflcombineresults.com/nflcombinedata.php?year=" + year;
    }

    public static String getNflTeamRosterUrl(NflTeam nflTeam){
        return "http://www.nfl.com/teams/roster?team=" + nflTeam.getPrettyPrintedNflDotComTeamAbbreviation();
    }
    //endregion
}
