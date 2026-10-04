package org.example;

import org.example.Art.Painting;
import org.example.Art.Sculpture;
import org.example.Exhibition.Exhibition;
import org.example.Exhibition.Gallery;
import org.example.Exhibition.Museum;
import org.example.ObjectType.Physical;
import org.example.ObjectType.Virtual;
import org.example.Price.IPrice;
import org.example.Price.PriceEur;
import org.example.Price.PriceKzt;
import org.example.Price.PriceUsd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        IPrice price;

        try(Scanner scanner = new Scanner(System.in)){
            price = choosePrice(scanner);
        }

        Exhibition gallery = new Gallery(
                new Painting("Starry Night"),
                new Physical("Canvas"),
                100000, price);


        System.out.println("International Gallery");
        gallery.show();

        gallery.setFormat(new Virtual("virtual 3D model"));

        System.out.println("International Gallery,");
        gallery.show();

        Exhibition museum = new Museum(
                new Sculpture("David"),
                new Physical("Marble statue"),
                1000000, price
        );

        System.out.println("Global Museum");
        museum.show();

    }

    private static IPrice choosePrice(Scanner scanner) {
        while (true) {
            System.out.println(
                    "Choose your currency: 1 - USD, 2 - EUR, 3 - KZT"
            );

            if (!scanner.hasNextLine()) {
                System.out.println("No input. Using USD.");
                return new PriceUsd();
            }

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return new PriceUsd();
                case "2":
                    return new PriceEur();
                case "3":
                    return new PriceKzt();
                default:
                    System.out.println(
                            "Invalid choice. Please enter 1, 2 or 3."
                    );
            }
        }
    }
}
