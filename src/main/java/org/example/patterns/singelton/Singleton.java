package org.example.patterns.singelton;

public class Singleton {
    private static Singleton instance;

    public String getValue() {
        return value;
    }

    private final String value;

    private Singleton(String value)
    {
        this.value = value;
    }

    public static Singleton getInstance(String value)
    {
        if (instance == null)
        {
            instance = new Singleton(value);
        }

        return instance;
    }




}
