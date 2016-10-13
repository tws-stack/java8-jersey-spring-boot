package com.thoughtworks.gaia.common.constant;

public final class DefaultValues {
    private DefaultValues() {
    }

    public static final class System {
        public static String defaultEncoding() {
            return "UTF-8";
        }
    }

    public static final class Geo {
        public static int normalLocationStrip() {
            return 3;
        }
    }
}
