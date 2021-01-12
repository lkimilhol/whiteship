package com.company.githubApi;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GithubConnector {
    public void calculateParticipation() throws IOException {
        GitHub github = new GitHubBuilder().withPassword("lkimilhol", "xxx").build();
        GHRepository ghRepository = github.getRepository("lkimilhol/whiteship");
        List<GHIssue> issueList = ghRepository.getIssues(GHIssueState.ALL);

        Map<String, Integer> userCount = new HashMap<>();

        for (GHIssue issue : issueList) {
            List<GHIssueComment> comments = issue.getComments();
            for (GHIssueComment comment : comments) {
                GHUser user = comment.getUser();
                String name = user.getName();

                if (userCount.containsKey(name)) {
                    int cnt = userCount.get(name);
                    userCount.put(name, ++cnt);
                } else {
                    userCount.put(name, 1);
                }
            }
        }

        if (issueList.size() > 0) {
            userCount.forEach((k, v) -> {
                double rate = Math.round(((double) v / issueList.size()) * 100) / 100.0;
                System.out.println("name: " + k + " " + "participation rate: " + rate * 100);
            });
        }
    }
}
