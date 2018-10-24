package ba.unsa.etf.rpr.tutorijal02;

import static java.lang.Double.compare;
import static java.lang.Boolean.compare;

public class Interval {
    private double prvaTacka;
    private double drugaTacka;
    private boolean prvaPripada;
    private boolean drugaPripada;


    public Interval (double prvaT,double drugaT,boolean prvaP, boolean drugaP) throws IllegalArgumentException {
        if(prvaT>drugaT)
        {
            throw  new IllegalArgumentException("Prva veca od druge tacke!");
        }
        this.prvaTacka=prvaT; this.drugaTacka=drugaT; this.prvaPripada=prvaP; this.drugaPripada=drugaP;
    }

    public Interval (){
        this.prvaTacka=0; this.drugaTacka=0; this.prvaPripada=false; this.drugaPripada=false;
    }

    public boolean isNull(){
        if(this.prvaTacka==0 && this.drugaTacka==0 && !this.prvaPripada && this.drugaPripada==false )
            return true;
        else {
            return false;
        }
    }

    public boolean isIn(double tacka){
      if(this.prvaTacka< tacka && this.drugaTacka > tacka){
          return true;
      }
      else if( this.prvaTacka==tacka && this.prvaPripada){
          return true;
      }
      else if(this.drugaTacka==tacka && this.drugaPripada){
          return true;
      }
      return false;
    }

    public Interval intersect(Interval i){
        double prva=0,druga=0;
        boolean prvaP=false,drugaP=false;
        if(this.prvaTacka>i.prvaTacka){              //pocetak ispitivanje prve tacke
            prva=this.prvaTacka;
            prvaP=this.prvaPripada;
        }
        else if(this.prvaTacka<i.prvaTacka){
            prva=i.prvaTacka;
            prvaP=i.prvaPripada;
        }
        else if(this.prvaTacka==i.prvaTacka){
            prva=this.prvaTacka;
            if(this.prvaPripada && i.prvaPripada){
                prvaP=true;
            }else {
                prvaP=false;
            }
        }                                             // kraj ispitivanje prve tacke

        if(this.drugaTacka<i.drugaTacka){              //pocetak ispitivanje druge tacke
            druga=this.drugaTacka;
            drugaP=this.drugaPripada;
        }
        else if(this.drugaTacka>i.drugaTacka){
            druga=i.drugaTacka;
            drugaP=i.drugaPripada;
        }
        else if(this.drugaTacka==i.drugaTacka){
            druga=this.drugaTacka;
            if(this.drugaPripada && i.drugaPripada){
                drugaP=true;
            }else {
                drugaP=false;
            }
        }                                             // kraj ispitivanje druge tacke

        return new Interval(prva,druga,prvaP,drugaP);
    }


    public static Interval intersect(Interval prvi, Interval drugi){
        double prva=0,druga=0;
        boolean prvaP=false,drugaP=false;
        if(prvi.prvaTacka>drugi.prvaTacka){              //pocetak ispitivanje prve tacke
            prva=prvi.prvaTacka;
            prvaP=prvi.prvaPripada;
        }
        else if(prvi.prvaTacka<drugi.prvaTacka){
            prva=drugi.prvaTacka;
            prvaP=drugi.prvaPripada;
        }
        else if(prvi.prvaTacka==drugi.prvaTacka){
            prva=prvi.prvaTacka;
            if(prvi.prvaPripada && drugi.prvaPripada){
                prvaP=true;
            }else {
                prvaP=false;
            }
        }                                             // kraj ispitivanje prve tacke

        if(prvi.drugaTacka<drugi.drugaTacka){              //pocetak ispitivanje druge tacke
            druga=prvi.drugaTacka;
            drugaP=prvi.drugaPripada;
        }
        else if(prvi.drugaTacka>drugi.drugaTacka){
            druga=drugi.drugaTacka;
            drugaP=drugi.drugaPripada;
        }
        else if(prvi.drugaTacka==drugi.drugaTacka){
            druga=prvi.drugaTacka;
            if(prvi.drugaPripada && drugi.drugaPripada){
                drugaP=true;
            }else {
                drugaP=false;
            }
        }                                             // kraj ispitivanje druge tacke

        return new Interval(prva,druga,prvaP,drugaP);
    }

    public String toString(){
        String s="";
        if(this.isNull()){
            return new String ("()");
        }

        if(this.prvaPripada){
            s+="[";
        }
        else{
            s+="(";
        }
        s+=this.prvaTacka+","+this.drugaTacka;
        if(this.drugaPripada){
            s+="]";
        }
        else{
            s+=")";
        }
        return s;
    }

    public boolean equals(Interval i){
        if((compare(this.prvaTacka, i.prvaTacka) == 0) && compare(this.prvaPripada,i.prvaPripada)==0 && compare(this.drugaTacka,i.drugaTacka)==0 && compare(this.drugaPripada,i.drugaPripada)==0){
            return true;
        }

        /*
        if(this.prvaTacka==i.prvaTacka && this.prvaPripada==i.prvaPripada && this.drugaTacka==i.drugaTacka && this.drugaPripada==i.drugaPripada){
            return true;
        }

        */

        return false;
    }

    public double getPrvaTacka() {
        return prvaTacka;
    }

    public void setPrvaTacka(double prvaTacka) {
        this.prvaTacka = prvaTacka;
    }

    public double getDrugaTacka() {
        return drugaTacka;
    }

    public void setDrugaTacka(double drugaTacka) {
        this.drugaTacka = drugaTacka;
    }

    public boolean isPrvaPripada() {
        return prvaPripada;
    }

    public void setPrvaPripada(boolean prvaPripada) {
        this.prvaPripada = prvaPripada;
    }

    public boolean isDrugaPripada() {
        return drugaPripada;
    }

    public void setDrugaPripada(boolean drugaPripada) {
        this.drugaPripada = drugaPripada;
    }
}
