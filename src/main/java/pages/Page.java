package pages;

import logic.AppManager;
import logic.WebElementOperations;

abstract class Page {
    WebElementOperations webElementOperations;

    Page(AppManager appManager) {
        this.webElementOperations = appManager.getWebElementOperations();
    }
}
