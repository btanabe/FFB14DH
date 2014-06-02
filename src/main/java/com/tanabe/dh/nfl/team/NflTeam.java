package com.tanabe.dh.nfl.team;

/**
 * Created by BTanabe on 5/28/2014.
 */
public enum NflTeam {
    BILLS(NflTeamType.BILLS_TYPE),
    DOLPHINS(NflTeamType.DOLPHINS_TYPE),
    PATRIOTS(NflTeamType.PATRIOTS_TYPE),
    JETS(NflTeamType.JETS_TYPE),
    RAVENS(NflTeamType.RAVENS_TYPE),
    BENGALS(NflTeamType.BENGALS_TYPE),
    BROWNS(NflTeamType.BROWNS_TYPE),
    STEELERS(NflTeamType.STEELERS_TYPE),
    TEXANS(NflTeamType.TEXANS_TYPE),
    COLTS(NflTeamType.COLTS_TYPE),
    JAGUARS(NflTeamType.JAGUARS_TYPE),
    TITANS(NflTeamType.TITANS_TYPE),
    BRONCOS(NflTeamType.BRONCOS_TYPE),
    CHIEFS(NflTeamType.CHIEFS_TYPE),
    RAIDERS(NflTeamType.RAIDERS_TYPE),
    CHARGERS(NflTeamType.CHARGERS_TYPE),
    COWBOYS(NflTeamType.COWBOYS_TYPE),
    GIANTS(NflTeamType.GIANTS_TYPE),
    EAGLES(NflTeamType.EAGLES_TYPE),
    REDSKINS(NflTeamType.REDSKINS_TYPE),
    BEARS(NflTeamType.BEARS_TYPE),
    LIONS(NflTeamType.LIONS_TYPE),
    PACKERS(NflTeamType.PACKERS_TYPE),
    VIKINGS(NflTeamType.VIKINGS_TYPE),
    FALCONS(NflTeamType.FALCONS_TYPE),
    PANTHERS(NflTeamType.PANTHERS_TYPE),
    SAINTS(NflTeamType.SAINTS_TYPE),
    BUCCANEERS(NflTeamType.BUCCANEERS_TYPE),
    CARDINALS(NflTeamType.CARDINALS_TYPE),
    RAMS(NflTeamType.RAMS_TYPE),
    FORTYNINERS(NflTeamType.FOURTYNINERS_TYPE),
    SEAHAWKS(NflTeamType.SEAHAWKS_TYPE),
    UNKNOWN(NflTeamType.UNKNOWN_TYPE);

    private NflTeamType type;
    private NflTeam(NflTeamType tpye){
        this.type = type;
    }

    public NflTeamType getType(){
        return type;
    }

    public String getPrettyPrintedTeamAbbreviation(){
        switch(this){
            case BILLS:
                return "BUF";
            case DOLPHINS:
                return "MIA";
            case PATRIOTS:
                return "NE";
            case JETS:
                return "NYJ";
            case RAVENS:
                return "BAL";
            case BENGALS:
                return "CIN";
            case BROWNS:
                return "CLE";
            case STEELERS:
                return "PIT";
            case TEXANS:
                return "HOU";
            case COLTS:
                return "IND";
            case JAGUARS:
                return "JAX";
            case TITANS:
                return "TEN";
            case BRONCOS:
                return "DEN";
            case CHIEFS:
                return "KC";
            case RAIDERS:
                return "OAK";
            case CHARGERS:
                return "SD";
            case COWBOYS:
                return "DAL";
            case GIANTS:
                return "NYG";
            case EAGLES:
                return "PHI";
            case REDSKINS:
                return "WAS";
            case BEARS:
                return "CHI";
            case LIONS:
                return "DET";
            case PACKERS:
                return "GB";
            case VIKINGS:
                return "MIN";
            case FALCONS:
                return "ATL";
            case PANTHERS:
                return "CAR";
            case SAINTS:
                return "NO";
            case BUCCANEERS:
                return "TB";
            case CARDINALS:
                return "ARI";
            case RAMS:
                return "STL";
            case FORTYNINERS:
                return "SF";
            case SEAHAWKS:
                return "SEA";
            case UNKNOWN:
            default:
                return "UNKNOWN";
        }
    }

    public String getPrettyPrintedNflDotComTeamAbbreviation(){
        switch(this){
            case BILLS:
                return "BUF";
            case DOLPHINS:
                return "MIA";
            case PATRIOTS:
                return "NE";
            case JETS:
                return "NYJ";
            case RAVENS:
                return "BAL";
            case BENGALS:
                return "CIN";
            case BROWNS:
                return "CLE";
            case STEELERS:
                return "PIT";
            case TEXANS:
                return "HOU";
            case COLTS:
                return "IND";
            case JAGUARS:
                return "JAX";
            case TITANS:
                return "TEN";
            case BRONCOS:
                return "DEN";
            case CHIEFS:
                return "KC";
            case RAIDERS:
                return "OAK";
            case CHARGERS:
                return "SD";
            case COWBOYS:
                return "DAL";
            case GIANTS:
                return "NYG";
            case EAGLES:
                return "PHI";
            case REDSKINS:
                return "WAS";
            case BEARS:
                return "CHI";
            case LIONS:
                return "DET";
            case PACKERS:
                return "GB";
            case VIKINGS:
                return "MIN";
            case FALCONS:
                return "ATL";
            case PANTHERS:
                return "CAR";
            case SAINTS:
                return "NO";
            case BUCCANEERS:
                return "TB";
            case CARDINALS:
                return "ARI";
            case RAMS:
                return "STL";
            case FORTYNINERS:
                return "SF";
            case SEAHAWKS:
                return "SEA";
            case UNKNOWN:
            default:
                return "UNKNOWN";
        }
    }

    public String getPrettyPrintedTeamName(){
        switch(this){
            case BILLS:
                return "Buffalo Bills";
            case DOLPHINS:
                return "Miami Dolphins";
            case PATRIOTS:
                return "New England Patriots";
            case JETS:
                return "New York Jets";
            case RAVENS:
                return "Baltimore Ravens";
            case BENGALS:
                return "Cincinnati Bengals";
            case BROWNS:
                return "Cleveland Browns";
            case STEELERS:
                return "Pittsburgh Steelers";
            case TEXANS:
                return "Houston Texans";
            case COLTS:
                return "Indianapolis Colts";
            case JAGUARS:
                return "Jacksonville Jaguars";
            case TITANS:
                return "Tennessee Titans";
            case BRONCOS:
                return "Denver Broncos";
            case CHIEFS:
                return "Kansas City Chiefs";
            case RAIDERS:
                return "Oakland Raiders";
            case CHARGERS:
                return "San Diego Chargers";
            case COWBOYS:
                return "Dallas Cowboys";
            case GIANTS:
                return "New York Giants";
            case EAGLES:
                return "Philadelphia Eagles";
            case REDSKINS:
                return "Washington Redskins";
            case BEARS:
                return "Chicago Bears";
            case LIONS:
                return "Detroit Lions";
            case PACKERS:
                return "Green Bay Packers";
            case VIKINGS:
                return "Minnesota Vikings";
            case FALCONS:
                return "Atlanta Falcons";
            case PANTHERS:
                return "Carolina Panthers";
            case SAINTS:
                return "New Orleans Saints";
            case BUCCANEERS:
                return "Tampa Bay Buccaneers";
            case CARDINALS:
                return "Arizona Cardinals";
            case RAMS:
                return "St. Louis Rams";
            case FORTYNINERS:
                return "San Francisco 49ers";
            case SEAHAWKS:
                return "Seattle Seahawks";
            case UNKNOWN:
            default:
                return "UNKNOWN";
        }
    }

    public static NflTeam whatTeam(String teamName){
        teamName = teamName.toLowerCase();
        if(teamName.contains("buffalo") || teamName.contains("bills") || teamName.contains("buf"))
            return BILLS;
        else if(teamName.contains("miami") || teamName.contains("dolphins") || teamName.contains("mia"))
            return DOLPHINS;
        else if(teamName.contains("new england") || teamName.contains("patriots") || teamName.contains("ne"))
            return PATRIOTS;
        else if(teamName.contains("new york jets") || teamName.contains("jets") || teamName.contains("nyj"))
            return JETS;
        else if(teamName.contains("baltimore") || teamName.contains("ravens") || teamName.contains("bal"))
            return RAVENS;
        else if(teamName.contains("cincinnatti") || teamName.contains("bengals") || teamName.contains("cin"))
            return BENGALS;
        else if(teamName.contains("cleveland") || teamName.contains("browns") || teamName.contains("cle"))
            return BROWNS;
        else if(teamName.contains("pittsburgh") || teamName.contains("steelers") || teamName.contains("pit"))
            return STEELERS;
        else if(teamName.contains("houston") || teamName.contains("texans") || teamName.contains("hou"))
            return TEXANS;
        else if(teamName.contains("indianapolis") || teamName.contains("colts") || teamName.contains("ind"))
            return COLTS;
        else if(teamName.contains("jacksonville") || teamName.contains("jaguars") || teamName.contains("jax") || teamName.contains("jag"))
            return JAGUARS;
        else if(teamName.contains("tennessee") || teamName.contains("titans") || teamName.contains("ten"))
            return TITANS;
        else if(teamName.contains("denver") || teamName.contains("broncos") || teamName.contains("den"))
            return BRONCOS;
        else if(teamName.contains("kansas city") || teamName.contains("chiefs") || teamName.contains("kc"))
            return CHIEFS;
        else if(teamName.contains("oakland") || teamName.contains("raiders") || teamName.contains("oak"))
            return RAIDERS;
        else if(teamName.contains("san diago") || teamName.contains("chargers") || teamName.contains("sd"))
            return CHARGERS;
        else if(teamName.contains("dallas") || teamName.contains("cowboys") || teamName.contains("dal"))
            return COWBOYS;
        else if(teamName.contains("new york giants") || teamName.contains("giants") || teamName.contains("nyg"))
            return GIANTS;
        else if(teamName.contains("philadelphia") || teamName.contains("eagles") || teamName.contains("phi"))
            return EAGLES;
        else if(teamName.contains("washington") || teamName.contains("redskins") || teamName.contains("was"))
            return REDSKINS;
        else if(teamName.contains("chicago") || teamName.contains("bears") || teamName.contains("chi"))
            return BEARS;
        else if(teamName.contains("detroit") || teamName.contains("lions") || teamName.contains("det"))
            return LIONS;
        else if(teamName.contains("green bay") || teamName.contains("packers") || teamName.contains("gb"))
            return PACKERS;
        else if(teamName.contains("minnesota") || teamName.contains("vikings") || teamName.contains("min"))
            return VIKINGS;
        else if(teamName.contains("atlanta") || teamName.contains("falcons") || teamName.contains("atl"))
            return FALCONS;
        else if(teamName.contains("carolina") || teamName.contains("panthers") || teamName.contains("car"))
            return PANTHERS;
        else if(teamName.contains("new orleans") || teamName.contains("saints") || teamName.contains("no"))
            return SAINTS;
        else if(teamName.contains("tampa bay") || teamName.contains("buccaneers") || teamName.contains("bucs") || teamName.contains("tb"))
            return BUCCANEERS;
        else if(teamName.contains("arizona") || teamName.contains("cardinals") || teamName.contains("ari"))
            return CARDINALS;
        else if(teamName.contains("st. louis") || teamName.contains("st louis") || teamName.contains("rams") || teamName.contains("stl"))
            return RAMS;
        else if(teamName.contains("san francisco") || teamName.contains("49ers") || teamName.contains("sf"))
            return FORTYNINERS;
        else if(teamName.contains("seattle") || teamName.contains("seahawks") || teamName.contains("sea"))
            return SEAHAWKS;
        else
            return UNKNOWN;
    }

    public static NflTeam[] getAllNflTeams(){
        NflTeam[] allTeams = NflTeam.values();
        NflTeam[] allTeamsWithoutUnknownTeam = new NflTeam[allTeams.length - 1];
        System.arraycopy(allTeams, 0, allTeamsWithoutUnknownTeam, 0, allTeams.length - 1);

        return allTeamsWithoutUnknownTeam;
    }
}
