package pt.fjrcorreia.playground.rest.wildfly;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Francisco Correia
 */

public class SampleTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testSum() {
        Sample sample = new Sample();
        assertEquals(5, sample.sum(3, 2));
    }


}
