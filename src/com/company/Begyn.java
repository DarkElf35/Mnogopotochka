package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Begyn extends Thread {
    String name;
    Begyn drygojbegyn;
    int number;
    int count = 0;
    String teamName;
    ArrayList<String> winteam;

    Begyn(String name,Begyn drygojbegyn,int number, Comanda team,ArrayList<String> winner){
        this.name = name;
        this.number = number;
        this.drygojbegyn = drygojbegyn;
        this.teamName = team.name;
        this.winteam = team.winteam;
        this.winteam = winner;
    }
    Begyn(String name,int number, Comanda team){
        this.name = name;
        this.number = number;
        this.drygojbegyn = null;
        this.teamName = team.name;
        this.winteam = null;
    }
    public void run(){
        try {
            if(drygojbegyn != null) {
                System.out.println(name + " ждёт " + drygojbegyn.name);
                drygojbegyn.join();
            }
            System.out.println(name + " принимает эстафету от " + drygojbegyn.name + " и  стартует ");
            while (count < 50) {
                ++count;
                System.out.println(name + " бежит " + count + " метров");
                Thread.yield();
                if(number == 4 && count == 50){
                    winteam.add(teamName);
                }
                if (count == 50 && number != 4){
                    System.out.println("Передача эстафеты");
                }
            }
            sleep( (long) (Math.random() * 250) );

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}