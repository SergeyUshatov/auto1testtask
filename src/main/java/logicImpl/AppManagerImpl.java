package logicImpl;

import logic.*;
import utils.PropertyLoader;

public class AppManagerImpl implements AppManager {


    private WebDriverOperations webDriverOperations;
    private WebElementOperations webElementOperations;
    private FilterOperations filterOperations;
    private SortResultsOperations sortResultsOperations;
    private NavigationOperations navigationOperations;
    private SearchResultsOperations searchResultsOperations;

    public AppManagerImpl() {
        String value = PropertyLoader.loadProperty("log4j.config.file");
        System.setProperty("log4j.configurationFile", value);
    }

    @Override
    public WebDriverOperations getWebDriverOperations() {
        if (webDriverOperations == null) {
            webDriverOperations = new WebDriverOperationsImpl();
        }
        return webDriverOperations;
    }

    @Override
    public WebElementOperations getWebElementOperations() {
        if (webElementOperations == null) {
            webElementOperations = new WebElementOperationsImpl(this);
        }
        return webElementOperations;
    }

    @Override
    public FilterOperations getFilterOperations() {
        if (filterOperations == null) {
            filterOperations = new FilterOperationsImpl(this);
        }
        return filterOperations;
    }

    @Override
    public SortResultsOperations getSortResultsOperations() {
        if (sortResultsOperations == null) {
            sortResultsOperations = new SortResultsOperationsImpl(this);
        }
        return sortResultsOperations;
    }

    @Override
    public NavigationOperations getNavigationOperations() {
        if (navigationOperations == null) {
            navigationOperations = new NavigationOperationsImpl(this);
        }
        return navigationOperations;
    }

    @Override
    public SearchResultsOperations getSearchResultsOperations() {
        if (searchResultsOperations == null) {
            searchResultsOperations = new SearchResultsOperationsImpl(this);
        }
        return searchResultsOperations;
    }
}
