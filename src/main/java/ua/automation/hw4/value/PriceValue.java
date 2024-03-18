package ua.automation.hw4.value;

public class PriceValue extends BaseValue {
    public PriceValue(String listXpath, String detailsXpath, String message) {
        super(listXpath, detailsXpath, message);
    }

    @Override
    protected String formatValue(String text) {
        return text.replaceAll("[A-Z]*", "").trim();
    }
}
