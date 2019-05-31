package logicImpl;

import logic.AppManager;
import logic.SearchResultsOperations;
import model.CarSearchResult;

import java.util.List;

public class SearchResultsOperationsImpl extends DriverBasedOperations implements SearchResultsOperations {

    SearchResultsOperationsImpl(AppManager appManager) {
        super(appManager);
    }

    @Override
    public List<CarSearchResult> getCars() {
        return pages.searchPage.getListOfCars();
    }
}
