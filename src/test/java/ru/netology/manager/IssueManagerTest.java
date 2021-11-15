package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepo;


import java.awt.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueManager manager = new IssueManager(new IssueRepo());


    Set<String> first = new HashSet<>();
    Set<String> second = new HashSet<>();
    Set<String> assigneeFirst = new HashSet<>();
    Set<String> assigneeSecond = new HashSet<>();


    Issue one = new Issue(true, "Petrov", first, assigneeFirst, 1);

    Issue two = new Issue(false, "Petrov", second, assigneeFirst, 2);
    Issue three = new Issue(true, "Belov", second, assigneeSecond, 3);
    Issue four = new Issue(true, "Ivanov", first, assigneeSecond, 4);

    @BeforeEach


    public void setUp() {
        first.add("test1");
        first.add("test2");
        second.add("test3");
        second.add("test4");
        assigneeFirst.add("Smirnov");
        assigneeFirst.add("Ivanov");
        assigneeSecond.add("Vashov");


        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }


    @Test
    void findAllOpened() {


        Issue[] actual = manager.findAllOpened();
        Issue[] expected = new Issue[]{one, three, four};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllClosed() {
        Issue[] actual = manager.findAllClosed();
        Issue[] expected = new Issue[]{two};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUpdateToClosed() {
        manager.issueUpdateToClose(3);
        Issue[] actual = manager.findAllClosed();
        Issue[] expected = new Issue[]{two, three};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldUpdateToOpened() {
        manager.issueUpdateToOpen(2);
        Issue[] actual = manager.findAllOpened();
        Issue[] expected = new Issue[]{one, two, three, four};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindByAuthor() {

        Issue[] actual = manager.findByAuthor("Petrov");
        Issue[] expected = new Issue[]{one, two};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindByLabel() {


        Issue[] actual = manager.findByLabel("test1");
        Issue[] expected = new Issue[]{one, four};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindByAssignee() {

        Issue[] actual = manager.findByAssignee("Ivanov");
        Issue[] expected = new Issue[]{one, two};

        assertArrayEquals(expected, actual);


    }

}