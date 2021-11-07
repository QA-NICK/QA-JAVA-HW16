package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepo;

import java.util.Collection;

public class IssueManager {
    private IssueRepo repo;

    public IssueManager(IssueRepo repo) {
        this.repo = repo;
    }


    public void add(Issue issue) {
        repo.saveIssue(issue);
    }

    public void addAll(Collection<Issue> items) {
        repo.saveAll(items);
    }


    public Issue[] findAllOpened() {
        Issue[] opened = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.isOpened()) {
                Issue[] tmp = new Issue[opened.length + 1];
                System.arraycopy(opened, 0, tmp, 0, opened.length);
                tmp[tmp.length - 1] = issue;
                opened = tmp;
            }

        }
        return opened;
    }

    public Issue[] findAllClosed() {
        Issue[] closed = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (!issue.isOpened()) {

                Issue[] tmp = new Issue[closed.length + 1];
                System.arraycopy(closed, 0, tmp, 0, closed.length);
                tmp[tmp.length - 1] = issue;
                closed = tmp;
            }

        }
        return closed;
    }

    public void issueUpdateToClose(int id) {
        Issue issue = repo.findById(id);
        if (issue.isOpened()) {
            issue.setOpened(false);
        }


    }

    public void issueUpdateToOpen(int id) {
        Issue issue = repo.findById(id);
        if (!issue.isOpened()) {
            issue.setOpened(true);
        }
    }

    public Issue[] findByAuthor(String author) {
        Issue[] authorResult = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.matchesAuthor(author)) {
                Issue[] tmp = new Issue[authorResult.length + 1];
                System.arraycopy(authorResult, 0, tmp, 0, authorResult.length);
                tmp[tmp.length - 1] = issue;
                authorResult = tmp;
            }
        }
        return authorResult;
    }

    public Issue[] findByLabel(String label) {
        Issue[] labelResult = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.matchesLabel(label)) {
                Issue[] tmp = new Issue[labelResult.length + 1];
                System.arraycopy(labelResult, 0, tmp, 0, labelResult.length);
                tmp[tmp.length - 1] = issue;
                labelResult = tmp;
            }
        }
        return labelResult;
    }

    public Issue[] findByAssignee(String label) {
        Issue[] assigneeResult = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.matchesAssignee(label)) {
                Issue[] tmp = new Issue[assigneeResult.length + 1];
                System.arraycopy(assigneeResult, 0, tmp, 0, assigneeResult.length);
                tmp[tmp.length - 1] = issue;
                assigneeResult = tmp;
            }
        }
        return assigneeResult;
    }

}




