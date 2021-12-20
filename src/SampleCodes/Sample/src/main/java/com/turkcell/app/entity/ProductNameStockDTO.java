package com.turkcell.app.entity;

public class ProductNameStockDTO {
    public String name;
    public int stock;

    public ProductNameStockDTO(String name, int stock)
    {
        this.name = name;
        this.stock = stock;
    }

    //...

    @Override
    public String toString()
    {
        return String.format("%s,%d", name, stock);
    }
}
