/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inknown
 */
public class Ingredient {

    private int id;
    private String name;
    private UniteMesure unitMesure;
    private int stock;
    private Map<Integer, Price> archivePrice;
    private Category category;

    public Ingredient() {
        this.id = -1;
        this.name = "";
        this.unitMesure = UniteMesure.autre;
        this.stock = 0;
        archivePrice = new HashMap<Integer, Price>();
        category = new Category();
    }

    public Ingredient(int id,String name, UniteMesure unitMesure, int stock, Map<Integer, Price> archivePrice, Category category) {
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice.putAll(archivePrice);
        this.category = category;
    }

    public Ingredient(int id,String name, UniteMesure unitMesure, int stock, Price price, Category category) {
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.archivePrice.put(price.getId(),price);
        this.category = category;
    }
    public Ingredient(int id,String name, UniteMesure unitMesure, int stock, Category category) {
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.category = category;
    }
    
    public Ingredient(int id,String name, UniteMesure unitMesure, int stock) {
        this.id = id;
        this.name = name;
        this.unitMesure = unitMesure;
        this.stock = stock;
        this.category = null;
    }

    public void addNewPrice(float price) {
        Price p=new Price(-1,new Date(),price);
        this.getArchivePrice().put(p.getId(),p);
    }

    public void removePrice(Date date) {
        this.getArchivePrice().remove(date);
    }

    public void removePrice(Price price) {
        this.getArchivePrice().remove(price.getDate(), price);
    }

    public void addNewPrice(int id,Date date, float price) {
        this.getArchivePrice().put(id, new Price(id,date,price));
    }
    public void addNewPrice(Price price) {
        this.getArchivePrice().put(price.getId(), price);
    }

    public Price getCurrentPrice() {
        Date current = new Date();
        Date date = (Date) getArchivePrice().keySet().toArray()[0];
        Price price = null;
        for (Price row : getArchivePrice().values()) {
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
    public Map<Integer, Price> getArchivePrice() {
        return archivePrice;
    }

    /**
     * @param archivePrice the archivePrice to set
     */
    public void setArchivePrice(Map<Integer, Price> archivePrice) {
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

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
