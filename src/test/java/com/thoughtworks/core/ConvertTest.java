package com.thoughtworks.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        String[] result = convert.convertToNumberDescriptions(0);
        //then
        assertThat(result).isEqualTo(new String[0]);
    }
    @Test
    public void should_return_array1_given_1 () {
        //given
        Core core = mock(Core.class);
        Convert convert = new Convert(core);
        when(core.convertToNumberDescription(1)).thenReturn("1");
        //when
        String[] result = convert.convertToNumberDescriptions(1);
        //then
        assertThat(result).isEqualTo(new String[]{"1"});
    }
    @Test
    public void should_return_array3_given_3 () {
        //given
        Core core = mock(Core.class);
        Convert convert = new Convert(core);
        when(core.convertToNumberDescription(1)).thenReturn("1");
        when(core.convertToNumberDescription(2)).thenReturn("2");
        when(core.convertToNumberDescription(3)).thenReturn("Fizz");
        //when
        String[] result = convert.convertToNumberDescriptions(3);
        //then
        assertThat(result).isEqualTo(new String[]{"1","2","Fizz"});
    }
}
