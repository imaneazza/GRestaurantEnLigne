/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class Ingrediant {
    private int id;
    private String name;
    private UniteMesure unitMesure;
    private int stock;
    private ArrayList<Price> archivePrice;
    private int categoryId;
    public Ingrediant() {
        this.id = -1;
        this.name = "";
        this.unitMesure = UniteMesure.autre;
        this.stock = 0;
        this.archivePrice = new ArrayList<Price>();
        this.categoryId=-1;
    }

    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, ArrayList<Price> archivePrice, int category) {
        this.categoryId=category;
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice=archivePrice;
    }

    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, Price price, int category) {
        this.categoryId=category;
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice = new ArrayList<Price>();
        this.archivePrice.add(price);
    }
    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, int category) {
        this.categoryId=category;
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice = new ArrayList<Price>();
    }
    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, ArrayList<Price> archivePrice, Category category) {
        this.categoryId=category.getId();
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice=archivePrice;
    }

    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, Price price, Category category) {
        this.categoryId=category.getId();
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice = new ArrayList<Price>();
        this.archivePrice.add(price);
    }
    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock, Category category) {
        this.categoryId=category.getId();
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice = new ArrayList<Price>();
    }
    
    public Ingrediant(int id,String name, UniteMesure unitMesure, int stock) {
        this.categoryId=-1;
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice = new ArrayList<Price>();
    }

    public void addNewPrice(float price) {
        Price p=new Price(-1,new Date(),price);
        this.archivePrice.add(p);
    }

    public void removePrice(Date date) {
        this.archivePrice.remove(date);
    }

    public void removePrice(Price price) {
        this.archivePrice.remove( price);
    }

    public void addNewPrice(int id,Date date, float price) {
        this.archivePrice.add(id, new Price(id,date,price));
    }
    public void addNewPrice(Price price) {
        this.archivePrice.add(price);
    }

    public Price getCurrentPrice() {
        Date current = new Date();
        Date date = archivePrice.get(0).getDate();
        Price price = archivePrice.get(0);
        for (Price row : archivePrice) {
            if ((row.getDate().after(date) || row.getDate().equals(date)) && row.getDate().before(current)) {
                price = row;
            }
        }
        return price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unitMesure
     */
    public UniteMesure getUnitMesure() {
        return unitMesure;
    }

    /**
     * @param unitMesure the unitMesure to set
     */
    public void setUnitMesure(UniteMesure unitMesure) {
        this.unitMesure = unitMesure;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the archivePrice
     */
    public ArrayList<Price> getArchivePrice() {
        return archivePrice;
    }

    /**
     * @param archivePrice the archivePrice to set
     */
    public void setArchivePrice(ArrayList<Price> archivePrice) {
        this.archivePrice = archivePrice;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public void addStock(int quantity){
        this.stock+=quantity;
    }
    public void consume(int quantity){
        this.stock-=quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
