import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class testScania {

    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testTrailerUp(){
        scania.trailerUp(0);
        assertTrue(scania.getTrailerAngle() == 0);
        scania.trailerUp(30);
        assertTrue(scania.getTrailerAngle() == 30);
        scania.trailerUp(100);
        assertTrue(scania.getTrailerAngle() == 70);

    }

    @Test
    public void testScaniaMove(){
        scania.move();
        scania.trailerUp(30);
        assertTrue(scania.getTrailerAngle() == 0);
    }

}

