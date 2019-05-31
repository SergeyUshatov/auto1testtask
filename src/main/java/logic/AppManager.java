package logic;

public interface AppManager {
    WebDriverOperations getWebDriverOperations();
    WebElementOperations getWebElementOperations();
    FilterOperations getFilterOperations();
    SortResultsOperations getSortResultsOperations();
    NavigationOperations getNavigationOperations();
    SearchResultsOperations getSearchResultsOperations();
}
