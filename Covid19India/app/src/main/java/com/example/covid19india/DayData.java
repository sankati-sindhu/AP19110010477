package com.example.covid19india;

public class DayData {
    private String date;
    private String casesActive, casesRecovered, Deceased;

    DayData(String date, String casesActive, String casesRecovered, String Deceased){
        this.date = date;
        this.casesActive = casesActive;
        this.casesRecovered = casesRecovered;
        this.Deceased = Deceased;
    }
    public String getDate(){
        return date;
    }
    public String getCasesActive(){
        return casesActive;
    }
    public String getCasesRecovered(){
        return casesRecovered;
    }
    public String getDeceased(){
        return Deceased;
    }

}
