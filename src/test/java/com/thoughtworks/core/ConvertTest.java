package com.thoughtworks.core;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hliang on 13/12/2016.
 */
public class ConvertTest {
    @Test
    public void should_return_1_given_1 () {
        //given
        int number = 1;
        //when
        String actualValue = new Core().convertToNumberDescription(number);
        //then
        assertThat(actualValue).isEqualTo("1");
    }
    @Test
    public void should_return_Fizz_given_3 () {
        //given
        int number = 3;
        //when
        String actualValue = new Core().convertToNumberDescription(number);
        //then
        assertThat(actualValue).isEqualTo("Fizz");
    }
}
