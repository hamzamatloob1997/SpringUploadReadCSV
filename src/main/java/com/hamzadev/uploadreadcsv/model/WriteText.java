package com.hamzadev.uploadreadcsv.model;

public class WriteText {
    private String koiBhi;

    public WriteText() {
    }

    public WriteText(String koiBhi) {
        this.koiBhi = koiBhi;
    }

    public String getKoiBhi() {
        return koiBhi;
    }

    public void setKoiBhi(String koiBhi) {
        this.koiBhi = koiBhi;
    }

    @Override
    public String toString() {
        return "WriteText{" +
                "koiBhi='" + koiBhi + '\'' +
                '}';
    }
}
