/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibrahimfouad.recipes.web;

import com.ibrahimfouad.recipes.controller.MainController;
import com.ibrahimfouad.recipes.dao.RecipeDao;
import com.ibrahimfouad.recipes.model.Recipes;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.web.context.WebApplicationContext;

/**
 * {@code @SpringBootTest} based tests for {@link MainController}.
 *
 * @author ibrahimfouad
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTests {
    
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private RecipeDao recipeDao;
    

    private TestRestTemplate restTemplate;
    
   
    
    Recipes recipe;
    @Before
    public void setUpRecipe() throws Exception{
        recipe = new Recipes();
        ClassPathResource backImgFile = new ClassPathResource("static/images/recipe3.jpg");
        byte[] dishImage = new byte[(int) backImgFile.contentLength()];
        backImgFile.getInputStream().read(dishImage);
        recipe.setDishName("recipe 1");
        recipe.setCreationDate(new Date());
        recipe.setDishImage(dishImage);
        recipe.setVegetarian(true);
        recipe.setPeopleNumber(10);
       
    }
  

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testIndex() throws Exception {
        assertThat(this.recipeDao).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("index"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(print());
    }
    @Test
    public void testgetDishImage() throws Exception {
        assertThat(this.recipeDao).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/getDishImage/1"))
                .andExpect(status().isOk());
    }
    

//    @Test
//    public void testgetRecipeDataByIdWhenDoesNotExist() throws Exception {
//        assertThat(this.recipeDao).isNotNull();
//        mockMvc.perform(MockMvcRequestBuilders.get("/getRecipeData/1"))
//                .andExpect(status().isOk()); 
//       
//    }

   

}
