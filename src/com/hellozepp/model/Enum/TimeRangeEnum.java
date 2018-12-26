package com.hellozepp.model.Enum;

/**
 * @Author: zhanglin
 * @Date: 2018/12/25
 * @Time: 10:45 PM
 */
public enum TimeRangeEnum {
    YEAR("YEAR", "Äê"),
    MONTH("MONTH", "ÔÂ"),
    WEEK("WEEK", "ÖÜ");
    String name;
    String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    TimeRangeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static TimeRangeEnum get(String val) {

        if (val != null) {
            for (TimeRangeEnum exeCycle : TimeRangeEnum.values()) {
                if (val.equals(exeCycle.getValue())) {
                    return exeCycle;
                }
            }
        }
        return null;
    }

}
