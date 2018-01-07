/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author inknown
 */
public class Detail {

    private Ingrediant ingredient = null;
    private int formId;
    private boolean isObligatory = false;
    private double max = 0;
    private double min = 0;

    public Detail() {
    }

    public Detail(int formId, Ingrediant ingredient, boolean isObligatory, double min, double max) {
        this.formId=formId;
        this.ingredient = ingredient;
        this.isObligatory = isObligatory;
        if (max > min) {
            this.max = max;
            this.min = min;
        } else {
            this.max = min;
            this.min = max;
        }
    }
    public Detail(double form, Ingrediant ingredient,double quantity) {
        this.formId=formId;
        this.ingredient = ingredient;
        this.isObligatory = true;
        this.max = quantity;
        this.min = quantity;
    }
    public Detail(Form form, Ingrediant ingredient, boolean isObligatory, double min, double max) {
        this.formId=form.getId();
        this.ingredient = ingredient;
        this.isObligatory = isObligatory;
        if (max > min) {
            this.max = max;
            this.min = min;
        } else {
            this.max = min;
            this.min = max;
        }
    }
    public Detail(Form form, Ingrediant ingredient,double quantity) {
        this.formId=form.getId();
        this.ingredient = ingredient;
        this.isObligatory = true;
        this.max = quantity;
        this.min = quantity;
    }


    /**
     * @return the ingredient
     */
    public Ingrediant getIngredient() {
        return ingredient;
    }

    /**
     * @param ingredient the ingredient to set
     */
    public void setIngredient(Ingrediant ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * @return the isObligatory
     */
    public boolean getObligatory() {
        return isObligatory;
    }

    /**
     * @param isObligatory the isObligatory to set
     */
    public void setObligatory(boolean isObligatory) {
        this.isObligatory = isObligatory;
    }

    /**
     * @return the max
     */
    public double getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * @return the min
     */
    public double getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(double min) {
        this.min = min;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }
}
