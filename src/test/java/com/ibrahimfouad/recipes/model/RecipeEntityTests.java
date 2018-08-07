/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibrahimfouad.recipes.model;

import com.ibrahimfouad.recipes.dao.RecipeDao;
import java.io.IOException;
import java.util.Date;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

/**
 * Data JPA tests for {@link Recipes}.
 *
 * @author ibrahimfouad
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class RecipeEntityTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Autowired
    RecipeDao recipeDao;
    

    @Test
    public void createWhenDishNameIsNullShouldThrowException() throws IOException {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Dish Name must not be empty");
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        new Recipes(null, new Date(), dishImage, true, 10, "", "");

    }

    @Test
    public void createWhenDishNameIsEmptyShouldThrowException() throws IOException {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Dish Name must not be empty");
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        new Recipes("", new Date(), dishImage, true, 10, "", "");
    }

    @Test
    public void createWhenDishImageIsNullShouldThrowException() {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Dish Image must not be null");
        new Recipes("recipe 1", new Date(), null, true, 10, "", "");

    }

    @Test
    public void saveShouldPersistData() throws IOException {
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        Recipes user = this.recipeDao.save(new Recipes("recipe 1", new Date(), dishImage, true, 10, "", ""));
        assertThat(user.getDishName()).isEqualTo("recipe 1");
        assertThat(user.getDishImage()).isEqualTo(dishImage);
    }

}
