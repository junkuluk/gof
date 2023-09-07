package com.young.gof.prototype;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubIssue implements Cloneable {

    private int id;

    private String title;
    private final GitHubRepository repository;

    public GithubIssue(GitHubRepository gitHubRepository) {
        this.repository = gitHubRepository;
    }

    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                this.getId());
    }

    @Override
    public GithubIssue clone() throws CloneNotSupportedException {
        return (GithubIssue) super.clone();
    }

    public GithubIssue customClone() {
        GitHubRepository gitHubRepository = new GitHubRepository();
        gitHubRepository.setUser(this.getRepository().getUser());
        gitHubRepository.setName(this.getRepository().getName());

        GithubIssue githubIssue = new GithubIssue(gitHubRepository);
        githubIssue.setId(this.getId());
        githubIssue.setTitle(this.getTitle());
        return githubIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GithubIssue that)) {
            return false;
        }
        return getId() == that.getId() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(
                getRepository(), that.getRepository());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getRepository());
    }
}
