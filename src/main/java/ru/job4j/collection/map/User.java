package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User firstUser = new User("Valera", 2,
                new GregorianCalendar(1997, Calendar.AUGUST, 12));
        User secondUser = new User("Valera", 2,
                new GregorianCalendar(1997, Calendar.AUGUST, 12));
        HashMap<User, Object> map = new HashMap<User, Object>();
        map.put(firstUser, new Object());
        map.put(secondUser, new Object());
        for (HashMap.Entry<User, Object> user : map.entrySet()) {
            System.out.println("key: " + user.getKey());
            System.out.println("value: " + user.getValue());
        }
    }
}
