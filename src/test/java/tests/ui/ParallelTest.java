package tests.ui;

import core.driver.DriverManager;
import tests.ui.base.BaseTest;

import org.testng.annotations.Test;

public class ParallelTest extends BaseTest {

    @Test
    public void testOne() {
        System.out.println("Thread: " + Thread.currentThread().getId());
        System.out.println("Driver: " + DriverManager.getDriver());
    }

    @Test
    public void testTwo() {
        System.out.println("Thread: " + Thread.currentThread().getId());
        System.out.println("Driver: " + DriverManager.getDriver());
    }
}