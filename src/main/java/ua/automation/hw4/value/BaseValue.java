package ua.automation.hw4.value;


public class BaseValue {

    protected String listXpath;
    protected String detailsXpath;
    protected String message;
    protected String listValue;
    protected String detailsValue;

    public BaseValue(String listXpath, String detailsXpath, String message) {
        setListXpath(listXpath);
        setDetailsXpath(detailsXpath);
        setMessage(message);
    }

    public String getListXpath() {
        return listXpath;
    }

    public void setListXpath(String listXpath) {
        this.listXpath = listXpath;
    }

    public String getDetailsXpath() {
        return detailsXpath;
    }

    public void setDetailsXpath(String detailsXpath) {
        this.detailsXpath = detailsXpath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getListValue() {
        return formatValue(listValue);
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public String getDetailsValue() {
        return formatValue(detailsValue);
    }

    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }

    protected String formatValue(String text) {
        return text;
    }
}
