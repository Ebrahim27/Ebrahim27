package com.eki.ee.realbank.domin.bankTransaction;

public enum OptBoolean {
    /**
     * Value that indicates that the annotation property is explicitly defined to
     * be enabled, or true.
     */
    TRUE,

    /**
     * Value that indicates that the annotation property is explicitly defined to
     * be disabled, or false.
     */
    FALSE,

    /**
     * Value that indicates that the annotation property does NOT have an explicit
     * definition of enabled/disabled (or true/false); instead, a higher-level
     * configuration value is used; or lacking higher-level global setting,
     * default.
     */
    DEFAULT;

    public Boolean asBoolean() {
        if (this == DEFAULT) return null;
        return (this == TRUE) ? Boolean.TRUE : Boolean.FALSE;
    }

    public boolean asPrimitive() {
        return (this == TRUE);
    }

    public static OptBoolean fromBoolean(Boolean b) {
        if (b == null) {
            return DEFAULT;
        }
        return b.booleanValue() ? TRUE : FALSE;
    }

    public static boolean equals(Boolean b1, Boolean b2) {
        if (b1 == null) {
            return (b2 == null);
        }
        return b1.equals(b2);
    }
}

