/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author mathiashartveit1
 */
public class Debug {
    /***
     * Easier access to {@link System} print
     * @param The object to be printed 
     */
    public static void Print(Object output) {
        System.out.println(output);
    }
    
    /***
     * Easier access to {@link System} print error
     * @param The object to be printed 
     */
    public static void PrintError(Object output) {
        System.err.print(output);
    }
    
    

    
    
}
