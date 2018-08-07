/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibrahimfouad.recipes.dao;

import com.ibrahimfouad.recipes.model.Recipes;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ibrahimfouad
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class RecipesDaoTests {

    @Autowired
    RecipeDao recipeDao;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindAll() throws IOException {
        //given
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        Recipes recipe1 = new Recipes("recipe 3", new Date(), dishImage, true, 10, "", "");
        entityManager.persist(recipe1);
        entityManager.flush();
        Recipes recipe2 = new Recipes("recipe 4", new Date(), dishImage, true, 10, "", "");
        entityManager.persist(recipe2);
        entityManager.flush();
        //when
        List<Recipes> recipes = (List<Recipes>) recipeDao.findAll();
        //then
        assertThat(recipes.size()).isEqualTo(8);
        assertThat(recipes.get(2)).isEqualTo(recipe1);
        assertThat(recipes.get(3)).isEqualTo(recipe2);
    }

    @Test
    public void whenFindById() throws IOException {
        //given
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        Recipes recipe = new Recipes("recipe 1", new Date(), dishImage, true, 10, "", "");
        entityManager.persist(recipe);
        entityManager.flush();
        //when
        Optional<Recipes> testRecipe = recipeDao.findById(recipe.getId());
        //then
        assertThat(testRecipe.get().getDishName()).isEqualTo(recipe.getDishName());
    }

}
