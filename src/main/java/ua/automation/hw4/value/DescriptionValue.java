package ua.automation.hw4.value;

import ua.automation.experiment1.BaseListToDetailsInfo;

public class DescriptionValue extends BaseListToDetailsInfo {
    public DescriptionValue(String listXpath, String detailsXpath, String message) {
        super(listXpath, detailsXpath, message);
    }

    @Override
    protected String formatValue(String text) {
        return text.split("•")[0].trim();
    }
}