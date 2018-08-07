package com.ibrahimfouad.recipes;

import com.ibrahimfouad.recipes.dao.RecipeDao;
import com.ibrahimfouad.recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author ibrahimfouad
 */
@SpringBootApplication
@EnableAutoConfiguration
public class RecipesApplication implements CommandLineRunner {

    @Autowired
    RecipeDao recipeDao;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }

    /**
     *
     * @param arg0
     * @throws Exception
     */
    @Override
    public void run(String... arg0) throws Exception {
        // recipe 1
        ClassPathResource recipeImage1 = new ClassPathResource("static/images/recipe1.jpg");
        byte[] arrayPic = new byte[(int) recipeImage1.contentLength()];
        recipeImage1.getInputStream().read(arrayPic);
        Recipes recipe1 = new Recipes("Tomato-Peach Salad", new Date(), arrayPic, true, 379, "Toss tomato and peach wedges with red onion slices. Drizzle with cider vinegar and olive oil; season with sugar, salt and pepper.", "do something");

        // recipe 2
        ClassPathResource recipeImage2 = new ClassPathResource("static/images/recipe2.jpg");
        arrayPic = new byte[(int) recipeImage2.contentLength()];
        recipeImage2.getInputStream().read(arrayPic);
        Recipes recipe2 = new Recipes("Jicama-Mango Slaw", new Date(), arrayPic, true, 87, "Toss julienned mango and jicama, red onion, radish and cilantro; add cumin, salt and cayenne. Drizzle with olive oil and lime juice.", "do something");

        // recipe 3
        ClassPathResource recipeImage3 = new ClassPathResource("static/images/recipe3.jpg");
        arrayPic = new byte[(int) recipeImage3.contentLength()];
        recipeImage3.getInputStream().read(arrayPic);
        Recipes recipe3 = new Recipes("Herb, Sausage, and Cheese Dutch Baby", new Date(), arrayPic, true, 87, "1/3 cup bulk Italian sausage , 1/2 teaspoon salt, 3 eggs, at room temperature, 1 pinch cracked black pepper", "do something");
        
        // recipe 4
        ClassPathResource recipeImage4 = new ClassPathResource("static/images/recipe4.jpg");
        arrayPic = new byte[(int) recipeImage4.contentLength()];
        recipeImage4.getInputStream().read(arrayPic);
        Recipes recipe4 = new Recipes("Mushroom Chicken Piccata", new Date(), arrayPic, true, 817, "1/2 cup all-purpose flour,1/2 pound fresh mushrooms, sliced,1 teaspoon salt,1/4 cup chopped onion", "do something");

        // recipe 5
        ClassPathResource recipeImage5 = new ClassPathResource("static/images/recipe5.jpg");
        arrayPic = new byte[(int) recipeImage5.contentLength()];
        recipeImage5.getInputStream().read(arrayPic);
        Recipes recipe5 = new Recipes("Mini Cheesecakes III", new Date(), arrayPic, false, 870, "1/3 cup graham cracker crumbs , 1/4 cup white sugar sliced, 1 tablespoon white sugar, 1/2 teaspoon grated lemon zest", "do something");

        // recipe 6
        ClassPathResource recipeImage6 = new ClassPathResource("static/images/recipe6.jpg");
        arrayPic = new byte[(int) recipeImage6.contentLength()];
        recipeImage6.getInputStream().read(arrayPic);
        Recipes recipe6 = new Recipes("Linguine with Peppers and Sausage", new Date(), arrayPic, false, 450, "1 (8 ounce) package linguini pasta , 1 cup white wine, 1/2 pound sweet Italian sausage, casings removed, 1/4 cup grated Parmesan cheese", "do something");

        
        // store image to MySQL via SpringJPA
        recipeDao.save(recipe1);
        recipeDao.save(recipe2);
        recipeDao.save(recipe3);
        recipeDao.save(recipe4);
        recipeDao.save(recipe5);
        recipeDao.save(recipe6);

    }
}
