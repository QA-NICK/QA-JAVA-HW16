package ru.netology.repository;

import ru.netology.domain.Issue;


import java.util.ArrayList;
import java.util.Collection;


public class IssueRepo {
    private Collection<Issue> items = new ArrayList<>();

    public void saveIssue(Issue item) {
        items.add(item);
    }

    public void saveAll(Collection<Issue> items) {
        this.items.addAll(items);
    }

    public Collection<Issue> findAll() {
        return items;
    }

    public Issue findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}


