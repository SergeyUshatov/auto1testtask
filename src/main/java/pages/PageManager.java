package pages;

import logic.AppManager;

public class PageManager {
    public SearchPage searchPage;

    public PageManager(AppManager appManager) {
        searchPage = new SearchPage(appManager);
    }
}

