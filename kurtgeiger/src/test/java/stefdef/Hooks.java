package stefdef;

import driver_helpers.DriverHelpers;

import java.net.MalformedURLException;

public class Hooks {
    private DriverHelpers driverHelpers = new DriverHelpers();

    @cucumber.api.java.Before
    public void setUp() throws MalformedURLException {
        driverHelpers.openBrowser();
        driverHelpers.maximiseBrowser();
        driverHelpers.navigateTo("https://www.kurtgeiger.es/");
        driverHelpers.applyImpWaits();
        driverHelpers.applyActions();
    }

     @cucumber.api.java.After
    public void tearDown() {
        driverHelpers.closeBrowser();
    }
}
