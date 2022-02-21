package com.eki.ee.realbank.utils;

public enum YesNo {

    NONE(0),
    YES(1),
    NO(2),
    BOTH(3);

    private final Integer value;

    /**
     * @param value
     */
    YesNo(Integer value) {
        this.value = value;
    }

    /**
     * @param value
     * @return
     */
    public static YesNo fromValue(Integer value) {

        if (value == null) {
            return YesNo.NONE;
        }

        if (value == 1) {
            return YesNo.YES;
        } else if (value == 2){
            return YesNo.NO;
        }else if (value == 3){
            return YesNo.BOTH;
        }
        return YesNo.NONE;
    }

    /**
     * @return
     */
    public Integer toValue() {
        return value;
    }

    public static YesNo fromType(String type) {
        if (type.equals(YES.name())) {
            return YES;
        } else if (type.equals(NO.name())) {
            return NO;
        } else if (type.equals(BOTH.name())) {
            return BOTH;
        }
        else {
            return NONE;
        }
    }

    public static YesNo fromType(Boolean type) {
        if (type.equals(true)) {
            return YES;
        } else if (type.equals(false)) {
            return NO;
        }
        else {
            return NONE;
        }
    }

    public Boolean toBoolean() {
        switch (value) {
            case 1:
                return true;
            case 2:
                return false;
        }
        return false;
    }

}
