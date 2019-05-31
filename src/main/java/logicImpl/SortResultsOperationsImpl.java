package logicImpl;

import logic.AppManager;
import logic.SortResultsOperations;

public class SortResultsOperationsImpl extends DriverBasedOperations implements SortResultsOperations {

    SortResultsOperationsImpl(AppManager appManager) {
        super(appManager);
    }

    @Override
    public void sortByPriceHighToLow() {
        pages.searchPage.sortByPriceDesc();
    }
}
