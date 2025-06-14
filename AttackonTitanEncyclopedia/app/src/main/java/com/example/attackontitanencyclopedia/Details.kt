package com.example.attackontitanencyclopedia

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.attackontitanencyclopedia.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(sys.left, sys.top, sys.right, sys.bottom)
            insets
        }



        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val detailsMap = listOf(
            CharacterDetail(
                name            = "Eren Yeager",
                imageResId      = R.drawable.eren,
                affiliation     = "Survey Corps",
                titanForm       = "Attack Titan",
                height          = "185 cm",
                status          = "Alive (Season 4)",
                birthday        = "March 30",
                bloodType       = "AB",
                voiceActor      = "Yuki Kaji",
                firstAppearance = "Episode 1",
                bio             = "Driven by vengeance after witnessing his mother’s death, Eren possesses the power to transform into the Attack Titan and seeks freedom for humanity."
            ),
            CharacterDetail(
                name            = "Mikasa Ackerman",
                imageResId      = R.drawable.mikasa,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "170 cm",
                status          = "Alive",
                birthday        = "February 10",
                bloodType       = "A",
                voiceActor      = "Yui Ishikawa",
                firstAppearance = "Episode 1",
                bio             = "Adopted into the Yeager family, Mikasa is fiercely protective of Eren and ranks among humanity’s strongest soldiers."
            ),
            CharacterDetail(
                name            = "Armin Arlert",
                imageResId      = R.drawable.armin,
                affiliation     = "Survey Corps",
                titanForm       = "Colossal Titan (briefly)",
                height          = "163 cm",
                status          = "Alive",
                birthday        = "November 3",
                bloodType       = "O",
                voiceActor      = "Marina Inoue",
                firstAppearance = "Episode 1",
                bio             = "A brilliant tactician with a kind heart, Armin sacrifices everything to inherit the Colossal Titan and turn the tide of war."
            ),
            CharacterDetail(
                name            = "Levi Ackerman",
                imageResId      = R.drawable.levi,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "160 cm",
                status          = "Alive",
                birthday        = "December 25",
                bloodType       = "O",
                voiceActor      = "Hiroshi Kamiya",
                firstAppearance = "Episode 3",
                bio             = "Humanity’s strongest soldier, Captain Levi leads elite squads, renowned for his unmatched combat skill and stoic resolve."
            ),
            CharacterDetail(
                name            = "Erwin Smith",
                imageResId      = R.drawable.erwin,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "188 cm",
                status          = "Deceased",
                birthday        = "January 1",
                bloodType       = "A",
                voiceActor      = "Daisuke Namikawa",
                firstAppearance = "Episode 4",
                bio             = "The visionary commander of the Survey Corps, Erwin sacrifices himself in a gambit to retake Wall Maria."
            ),
            CharacterDetail(
                name            = "Hange Zoe",
                imageResId      = R.drawable.hange,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "170 cm",
                status          = "Alive",
                birthday        = "September 21",
                bloodType       = "B",
                voiceActor      = "Yō Koike",
                firstAppearance = "Episode 13",
                bio             = "Obsessed with Titan research, Hange’s ingenuity and compassion drive scientific breakthroughs in humanity’s fight."
            ),
            CharacterDetail(
                name            = "Jean Kirstein",
                imageResId      = R.drawable.jean,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "177 cm",
                status          = "Alive",
                birthday        = "June 7",
                bloodType       = "O",
                voiceActor      = "Tomohisa Hashizume",
                firstAppearance = "Episode 2",
                bio             = "Originally self-serving, Jean grows into a dependable leader whose courage inspires his comrades."
            ),
            CharacterDetail(
                name            = "Sasha Blouse",
                imageResId      = R.drawable.sasha,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "170 cm",
                status          = "Deceased",
                birthday        = "July 14",
                bloodType       = "B",
                voiceActor      = "Yu Kondō",
                firstAppearance = "Episode 5",
                bio             = "Nicknamed “Potato Girl,” Sasha’s sharpshooting and humor uplift her squad until her heroic sacrifice."
            ),
            CharacterDetail(
                name            = "Connie Springer",
                imageResId      = R.drawable.conny,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "173 cm",
                status          = "Alive",
                birthday        = "May 15",
                bloodType       = "AB",
                voiceActor      = "Yūichi Nakamura",
                firstAppearance = "Episode 5",
                bio             = "A loyal friend with a quick wit, Connie overcomes personal tragedy and remains steadfast in battle."
            ),
            CharacterDetail(
                name            = "Historia Reiss",
                imageResId      = R.drawable.historia,
                affiliation     = "Survey Corps",
                titanForm       = "None",
                height          = "152 cm",
                status          = "Alive",
                birthday        = "January 15",
                bloodType       = "O",
                voiceActor      = "Shiori Mikami",
                firstAppearance = "Episode 16",
                bio             = "Born into royalty, Historia embraces her duty and leads humanity with compassion as queen."
            ),

            CharacterDetail(
                name            = "Colossal Titan",
                imageResId      = R.drawable.colossall,
                affiliation     = "Marley",
                titanForm       = "Colossal Titan",
                height          = "60 m",
                status          = "Deceased",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Ryōta Takeuchi",
                firstAppearance = "Episode 1",
                bio             = "A weapon of mass destruction, the Colossal Titan appears at Wall Maria’s fall and again in the legends of war."
            ),
            CharacterDetail(
                name            = "Armored Titan",
                imageResId      = R.drawable.armored,
                affiliation     = "Marley",
                titanForm       = "Armored Titan",
                height          = "15 m",
                status          = "Alive",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Kō Ugorji",
                firstAppearance = "Episode 2",
                bio             = "Encased in an impenetrable shell, the Armored Titan shatters walls and brings fear to humanity."
            ),
            CharacterDetail(
                name            = "Attack Titan",
                imageResId      = R.drawable.attack,
                affiliation     = "Survey Corps",
                titanForm       = "Attack Titan",
                height          = "15 m",
                status          = "Active",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Yuki Kaji",
                firstAppearance = "Episode 3",
                bio             = "The original inheritor of Eren’s power, this Titan fights for freedom across the centuries."
            ),
            CharacterDetail(
                name            = "Female Titan",
                imageResId      = R.drawable.female,
                affiliation     = "Eldian Restorationists",
                titanForm       = "Female Titan",
                height          = "14 m",
                status          = "Deceased",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Hana Kana",
                firstAppearance = "Episode 9",
                bio             = "Possessing hardening and intelligence, the Female Titan hunts Survey Corps soldiers with deadly precision."
            ),
            CharacterDetail(
                name            = "Beast Titan",
                imageResId      = R.drawable.beast,
                affiliation     = "Marley",
                titanForm       = "Beast Titan",
                height          = "17 m",
                status          = "Deceased",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Kōji Yasuda",
                firstAppearance = "Episode 17",
                bio             = "Able to hurl projectiles with uncanny accuracy and command Titans, the Beast Titan reshapes battlefields."
            ),
            CharacterDetail(
                name            = "Jaw Titan",
                imageResId      = R.drawable.jaw,
                affiliation     = "Marley",
                titanForm       = "Jaw Titan",
                height          = "5 m",
                status          = "Alive",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Satoshi Hino",
                firstAppearance = "Episode 12",
                bio             = "Small but ferocious, the Jaw Titan’s crushing jaws and agility make it a nightmare in close combat."
            ),
            CharacterDetail(
                name            = "Cart Titan",
                imageResId      = R.drawable.cart,
                affiliation     = "Marley",
                titanForm       = "Cart Titan",
                height          = "4 m",
                status          = "Alive",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Kana Hanazawa",
                firstAppearance = "Episode 32",
                bio             = "Endurance-focused, the Cart Titan serves as a long-distance transporter and support unit on the front lines."
            ),
            CharacterDetail(
                name            = "War Hammer Titan",
                imageResId      = R.drawable.warhammer,
                affiliation     = "Tybur Family",
                titanForm       = "War Hammer Titan",
                height          = "13 m",
                status          = "Deceased",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Yū Shimaka",
                firstAppearance = "Episode 59",
                bio             = "Encased in crystal and able to form weapons at will, the War Hammer Titan is one of the most versatile forms."
            ),
            CharacterDetail(
                name            = "Founding Titan",
                imageResId      = R.drawable.founding,
                affiliation     = "Reiss Family",
                titanForm       = "Founding Titan",
                height          = "13 m",
                status          = "Active (Eren)",
                birthday        = "Unknown",
                bloodType       = "N/A",
                voiceActor      = "Yuki Kaji",
                firstAppearance = "Episode 1",
                bio             = "With the power to rewrite Eldian memories and control Titans, the Founding Titan stands at the center of history."
            )
        ).associateBy { it.name }



        val charName = intent.getStringExtra("CHAR_NAME") ?: ""
        val detail = detailsMap[charName]
            ?: error("No detail found for $charName")


        binding.characterName.text             = detail.name
        binding.characterImage.setImageResource(detail.imageResId)
        binding.characterAffiliation.text      = detail.affiliation
        binding.characterTitanForm.text        = detail.titanForm
        binding.characterHeight.text           = detail.height
        binding.characterStatus.text           = detail.status
        binding.characterBirthday.text         = detail.birthday
        binding.characterBloodType.text        = detail.bloodType
        binding.characterVoiceActor.text       = detail.voiceActor
        binding.characterFirstAppearance.text  = detail.firstAppearance
        binding.characterDescription.text      = detail.bio
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
