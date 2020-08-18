package com.sapient.week1;

// import junit.framework.Test;
// import junit.framework.TestCase;
// import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    private CheckEven app;
    
    @Before
    public void setup() {
        app = new CheckEven();
    }
    
    
    @Test
    public void testEvenNumber() {
        int number = 100;
        boolean result = app.check(number);
        assertTrue(result == true);
    }

    @Test
    public void testOddNumber() {
        int number = 101;
        boolean result = app.check(number);
        assertTrue(result == false);
    }

    @Test
    public void testZero() {
        int number = 0;
        boolean result = app.check(number);
        assertTrue(result == true);
    }

}


/**
 * Unit test for simple App.
 */
// public class AppTest 
//     extends TestCase
// {
//     /**
//      * Create the test case
//      *
//      * @param testName name of the test case
//      */
//     public AppTest( String testName )
//     {
//         super( testName );
//     }

//     /**
//      * @return the suite of tests being tested
//      */
//     public static Test suite()
//     {
//         return new TestSuite( AppTest.class );
//     }

//     /**
//      * Rigourous Test :-)
//      */
//     public void testApp()
//     {
//         assertTrue( true );
//     }
// }
