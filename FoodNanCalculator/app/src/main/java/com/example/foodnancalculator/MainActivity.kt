package com.example.foodnancalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val ingredients = arrayOf(
        "Bread", "Egg", "Cheese", "Chicken", "Tomato", "Lettuce",
        "Rice", "Beans", "Tuna", "Cucumber", "Mayonnaise", "Chili Sauce",
        "Carrot", "Beef", "Fish", "Potato", "Mushroom", "Avocado",
        "Spinach", "Peanut Butter", "Jam", "Pasta", "Corn", "Onion"
    )

    private val checkBoxes = mutableListOf<CheckBox>()

    private val recipeMap = mapOf(
        setOf("Bread", "Egg") to arrayOf("Classic Egg Sandwich", "Fluffy eggs on toasted bread—simple and tasty!"),
        setOf("Rice", "Beans") to arrayOf("Protein Power Bowl", "Tasty rice and beans for energy."),
        setOf("Chicken", "Lettuce", "Tomato") to arrayOf("Healthy Chicken Wrap", "Chicken, tomato, and lettuce wrapped up fresh!"),
        setOf("Tuna", "Cucumber") to arrayOf("Cool Tuna Rolls", "Fresh tuna with crisp cucumber slices.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ingredientGrid = findViewById<GridLayout>(R.id.ingredientGrid)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val resultTitle = findViewById<TextView>(R.id.resultTitle)
        val resultDesc = findViewById<TextView>(R.id.resultDesc)
        val infoButton = findViewById<Button>(R.id.infoButton)

        ingredients.forEach { ingredient ->
            val cb = CheckBox(this)
            cb.text = ingredient
            cb.textSize = 16f
            val params = GridLayout.LayoutParams()
            params.width = 0
            params.height = GridLayout.LayoutParams.WRAP_CONTENT
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            cb.layoutParams = params
            ingredientGrid.addView(cb)
            checkBoxes.add(cb)
        }

        generateButton.setOnClickListener {
            val selected = checkBoxes.filter { it.isChecked }.map { it.text.toString() }
            if (selected.size < 2 || selected.size > 4) {
                Toast.makeText(this, "Please pick 2 to 4 ingredients.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val found = recipeMap.entries.find { it.key == selected.toSet() }
            if (found != null) {
                resultTitle.text = found.value[0]
                resultDesc.text = found.value[1]
            } else {
                val main = selected.first()
                val others = selected.drop(1)
                val name = when {
                    selected.contains("Bread") || selected.contains("Bun") -> "${others.joinToString(" ")} Sandwich"
                    selected.contains("Rice") -> "${others.joinToString(" ")} Rice Bowl"
                    selected.contains("Pasta") -> "${others.joinToString(" ")} Pasta"
                    selected.contains("Salad") || selected.contains("Lettuce") || selected.contains("Spinach") -> "${selected.joinToString(" ")} Salad"
                    else -> "${selected.joinToString(" ")} Delight"
                }
                val description = "A tasty mix of ${selected.joinToString(", ")}—enjoy your unique creation!"

                resultTitle.text = name
                resultDesc.text = description
            }
            resultTitle.visibility = TextView.VISIBLE
            resultDesc.visibility = TextView.VISIBLE
        }

        infoButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("How Food NaN Calculator Works")
                .setMessage("Pick 2 to 4 ingredients, then tap Generate Lunch to get a creative meal idea!\n\nTry different combinations for surprises.")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}

