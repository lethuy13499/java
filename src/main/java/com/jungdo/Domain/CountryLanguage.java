package com.jungdo.Domain;

public enum CountryLanguage {
    VIETNAM("VN", "vi"),
    UNITED_STATES("US", "en");

    private final String shortName;
    private final String shortLang;

    CountryLanguage(String shortName, String shortLang) {
        this.shortName = shortName;
        this.shortLang = shortLang;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getShortLang() {
        return this.shortLang;
    }
}
