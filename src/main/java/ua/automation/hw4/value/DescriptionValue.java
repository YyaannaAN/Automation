package ua.automation.hw4.value;

public class DescriptionValue extends BaseValue {
    public DescriptionValue(String listXpath, String detailsXpath, String message) {
        super(listXpath, detailsXpath, message);
    }

    @Override
    protected String formatValue(String text) {
        return text.split("•")[0].trim();
    }
}