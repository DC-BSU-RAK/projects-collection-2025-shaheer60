package com.example.attackontitanencyclopedia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.attackontitanencyclopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sys.left, sys.top, sys.right, sys.bottom)
            insets
        }


        val characters = listOf(
            Character("Eren Yeager",    R.drawable.eren),
            Character("Mikasa Ackerman",R.drawable.mikasa),
            Character("Armin Arlert",   R.drawable.armin),
            Character("Levi Ackerman",  R.drawable.levi),
            Character("Erwin Smith",    R.drawable.erwin),
            Character("Hange Zoe",      R.drawable.hange),
            Character("Jean Kirstein",  R.drawable.jean),
            Character("Sasha Blouse",   R.drawable.sasha),
            Character("Connie Springer",R.drawable.conny),
            Character("Historia Reiss", R.drawable.historia),
            Character("Colossal Titan", R.drawable.colossall),
            Character("Armored Titan",  R.drawable.armored),
            Character("Attack Titan",   R.drawable.attack),
            Character("Female Titan",   R.drawable.female),
            Character("Beast Titan",    R.drawable.beast),
            Character("Jaw Titan",      R.drawable.jaw),
            Character("Cart Titan",     R.drawable.cart),
            Character("War Hammer Titan", R.drawable.warhammer),
            Character("Founding Titan", R.drawable.founding),
        )

        adapter = CharacterAdapter(characters) { character ->
            val intent = Intent(this, Details::class.java).apply {
                putExtra("CHAR_NAME", character.name)
                putExtra("CHAR_IMAGE", character.imageResId)
            }
            startActivity(intent)
        }

        binding.characterRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            this.adapter = this@MainActivity.adapter
        }
    }
}
