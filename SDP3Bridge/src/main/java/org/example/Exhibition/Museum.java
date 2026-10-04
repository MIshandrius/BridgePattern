package org.example.Exhibition;

import org.example.Art.IArt;
import org.example.ObjectType.IObjectFormat;
import org.example.Price.IPrice;

public class Museum extends Exhibition{
    public Museum(
            IArt artwork,
            IObjectFormat form,
            double priceUsd,
            IPrice price
    ) {
        super(artwork, price, priceUsd, form);
    }

    @Override
    public void show() {
        System.out.println("This artwork is NOT available for sale");
        showDetails();
    }
}
