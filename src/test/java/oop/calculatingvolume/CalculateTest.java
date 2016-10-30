package oop.calculatingvolume;

import org.junit.Test;
import test.BaseTest;

import java.io.InputStream;
import java.util.Scanner;

public class CalculateTest extends BaseTest {


    @Test(expected = NumberFormatException.class)
    public void whenIntegerIsEqualOrBelowZero_thenNumberFormat() {
        Calculate cut = new Calculate(getScannerFor("negativeInt"));
        cut.get_int_val();
        cut.get_int_val();
        cut.get_int_val();
    }

    @Test(expected = NumberFormatException.class)
    public void whenDoubleIsZero_thenNumberFormat() {
        Calculate cut = new Calculate(getScannerFor("negativeDouble"));
        cut.get_double_val();
        cut.get_double_val();
        cut.get_double_val();
    }

    @Test
    public void whenRoundResult_1_2345_thenResultIs_1_235() throws Exception {
        Calculate cut = new Calculate();
        double val = cut.round(1.2345);
        assertEquals(1.235, val, 0);
    }

    @Test
    public void whenRoundResult_3_12995_thenResultIs_3_130() throws Exception {
        Calculate cut = new Calculate();
        double val = cut.round(3.12995);
        assertEquals(3.130, val, 0);
    }

    @Test
    public void whenCubeOf4_thenValueIs64() {
        Calculate cut = new Calculate(getScannerFor("cube_4"));
        int numberOfTests = cut.get_int_val();
        int testType = cut.get_int_val();
        int a = cut.get_int_val();

        double volume = Calculate.do_calc().get_volume(a);

        assertEquals(1, numberOfTests);
        assertEquals(1, testType);
        assertEquals(4, a);
        assertEquals(64.000, cut.round(volume), 0);
    }

    @Test
    public void whenCuboidOf1_2_3_thenValueIs6() {
        Calculate cut = new Calculate(getScannerFor("cuboid_1_2_3"));
        int numberOfTests = cut.get_int_val();
        int testType = cut.get_int_val();
        int l = cut.get_int_val();
        int b = cut.get_int_val();
        int h = cut.get_int_val();

        double volume = cut.do_calc().get_volume(l, b, h);
        cut.output.display(volume);

        assertEquals(1, numberOfTests);
        assertEquals(2, testType);
        assertEquals(1, l);
        assertEquals(2, b);
        assertEquals(3, h);
        assertEquals(6.000, cut.round(volume), 0);
    }

    @Test
    public void whenHemisphereOf2_2345_thenValueIs23_3668() {
        Calculate cut = new Calculate(getScannerFor("hemisphere_2_2345"));
        int numberOfTests = cut.get_int_val();
        int testType = cut.get_int_val();
        double r = cut.get_double_val();

        double volume = Calculate.do_calc().get_volume(r);

        assertEquals(1, numberOfTests);
        assertEquals(3, testType);
        assertEquals(2.2345, r, 0);
        assertEquals(23.367, cut.round(volume), 0);
    }

    @Test
    public void whenHemisphereOf1_02_thenValueIs2_223() {
        Calculate cut = new Calculate(getScannerFor("hemisphere_1_02"));
        int numberOfTests = cut.get_int_val();
        int testType = cut.get_int_val();
        double r = cut.get_double_val();

        double volume = Calculate.do_calc().get_volume(r);

        assertEquals(1, numberOfTests);
        assertEquals(3, testType);
        assertEquals(1.02, r, 0);
        assertEquals(2.223, cut.round(volume), 0);
    }

    @Test
    public void whenCylinderOfRadius2_789_Height_4_thenValueIs_97_787() {
        Calculate cut = new Calculate(getScannerFor("cylinder_1"));
        int numberOfTests = cut.get_int_val();
        int testType = cut.get_int_val();
        double r = cut.get_double_val();
        double h = cut.get_double_val();

        double volume = Calculate.do_calc().get_volume(r, h);

        cut.output.display(volume);

        assertEquals(1, numberOfTests);
        assertEquals(4, testType);
        assertEquals(2.789, r, 0);
        assertEquals(4.000, h, 0);
        assertEquals(97.748, cut.round(volume), 0);
    }

    private Scanner getScannerFor(String file) {
        InputStream in = CalculateTest.class.getResourceAsStream("/oop/calculatingvolume/" + file + ".txt");
        return new Scanner(in);
    }

}
