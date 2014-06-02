package com.tanabe.dh.nfl.player;

/**
 * Created by BTanabe on 5/29/2014.
 */
public enum Position {
    QUARTERBACK(PositionType.QUARTERBACK_TYPE),
    RUNNING_BACK(PositionType.RUNNING_BACK_TYPE),
    WIDE_RECEIVER(PositionType.WIDE_RECEIVER_TYPE),
    TIGHT_END(PositionType.TIGHT_END_TYPE),
    KICKER(PositionType.KICKER_TYPE),
    DEFENSE(PositionType.DEFENSE_TYPE),
    UNKNOWN(PositionType.UNKNOWN_TYPE);

    private PositionType type;
    private Position(PositionType type){
        this.type = type;
    }

    public static Position whatPosition(String positionString){
        positionString = positionString.toLowerCase();

        if(positionString.contains("qb") || positionString.contains("quarterback"))
            return Position.QUARTERBACK;
        else if(positionString.contains("rb") || positionString.contains("running back") || positionString.contains("tailback") || positionString.contains("tb"))
            return Position.RUNNING_BACK;
        else if(positionString.contains("wide receiver") || positionString.contains("wr") || positionString.contains("wideout"))
            return  Position.WIDE_RECEIVER;
        else if(positionString.contains("tight end") || positionString.contains("te"))
            return Position.TIGHT_END;
        else if(positionString.contains("kicker") || positionString.contains("k") || positionString.contains("pk"))
            return Position.KICKER;
        else if(positionString.contains("defense") || positionString.contains("def") || positionString.contains("special teams") || positionString.contains("d/st"))
            return Position.DEFENSE;
        else
            return Position.UNKNOWN;
    }

    @Override
    public String toString() {
        String stringRepresentation = "UNKNOWN";
        switch(this){
            case QUARTERBACK:
                stringRepresentation = "QB";
                break;
            case RUNNING_BACK:
                stringRepresentation = "RB";
                break;
            case WIDE_RECEIVER:
                stringRepresentation = "WR";
                break;
            case TIGHT_END:
                stringRepresentation = "TE";
                break;
            case KICKER:
                stringRepresentation = "K";
                break;
            case DEFENSE:
                stringRepresentation = "D/ST";
                break;
            default:
                stringRepresentation = "UNKNOWN";
                break;
        }

        return stringRepresentation;
    }
}
