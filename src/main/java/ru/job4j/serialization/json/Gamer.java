package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

import java.util.Arrays;

public class Gamer {
    private int age;
    private String nickname;
    private boolean online;
    private String[] friends = new String[10];
    private int friendsItr = 0;
    private GameMembers currentGame;

    @JSONPropertyIgnore
    public GameMembers getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(GameMembers currentGame) {
        this.currentGame = currentGame;
    }

    public Gamer(int age, String nickname, boolean online) {
        this.age = age;
        this.nickname = nickname;
        this.online = online;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isOnline() {
        return online;
    }

    public int getAge() {
        return age;
    }

    public String[] getFriends() {
        return friends;
    }

    public int getFriendsItr() {
        return friendsItr;
    }

    public void addFriend(String friend) {
        if (friendsItr > 4) {
            System.out.println("You reached maximum of friends.");
        } else {
            friends[friendsItr] = friend;
            friendsItr++;
        }
    }

    @Override
    public String toString() {
        return "Gamer{"
                + "age=" + age
                + ", nickname='" + nickname + '\''
                + ", friends=" + Arrays.toString(friends)
                + ", friendsItr=" + friendsItr
                + '}';
    }
}
