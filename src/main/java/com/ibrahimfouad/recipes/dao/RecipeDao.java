package com.ibrahimfouad.recipes.dao;

import com.ibrahimfouad.recipes.model.Recipes;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ibrahimfouad
 */
public interface RecipeDao extends CrudRepository<Recipes, Integer> {

}
