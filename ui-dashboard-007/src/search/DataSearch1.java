package search;

import com.raven.swing.*;

public class DataSearch1 {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }

    public DataSearch1(String text, boolean story) {
        this.text = text;
        this.story = story;
    }

    public DataSearch1() {
    }

    private String text;
    private boolean story;
}
