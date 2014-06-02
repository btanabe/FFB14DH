package com.tanabe.dh.helpers;

/**
 * Created by BTanabe on 6/2/2014.
 */
public class StringHelper {

    public static String replaceIllegalCharacters(String dirtyString){
        String cleanString = dirtyString;

        cleanString = cleanString.replaceAll("\\.", "");
        cleanString = cleanString.replace("\'", "");

        return cleanString;
    }
}
