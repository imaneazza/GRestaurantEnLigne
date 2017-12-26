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

    private Form form = null;
    private Ingredient ingredient = null;
    private boolean isObligatory = false;
    private int max = 0;
    private int min = 0;

    public Detail() {
    }

    public Detail(Form form, Ingredient ingredient, boolean isObligatory, int min, int max) {
        this.form = form;
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
    public Detail(boolean isObligatory, int min, int max) {
        this.isObligatory = isObligatory;
        if (max > min) {
            this.max = max;
            this.min = min;
        } else {
            this.max = min;
            this.min = max;
        }
    }

    /**
     * @return the form
     */
    public Form getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(Form form) {
        this.form = form;
    }

    /**
     * @return the ingredient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * @param ingredient the ingredient to set
     */
    public void setIngredient(Ingredient ingredient) {
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
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

}
