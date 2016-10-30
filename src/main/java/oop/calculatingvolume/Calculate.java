package oop.calculatingvolume;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

class Calculate {

    Scanner scanner;

    Output output = new Output();

    public Calculate() throws IOException {
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

    public static VolumeCalculator do_calc() {
        return new VolumeCalculator();
    }

    public static class VolumeCalculator {

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
            return Math.PI * Math.pow(r, 2) * h;
        }
    }

    public class Output {

        public void display(double volume) {
            double round = Calculate.this.round(volume);
            NumberFormat formatter = new DecimalFormat("#0.000");
            System.out.println(formatter.format(round));
        }
    }
}
