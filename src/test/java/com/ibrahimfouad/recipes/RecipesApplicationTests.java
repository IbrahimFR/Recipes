package com.ibrahimfouad.recipes;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * 
 * @author ibrahimfouad
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipesApplicationTests {
       @Autowired
	private ApplicationContext applicationContext;

	 @Test
	public void RecipesApplicationShouldBeAvailable() {
		// Since we're a @SpringBootTest all beans should be available.
		assertThat(this.applicationContext.getBean(RecipesApplication.class))
				.isNotNull();
	}

}
