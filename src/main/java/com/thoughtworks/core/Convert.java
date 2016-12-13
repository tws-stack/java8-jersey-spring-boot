package com.thoughtworks.core;

/**
 * Created by hliang on 14/12/2016.
 */
public class Convert {
    private Core core;

    public Convert(Core p0) {
        core = p0;
    }

    public String[] convertToNumberDescriptions(int i) {
        if (i == 1) {
            return new String[]{core.convertToNumberDescription(i)};
        }
        return new String[0];
    }
}
