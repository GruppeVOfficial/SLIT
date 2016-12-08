/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import GUI.Main;


/**
 *
 * @author mathiashartveit1
 */
public class Utilities {
    
    /***
     * Converts a string date of YYYY-MM-DD to
     * DD-MM-YYYY
     * @param date - The date to be converted
     * @return The converted string
     */
    public static String convertDate(String date) {
        // YYYY-MM-DD
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        
        date = day + "-" + month + "-" + year;
        
        return date;
    }
    

    
}
