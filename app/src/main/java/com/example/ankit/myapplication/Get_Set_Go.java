package com.example.ankit.myapplication;

/**
 * Created by ankit on 06-07-2017.
 */

public class Get_Set_Go {
    private String rank;
    private int img;

    public Get_Set_Go(int img, String rank) {

        this.rank = rank;

        this.img = img;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}