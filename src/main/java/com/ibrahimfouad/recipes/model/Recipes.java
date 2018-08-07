package com.ibrahimfouad.recipes.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;
import org.springframework.util.Assert;

/**
 *
 * @author ibrahimfouad
 */
@Entity
public class Recipes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "dishName")
    private String dishName;
    @Column(name = "creationDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private  Date creationDate;
    @Lob
    @Column(name = "dishImage",columnDefinition = "LONGBLOB")
    @JsonIgnore
    private  byte[] dishImage;
    @Column(name = "vegetarian")
    private boolean vegetarian;
    @Column(name = "peopleNumber")
    private int peopleNumber;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "instructions")
    private String instructions;

    public Recipes() {
    }

    /**
     *
     * @param dishName
     * @param creationDate
     * @param dishImage
     * @param vegetarian
     * @param peopleNumber
     * @param ingredients
     * @param instructions
     */
    public Recipes(String dishName ,Date creationDate, byte[] dishImage, boolean vegetarian, int peopleNumber, String ingredients, String instructions) {
        Assert.hasLength(dishName, "Dish Name must not be empty");
        Assert.notNull(dishImage, "Dish Image must not be null");
        this.dishName = dishName;
        this.creationDate = creationDate;
        this.dishImage = dishImage;
        this.vegetarian = vegetarian;
        this.peopleNumber = peopleNumber;
        this.ingredients = ingredients;
        this.instructions = instructions;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public byte[] getDishImage() {
        return dishImage;
    }

    public void setDishImage(byte[] dishImage) {
        this.dishImage = dishImage;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
