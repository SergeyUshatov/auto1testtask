package logicImpl;

import logic.AppManager;
import logic.FilterOperations;

public class FilterOperationsImpl extends DriverBasedOperations implements FilterOperations {

    FilterOperationsImpl(AppManager appManager) {
        super(appManager);
    }

    @Override
    public void filterByYearFrom(int year) {
        pages.searchPage.filterByYear(year);
    }
}
