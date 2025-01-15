package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickListTest {
    @Test
    void whenSortThenOk() {
        User user1 = new User(1, "11");
        User user2 = new User(1, "22");
        User user3 = new User(3, "33");
        User user4 = new User(-4, "44");
        User user5 = new User(4, "55");
        User user6 = new User(6, "66");
        Comparator<User> comparator = Comparator.comparingInt(User::getId);
        List<User> listUser = new ArrayList<>();
        listUser.add(user3);
        listUser.add(user5);
        listUser.add(user1);
        listUser.add(user4);
        listUser.add(user6);
        listUser.add(user2);
        QuickList.quickSort(listUser, comparator);
        List<Integer> result = listUser.stream().map(User::getId).toList();
        assertThat(result).containsExactly(-4, 1, 1, 3, 4, 6);
    }

    @Test
    void whenReverseOrderThenOk() {
        Comparator<Integer> comparator = (a, b) -> b - a;
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-8);
        list.add(1);
        list.add(0);
        list.add(10);
        list.add(1);
        list.add(8);
        QuickList.quickSort(list, comparator);
        assertThat(list).containsExactly(10, 8, 1, 1, 0, -2, -8);
    }

    @Test
    void whenEmptyListThenOk() {
        List<Integer> list = new ArrayList<>();
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).isEmpty();
    }

    @Test
    void whenSingleElementThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(42);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(42);
    }

    @Test
    void whenDuplicatesThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(1, 2, 3, 3, 5, 5);
    }

    @Test
    void whenNegativeNumbersThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(-10);
        list.add(-1);
        list.add(-5);
        list.add(-3);
        list.add(-7);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(-10, -7, -5, -3, -1);
    }

    @Test
    void whenReversedListThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        QuickList.quickSort(list, Comparator.naturalOrder());
        assertThat(list).containsExactly(6, 7, 8, 9, 10);
    }

    @Test
    void whenSortByNameThenOk() {
        User user1 = new User(1, "Charlie");
        User user2 = new User(2, "Alice");
        User user3 = new User(3, "Bob");
        Comparator<User> comparator = Comparator.comparing(user -> user.name);
        List<User> listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        QuickList.quickSort(listUser, comparator);
        List<String> result = listUser.stream().map(user -> user.name).toList();
        assertThat(result).containsExactly("Alice", "Bob", "Charlie");
    }

    @Test
    void whenLargeListThenOk() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1000; i >= 1; i--) {
            list.add(i);
        }
        QuickList.quickSort(list, Comparator.naturalOrder());
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            expected.add(i);
        }
        assertThat(list).isEqualTo(expected);
    }

    private static class User {
        private Integer id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
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
            return Objects.equals(id, user.id) && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{"
                    + "id=" + id
                    + ", name='" + name + '\''
                    + '}';
        }
    }
}
