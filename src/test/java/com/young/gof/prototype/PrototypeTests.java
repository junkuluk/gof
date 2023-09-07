package com.young.gof.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrototypeTests {

    @Test
    void prototype_test() throws CloneNotSupportedException {
        GitHubRepository gitHubRepository = new GitHubRepository();
        gitHubRepository.setUser("youngjun");
        gitHubRepository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(gitHubRepository);
        githubIssue.setId(1);
        githubIssue.setTitle("what is jvm?");
        String url = githubIssue.getUrl();

        GithubIssue clone = githubIssue.clone();

        //TODO clone != githubIssue
        //TODO clone.equals(githubIssue) == true
        //TODO clone in Object is shallow copy
        assertNotSame(githubIssue, clone);
        assertSame(githubIssue.getClass(), clone.getClass());
        assertEquals(githubIssue, clone);
        assertSame(githubIssue.getRepository(),clone.getRepository());

        GithubIssue githubIssueDeepCopy = githubIssue.customClone();
        assertNotSame(githubIssue, githubIssueDeepCopy);
        assertSame(githubIssue.getClass(), githubIssueDeepCopy.getClass());
        assertEquals(githubIssue, githubIssueDeepCopy);
        assertNotSame(githubIssue.getRepository(),githubIssueDeepCopy.getRepository());
        assertEquals(githubIssue.getRepository(),githubIssueDeepCopy.getRepository());


    }
}
