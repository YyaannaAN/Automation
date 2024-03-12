package ua.automation.hw4.value;

import ua.automation.experiment1.BaseListToDetailsInfo;

public class PriceValue extends BaseListToDetailsInfo {
    public PriceValue(String listXpath, String detailsXpath, String message) {
        super(listXpath, detailsXpath, message);
    }

    @Override
    protected String formatValue(String text) {
        return text.replaceAll("[A-Z]*", "").trim();
    }
}
