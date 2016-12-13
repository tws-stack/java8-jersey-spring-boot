package com.thoughtworks.core;

/**
 * Created by hliang on 14/12/2016.
 */
public class Convert {
    private Core core;

    public Convert(Core p0) {
        core = p0;
    }

    public String[] convertToNumberDescriptions(int max) {
        String[] res = new String[max];
        for (int i = 0; i < max; i++) {
            res[i] = core.convertToNumberDescription(i+1);
        }
        return  res;
    }

    public static void main(String[] args) {
        Core core = new Core();
        Convert convert = new Convert(core);
        String[] numberDescriptions = convert.convertToNumberDescriptions(100);
        for (String numberDescription : numberDescriptions) {
            System.out.println(numberDescription);
        }
    }
}
