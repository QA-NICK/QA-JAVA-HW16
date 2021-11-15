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
    IssueRepo repo = new IssueRepo();
    Issue issue =new Issue();




    Collection<Label> first = new HashSet<>();
    public void saveLabelFirst (Label label) {first.add (label);}

    Collection<Label> second =new HashSet<>();
    public void saveLabelSecond (Label label) {second.add (label);}

    Label labelFirst = new Label("test1");
    Label labelSecond = new Label("test2");
    Label labelThird = new Label("test3");
    Label labelForth = new Label("test4");



    Issue one = new Issue(true, "Petrov", first,"Ivanov", 1);

    Issue two = new Issue(false, "Petrov", second , "Ivanov", 2);
    Issue three = new Issue(true, "Belov", second, "Smirnov", 3);
    Issue four = new Issue(true, "Ivanov", first, "Smirnov", 4);

    @BeforeEach


    public void setUp() {
        saveLabelFirst(labelFirst);
        saveLabelFirst(labelThird);
        saveLabelFirst(labelSecond);
        saveLabelSecond(labelThird);
        saveLabelSecond(labelForth);
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
        Issue[] expected = new Issue[]{two};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindByAssignee() {

        Issue[] actual = manager.findByAssignee("Smirnov");
        Issue[] expected = new Issue[]{three, four};

        assertArrayEquals(expected, actual);


    }

}