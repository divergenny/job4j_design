package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int sizePrevious = previous.size();
        int sizeCurrent = current.size();
        int add = 0;
        int changed = 0;
        int del = 0;
        Map<Integer, String> currentMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (currentMap.containsKey(user.getId())) {
                if (!currentMap.get(user.getId()).equals(user.getName())) {
                    changed++;
                }
            } else {
                del++;
            }
        }
        add = sizeCurrent + del - sizePrevious;
        return new Info(add, changed, del);
    }
}
