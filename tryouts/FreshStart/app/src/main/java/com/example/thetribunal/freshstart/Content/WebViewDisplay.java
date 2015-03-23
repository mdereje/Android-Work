package com.example.thetribunal.freshstart.Content;

/**
 * Created by The Tribunal on 12/22/2014.
 */
public class WebViewDisplay {
    private static final String circuitIntro = "http://en.m.wikipedia.org/wiki/Electronic_circuit";
    private static final String ESIntro = "http://en.m.wikipedia.org/wiki/Embedded_system";
    private static final String MDIntro = "http://en.m.wikipedia.org/wiki/Mobile_application_development";
    private static final String MathIntro = "http://en.m.wikipedia.org/wiki/Mathematics";
    private static final String AlgIntro = "http://en.m.wikipedia.org/wiki/Algorithm";

    public static String returnURL(int pos){
        if(pos == 1){
            return circuitIntro;
        }
        if(pos == 2){
            return ESIntro;
        }
        if(pos == 3){
            return MDIntro;
        }
        if(pos == 4){
            return MathIntro;
        }
        if(pos == 5){
            return AlgIntro;
        }
        return "";
    }
}
