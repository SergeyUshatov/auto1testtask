package logic;

import java.util.List;
import java.util.regex.Pattern;

public interface WebElementOperations {
    boolean click(String xpath);

    boolean selectValueByText(String locator, String value);

    List<String> getTextListFromElementsList(String locator);

    void waitUntilElementTextMatches(String locator, Pattern pattern);
}
