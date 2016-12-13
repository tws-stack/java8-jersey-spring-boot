package com.thoughtworks.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hliang on 14/12/2016.
 */
public class ConvertTest {
    @Test
    public void should_return_array0_given_0 () {
        //given
        Core core = new Core();
        Convert convert = new Convert(core);
        //when
        String[] result = convert.convertToNumberDescriptions();
        //then
        assertThat(result).isEqualTo(new String[0]);
    }
}
