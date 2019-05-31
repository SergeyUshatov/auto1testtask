package logicImpl;

import logic.AppManager;
import pages.PageManager;

class DriverBasedOperations {
    PageManager pages;

    DriverBasedOperations(AppManager appManager) {
        pages = new PageManager(appManager);
    }

}
