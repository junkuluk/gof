package com.young.gof.prototype;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubRepository {

    private String user;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GitHubRepository that)) {
            return false;
        }
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getName());
    }
}
