/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiaeTest;

/**
 * Die mögliche Zonen im Automaten
 * @author Jörg
 */
public enum Zonen {
    Zone1,Zone2,Zone3;
    
    public static String getName(Zonen z) {
        switch (z) {
            case Zone1:
                return "Zone 1";
            case Zone2:
                return "Zone 2";
            case Zone3:
                return "Zone 3";
        }
        return null;
    }
    
    public static double getPrice(Zonen z) {
        switch (z) {
            case Zone1:
                return 1.35;
            case Zone2:
                return 2.35;
            case Zone3:
                return 3.5;
        }
        return 0.0;
    }
    
        
}
