package com.example.cookbook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.cookbook.model.Recipe
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cookbook.ui.theme.defaultRecipes

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier){
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
        val image = painterResource(id = recipe.imageResource)
        // layout/card to hold image and text of recipe
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            // image and text
            Image(painter = image,
                contentDescription = "A delicious cake",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp),
                contentScale = ContentScale.Crop
            )
            Text(recipe.title, modifier = Modifier.padding(5.dp))
            //loop the ingredients
            Text(text = "ingredients........",
                modifier = Modifier.padding(5.dp)
            )

            for(ingredient in recipe.ingredients){
                Text(". $ingredient", modifier = Modifier.padding(10.dp))
            }


        }
        
    }
}

// dummy
@Composable
@Preview
fun DefaultRecipeCard(){
    RecipeCard(defaultRecipes[0], Modifier.padding(12.dp))
}