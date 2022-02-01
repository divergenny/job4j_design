package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Here is an example that show how to Convert XML to POJO(Plain Old Java Object)
     * using JAXBContext, here is Getting the context for accessing the API.
     * Marshaller is a serializer, using function setProperty, it is indicated that we need formatting.
     * So, I Serialize.
     * And after that, to deserialize, we need to create a deserializer, so creating a deserializer and deserializing.
     *
     * @param args arguments
     * @throws Exception Any Exception
     */
    public static void main(String[] args) throws Exception {
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
        GameMembers harryPotter = new GameMembers(GameMembers.getNumOnlineUsers(gamers), "Harry Potter 5", gamers);

        JAXBContext context = JAXBContext.newInstance(GameMembers.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(harryPotter, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            GameMembers result = (GameMembers) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
