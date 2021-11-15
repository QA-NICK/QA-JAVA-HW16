package ru.netology.domain;


import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Issue {
    private boolean opened;
    private String author;
    private Set<String> labels = new HashSet<>();
    private Set<String> assignees = new HashSet<>();
    private int id;

    public Issue() {
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Issue(boolean opened, String author, Set<String> labels, Set<String> assignees, int id) {
        this.opened = opened;
        this.author = author;
        this.labels = labels;
        this.assignees = assignees;
        this.id = id;
    }

    public boolean matchesAuthor(String aut) {
        return author.contains(aut);

    }


    public boolean matchesLabel(String lab) {
        return labels.contains(lab);

    }

    public boolean matchesAssignee(String as) {
        return assignees.contains(as);

    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Set<String> getLabels() {
        return labels;
    }

    public Set<String> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<String> assignees) {
        this.assignees = assignees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return isOpened() == issue.isOpened() && getId() == issue.getId() && Objects.equals(getAuthor(), issue.getAuthor()) && Objects.equals(getLabels(), issue.getLabels()) && Objects.equals(getAssignees(), issue.getAssignees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpened(), getAuthor(), getLabels(), getAssignees(), getId());
    }
}

