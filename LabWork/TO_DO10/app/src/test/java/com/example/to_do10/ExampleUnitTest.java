package com.example.to_do10;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {

    private Calculator mCalculator;

    @Before
    public void setUp() { mCalculator = new Calculator(); }

    @Test
    public void addTwoNumbers() {
        double result = mCalculator.add( 1d, 2d);
        assertThat(result,is(equalTo(3d)));
    }

    @Test
    public void subTwoNumbers(){
        double result = mCalculator.sub(6d, 3d);
        assertThat(result,is(equalTo(3d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double result = mCalculator.sub(5d, 15d);
        assertThat(result,is(equalTo(-10d)));
    }

    @Test
    public void mulTwoNumbers(){
        double result = mCalculator.mul(2d, 5d);
        assertThat(result,is(equalTo( 10d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(2d, 0d);
        assertThat(result,is(equalTo( 0d)));
    }

    @Test
    public void divTwoNumbers(){
        double result = mCalculator.div(10d, 5d);
        assertThat(result,is(equalTo( 2d )));
    }

    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(0d, 10d);
        assertThat(result,is(equalTo(0d)));
    }
}