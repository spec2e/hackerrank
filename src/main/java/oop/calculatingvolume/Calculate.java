package oop.calculatingvolume;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculate {

    Scanner scanner;

    public Calculate() {
        scanner = new Scanner(System.in);
    }

    public Calculate(Scanner scanner) {
        this.scanner = scanner;
    }

    public int get_int_val() {
        int val = scanner.nextInt();
        if(val > 0) {
            return val;
        }
        throw new NumberFormatException("All the values must be positive");
    }

    public double get_double_val() {
        double val = scanner.nextDouble();
        if(val > 0) {
            return val;
        }
        throw new NumberFormatException("All the values must be positive");
    }

    public double round(double val) {
        BigDecimal bigDecimal = BigDecimal.valueOf(val);
        bigDecimal = bigDecimal.setScale(3, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public VolumeCalculator do_calc() {
        return new VolumeCalculator();
    }

    public class VolumeCalculator {

        public double get_volume(int a) {
            return Math.pow(a, 3);
        }

        public double get_volume(int l, int b, int h) {
            return l * b * h;
        }

        public double get_volume(double r) {
            double v = (2.0 / 3.0) * Math.PI;
            double pow = Math.pow(r, 3);
            return v * pow;
        }

        public double get_volume(double r, double h) {

            double area = Math.PI * Math.pow(r, 2);

            return area * h;
        }
    }
}
