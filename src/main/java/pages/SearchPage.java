package pages;

import logic.AppManager;
import model.CarSearchResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchPage extends Page {
    private static final Logger log = LogManager.getLogger(SearchPage.class);

    private static final String PRICES_HIGH_TO_LOW = "Höchster Preis";

    private static final String XPATH_SEARCH_RESULTS = "//*[@data-qa-selector='ad']";
    private static final String XPATH_SELECTOR_RESULTS_AMOUNT = "//*[@data-qa-selector='results-amount']";
    private static final String XPATH_YEAR_RANGE_MIN = "//select[@name='yearRange.min']";
    private static final String XPATH_FILTER_BY_YEAR_COMPONENT = ".//*[@data-qa-selector='filter-year']";
    private static final String XPATH_SELECT_SORT_RESULTS = "//select[@name='sort']";

    public SearchPage(AppManager appManager) {
        super(appManager);
    }

    private void waitUntilResultsReloaded() {
        Pattern pattern = Pattern.compile("^.*Treffer$");
        webElementOperations.waitUntilElementTextMatches(XPATH_SELECTOR_RESULTS_AMOUNT, pattern);
    }

    private void expandFilterByYear() {
        log.info("Expanding the filter by year");
        webElementOperations.click(XPATH_FILTER_BY_YEAR_COMPONENT);
    }

    public void filterByYear(int year) {
        log.info("Filtering by year");
        expandFilterByYear();
        webElementOperations.selectValueByText(XPATH_YEAR_RANGE_MIN, "" + year);
    }

    public void sortByPriceDesc() {
        log.info("Sorting results by price descending");
        webElementOperations.selectValueByText(XPATH_SELECT_SORT_RESULTS, PRICES_HIGH_TO_LOW);
    }

    public List<CarSearchResult> getListOfCars() {
        waitUntilResultsReloaded();
        List<String> carsShortInfoList = webElementOperations.getTextListFromElementsList(XPATH_SEARCH_RESULTS);
        List<CarSearchResult> cars = new ArrayList<>(carsShortInfoList.size());

        for (String carInfoText : carsShortInfoList) {
            String[] carInfo = carInfoText.split("\n");
            int price = Integer.parseInt(carInfo[carInfo.length - 2].replace(".","").split(" ")[0]);
            int year = Integer.parseInt(carInfo[4].split("/")[1]);
            CarSearchResult car = new CarSearchResult()
                    .setTitle(carInfo[0])
                    .setPrice(price)
                    .setYear(year);

            cars.add(car);
        }

        return cars;
    }


}
