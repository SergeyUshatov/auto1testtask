package ui_tests;

import logic.AppManager;
import logicImpl.AppManagerImpl;
import model.CarSearchResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchCarTests {
    private AppManager app;

    @BeforeSuite
    public void init() {
        if (app == null){
            app = new AppManagerImpl();
        }
    }

    @BeforeTest
    public void loadUrl() {
        app.getNavigationOperations().openSearchPage();
    }

    @AfterClass
    public void close(){
        app.getWebDriverOperations().stop();
    }

    @Test
    public void filterCarsFrom2015AndSortByPriceDesc() {
        int year = 2015;
        app.getFilterOperations().filterByYearFrom(year);
        app.getSortResultsOperations().sortByPriceHighToLow();
        List<CarSearchResult> cars =  app.getSearchResultsOperations().getCars();

        List<Integer> carPricesActual = cars.stream().map(CarSearchResult::getPrice).collect(Collectors.toList());
        List<Integer> carsByPriceDesc = cars.stream().map(CarSearchResult::getPrice).sorted((x, y) -> Integer.compare(y, x)).collect(Collectors.toList());
        List<Integer> carYearsActual = cars.stream().map(CarSearchResult::getYear).collect(Collectors.toList());

        assertThat(carPricesActual, equalTo(carsByPriceDesc));
        assertThat(carYearsActual, everyItem(greaterThanOrEqualTo(year)));
    }
}
