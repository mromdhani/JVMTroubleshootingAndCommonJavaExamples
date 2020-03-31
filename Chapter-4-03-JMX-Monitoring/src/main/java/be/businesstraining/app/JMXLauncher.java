package be.businesstraining.app;

import java.lang.management.ManagementFactory;
import java.util.Scanner;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import be.businesstraining.mbeans.Calculator;

public class JMXLauncher {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        registerWithJmxAgent(calculator);
        startConsoleApp(calculator);
    }
    private static void registerWithJmxAgent(Calculator calculator) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("be.businesstraining:type=calculator");
        mbs.registerMBean(calculator, name);
    }
    
    private static void startConsoleApp(Calculator calculator) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------");
            String input1 = getUserInput(scanner, "Enter the first number: ");
            double d1 = toDouble(input1);

            String input2 = getUserInput(scanner, "Enter the second number: ");
            double d2 = toDouble(input2);

            double sum = calculator.add(d1, d2);
            System.out.printf("sum = %s (rounded to %s decimal places)%n",
                    sum, calculator.getDecimalPlaces());
        }
    }

    private static double toDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number, defaulting to 0");
            return 0;
        }
    }

   

    public static String getUserInput(Scanner scanner, String msg) {
        System.out.print(msg + ">");
        String s = scanner.nextLine();
        if ("exit".equals(s)) {
            System.exit(0);
        }
        return s;
    }
}