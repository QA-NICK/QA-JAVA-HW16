package ru.netology.domain;


import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Issue {
    private boolean opened;
    private String author;
    private Collection<Label> labels = new HashSet<>();
    private String assignee;
    private int id;

    public Issue() {
    }

    public Issue(boolean opened, String author, Collection<Label> labels, String assignee, int id) {
        this.opened = opened;
        this.author = author;
        this.labels = labels;
        this.assignee = assignee;
        this.id = id;
    }

    public void saveLabel (Label label) {labels.add (label);}

    public boolean matchesAuthor(String aut) {
        return author.contains(aut);

    }

    public Collection<Label> getLabels() {
        return labels;
    }

    public void setLabels(Collection<Label> labels) {
        this.labels = labels;
    }

    public boolean matchesLabel(String lab) {
        return labels.contains(lab);

    }

    public boolean matchesAssignee(String as) {
        return assignee.contains(as);

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

//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }


    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
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
        return isOpened() == issue.isOpened() && getId() == issue.getId() && Objects.equals(getAuthor(), issue.getAuthor()) && Objects.equals(getLabels(), issue.getLabels()) && Objects.equals(getAssignee(), issue.getAssignee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpened(), getAuthor(), getLabels(), getAssignee(), getId());
    }
}
