package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import java.util.List;

public class GameMembers {
    int online;
    String nameOfGame;
    List<Gamer> gamers;

    public GameMembers(int online, String nameOfGame, List<Gamer> gamers) {
        this.online = online;
        this.nameOfGame = nameOfGame;
        this.gamers = gamers;
    }

    public static int getNumOnlineUsers(List<Gamer> listOfGamers) {
        int rsl = 0;
        for (Gamer gamer : listOfGamers) {
            if (gamer.isOnline()) {
                rsl++;
            }
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "GameMembers{"
                + "online=" + online
                + ", nameOfGame='" + nameOfGame + '\''
                + ", gamers=" + gamers
                + '}';
    }

    public static void main(String[] args) {
        Gamer gamer1 = new Gamer(16, "StrajGalaktiki", true);
        Gamer gamer2 = new Gamer(17, "Tanos", true);
        Gamer gamer3 = new Gamer(16, "ChelovekPauk", false);
        gamer1.addFriend(gamer2.getNickname());
        gamer1.addFriend(gamer3.getNickname());
        gamer2.addFriend(gamer1.getNickname());
        gamer3.addFriend(gamer1.getNickname());
        List<Gamer> gamers = new ArrayList<>();
        gamers.add(gamer1);
        gamers.add(gamer2);
        gamers.add(gamer3);
        GameMembers harryPotter = new GameMembers(getNumOnlineUsers(gamers), "Harry Potter 5", gamers);

        final Gson gson = new GsonBuilder().create();
        System.out.println("GameMembers convert to json: " + gson.toJson(harryPotter));

        final GameMembers gamerFromFile = gson.fromJson(gson.toJson(harryPotter), GameMembers.class);
        System.out.println("GameMembers convert from json: " + gamerFromFile);
    }
}
