package io.mart.util;

import cucumber.api.Transformer;

public class PossibleValuesConverter extends Transformer<String> {

    @Override
    public String transform(String value) {
        if (value.equals("NULL")) return null;
        if (value.equals("EMPTY")) return "";
        return value;
    }
}
