package org.example;

import java.util.*;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer("Mahwish", 23, "Lahore", Gender.FEMALE, 7700.0),
                new Customer("Bilal", 25, "New York", Gender.MALE, 3400.0),
                new Customer("Khizar", 20, "Karachi", Gender.MALE, 2100.0),
                new Customer("Hamna", 40, "Islamabad", Gender.FEMALE, 7606.0),
                new Customer("Alishbah", 32, "New York", Gender.FEMALE, 5509.0),
                new Customer("Aleezae", 38, "New York", Gender.FEMALE, 8800.0),
                new Customer("Subhan", 44, "Lahore", Gender.MALE, 2309.0)
        );
        //a. Filter customers based on the following criteria:
        //Age between 25 and 40.
        //City equals a specific value (e.g., "New York").
        //Gender is either Male or Female.

        List<Customer> FilterL1 = customers.stream()
                .filter(cust -> cust.getAge() >= 25 && cust.getAge() <= 40)
                .filter(cust -> cust.getCity().equals("New York"))
                .filter(cust -> cust.getGender() == Gender.MALE || cust.getGender() == Gender.FEMALE).collect(Collectors.toList());


        //b. Map the filtered customers to a new stream of strings, representing their names.
        List<String> MapNames = FilterL1.stream().map(cNames -> cNames.getName()).collect(Collectors.toList());
        //System.out.println(MapNames);

        //c. Sort the names in alphabetical order.
        List<String> SortedNames = MapNames.stream().sorted().collect(Collectors.toList());
        //System.out.println(SortedNames);

        //d. Calculate the total purchase amount for all customers.
        double TotalAmount = customers.stream().mapToDouble(cAmount->cAmount.getPurchaseAmount()).sum();
        //System.out.println(TotalAmount);


        //e. Find the customer(s) with the highest purchase amount.
        List<Customer> MaxAmount = customers.stream().filter(customer -> customer.getPurchaseAmount() == customers.stream()
                .mapToDouble(n->n.getPurchaseAmount())
                .max()
                .orElse(0.0))
                .collect(Collectors.toList());

        List<String> MapName2 = MaxAmount.stream().map(cNames -> cNames.getName()).collect(Collectors.toList());
        //System.out.println("Customer with highest purchase amount: "+ MapName2);

        //f. Group the customers by city and calculate the average purchase amount for each city.

        Map<String, Double> avgAmountByCity = customers.stream()
                .collect(Collectors.groupingBy(n->n.getCity(), Collectors.averagingDouble(n->n.getPurchaseAmount())));

        // g. Collect the filtered customers into a new list.
        List<Customer> newFilterCust = customers.stream().filter(customer -> customer.getAge() >= 25 && customer.getAge() <= 40)
                .filter(customer -> customer.getCity().equals("New York"))
                .filter(customer -> customer.getGender() == Gender.MALE || customer.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());

        System.out.println("-----------------");
        System.out.println("Customers b/w age 25 and 40, living in New York, either Male or Female in Sorted Order:");
        SortedNames.forEach(n-> System.out.println(n));

        System.out.println("\nTotal Purchase Amount: \n" + TotalAmount);
        System.out.println();

        System.out.println("Customer with the Highest Purchase Amount:");
        MapName2.forEach(name-> System.out.println(name));

        System.out.println("\nAverage purchase amount by city:");
        avgAmountByCity.forEach((city, avgPurchaseAmount) ->
                System.out.println("City: "+ city + " , Purchase Amount: " + avgPurchaseAmount));
        System.out.println("\n");

    }
}