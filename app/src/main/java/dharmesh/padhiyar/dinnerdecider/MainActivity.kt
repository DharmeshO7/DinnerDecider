package dharmesh.padhiyar.dinnerdecider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Burger", "Pizza", "Sandwich", "Pasta", "Biryani", "Maggi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random()

        decideButton.setOnClickListener {

            val randomFood = random.nextInt(foodList.count())
            val randomFoodName = foodList[randomFood]

            if (randomFoodName.equals(selectedFood.text)) {
                decideButton.callOnClick()
            } else {
                selectedFood.text = foodList[randomFood]
            }
        }

        addFoodButton.setOnClickListener {

            val foodName = addFoodTxt.text.toString()

            if (!foodName.isEmpty()) {
                foodList.add(foodName)
                addFoodTxt.text.clear()
                Toast.makeText(this, "Food added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Enter something fool!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
