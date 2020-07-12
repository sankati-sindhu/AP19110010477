package com.example.recyclerview;

public class AndroidVersion {
    private int image;
    private String name, apiLevel, releaseDate, versionNo;
    AndroidVersion(int image, String name, String versionNo, String apiLevel, String releaseDate){
        this.image = image;
        this.name = name;
        this.apiLevel = apiLevel;
        this.releaseDate = releaseDate;
        this.versionNo = versionNo;

    }
    public  int getImage(){return image;}
    public String getReleaseDate(){
        return releaseDate;
    }
    public String getName(){
        return name;
    }
    public String getApiLevel(){
        return apiLevel;
    }
    public String getVersionNo(){
        return versionNo;
    }
}
