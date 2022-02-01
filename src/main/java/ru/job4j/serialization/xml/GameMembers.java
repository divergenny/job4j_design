package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "game_members")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameMembers {
    @XmlAttribute
    int online;

    @XmlAttribute
    String nameOfGame;

    @XmlElementWrapper(name = "gamers")
    @XmlElement(name = "gamer")
    List<Gamer> gamers;

    public GameMembers() {

    }

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
}
