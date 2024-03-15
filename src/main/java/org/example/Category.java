package org.example;

import java.util.Set;

public class Category {

    private String title = "";

    private Set<String> tags;

    public Category(String title, Set<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }
}
