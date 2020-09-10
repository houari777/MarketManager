package com.houari.marketmanager.entities;

public class credit {
   private int ID_CREDIT;
   private String GENRE_CREDIT;
   private String DATE;
   private String PRIX;
   // private String PRIX_TOTAL;
    private int ID_CLIENT;

    public credit(int ID_CREDIT, String GENRE_CREDIT, String DATE, String PRIX,  int ID_CLIENT) {
        this.ID_CREDIT = ID_CREDIT;
        this.GENRE_CREDIT = GENRE_CREDIT;
        this.DATE = DATE;
        this.PRIX = PRIX;
      //  this.PRIX_TOTAL = PRIX_TOTAL;
        this.ID_CLIENT = ID_CLIENT;
    }

    public int getID_CREDIT() {
        return ID_CREDIT;
    }

    public void setID_CREDIT(int ID_CREDIT) {
        this.ID_CREDIT = ID_CREDIT;
    }

    public String getGENRE_CREDIT() {
        return GENRE_CREDIT;
    }

    public void setGENRE_CREDIT(String GENRE_CREDIT) {
        this.GENRE_CREDIT = GENRE_CREDIT;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getPRIX() {
        return PRIX;
    }

    public void setPRIX(String PRIX) {
        this.PRIX = PRIX;
    }





    public int getID_CLIENT() {
        return ID_CLIENT;
    }

    public void setID_CLIENT(int ID_CLIENT) {
        this.ID_CLIENT = ID_CLIENT;
    }
}
