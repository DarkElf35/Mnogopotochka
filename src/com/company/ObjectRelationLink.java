
package com.company;
import java.util.ArrayList;
import java.util.List;

public class ObjectRelationLink extends Thread {
    List<Comanda> teamsOnRelaytion = new ArrayList<>();
    int schetchik = 0;
    int ObjectRelationLength = 500;
    ArrayList<String> winteam = new ArrayList<>();

    ObjectRelationLink(String[] teamNames,String[][] teamRunners){         //заносим списки команд и бегунов
        for (String str : teamNames){
            Comanda team = new Comanda();
            team.name = str;
            for (int i=0; i<4; i++){
                team.runners.add(teamRunners[schetchik][i]);
            }
            teamsOnRelaytion.add(team);

            schetchik++;
        }
    }

    public void run(){
        try {
            for(Comanda team : teamsOnRelaytion){
                Begyn runner1 = new Begyn(team.runners.get(0),1,team);
                Begyn runner2 = new Begyn(team.runners.get(1),runner1,2,team,winteam);
                Begyn runner3 = new Begyn(team.runners.get(2),runner2,3,team,winteam);
                Begyn runner4 = new Begyn(team.runners.get(3),runner3,4,team,winteam);

                runner1.start();
                runner2.start();
                runner3.start();
                runner4.start();

            }
            sleep(500);
            System.out.println("Победила команда " + winteam.get(0));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
