package com.company;


public class Main {

    public static void main(String[] args) {
        String[] teamNames = {"Динамо", "ЦСКА"};
        String[][] runnerNames = {{"Петр", "Василий", "Иван", "Глафира"}, {"Юрий", "Оксана", "Александр", "Анна"}};
        ObjectRelationLink relay = new ObjectRelationLink(teamNames, runnerNames);
        relay.run();
    }

}