package pages;

import core.actions.ElementActions;

public class BasePage {

    protected ElementActions actions;

    public BasePage() {
        this.actions = new ElementActions();
    }
}