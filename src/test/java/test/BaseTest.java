package test;

import org.junit.Assert;

import java.io.InputStream;
import java.util.Scanner;

public class BaseTest extends Assert {

    protected Scanner getScannerFor(String file) {
        InputStream in = BaseTest.class.getResourceAsStream(file);
        return new Scanner(in);
    }
}
