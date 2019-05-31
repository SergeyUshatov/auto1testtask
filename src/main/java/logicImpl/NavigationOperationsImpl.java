package logicImpl;

import logic.AppManager;
import logic.NavigationOperations;
import utils.PropertyLoader;

public class NavigationOperationsImpl implements NavigationOperations {
    private static final String SEARCH_PAGE = "de/search";

    private AppManager appManager;

    NavigationOperationsImpl(AppManager appManager) {
        this.appManager = appManager;
    }

    @Override
    public void openSearchPage() {
        appManager.getWebDriverOperations().goTo(SEARCH_PAGE);
    }
}
