package com.hellozepp.model.Enum;

/**
 * @Author: zhanglin
 * @Date: 2018/12/25
 * @Time: 10:45 PM
 */
public enum UserTypeEnum {
    USER("USER", "店员"),
    ADMIN("ADMIN", "管理员");
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

    UserTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static UserTypeEnum get(String val) {

        if (val != null) {
            for (UserTypeEnum exeCycle : UserTypeEnum.values()) {
                if (val.equals(exeCycle.getValue())) {
                    return exeCycle;
                }
            }
        }
        return null;
    }

}
