package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepo;


import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueManager manager = new IssueManager(new IssueRepo());
    IssueRepo repo = new IssueRepo();


    Issue one = new Issue(true, "Petrov", "test1", "Ivanov", 1);
    Issue two = new Issue(false, "Petrov", "test2", "Ivanov", 2);
    Issue three = new Issue(true, "Belov", "test1", "Smirnov", 3);
    Issue four = new Issue(true, "Ivanov", "test1", "Smirnov", 4);

    @BeforeEach


    public void setUp() {

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

        Issue[] actual = manager.findByLabel("test2");
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