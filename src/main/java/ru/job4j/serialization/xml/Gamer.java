package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "gamer")
public class Gamer {

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String nickname;

    @XmlAttribute
    private boolean online;

    @XmlElementWrapper(name = "friends")
    @XmlElement(name = "friend")
    private String[] friends = new String[10];

    @XmlAttribute
    private int friendsItr = 0;

    public Gamer() {

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

    public void addFriend(String friend) {
        if (friendsItr > 9) {
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
