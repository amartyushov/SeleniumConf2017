package io.mart.util;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

@Data
public class KeyValueHolder {
    String key;

    @XStreamConverter(PossibleValuesConverter.class)
    String value;
}