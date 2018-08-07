package com.ibrahimfouad.recipes.controller;

import com.ibrahimfouad.recipes.dao.RecipeDao;
import com.ibrahimfouad.recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

/**
 *
 * @author ibrahimfouad
 */
@Controller
public class MainController {

    @Autowired
    RecipeDao recipeDao;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("recipes",recipeDao.findAll());
        return "index";
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDishImage/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[]  getDishImage(@PathVariable("id") String id)  {
           Optional<Recipes> recipe=  recipeDao.findById(Integer.parseInt(id));
            if(recipe.isPresent()){
                return recipe.get().getDishImage();
        }

        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getRecipeData/{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Object> getRecipeData(@PathVariable("id") String id){
        Optional<Recipes> recipe=  recipeDao.findById(Integer.parseInt(id));
        if(recipe.isPresent()){
            return new ResponseEntity<>(recipe.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
