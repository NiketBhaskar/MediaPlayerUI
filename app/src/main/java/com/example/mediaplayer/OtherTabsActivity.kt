package com.example.mediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.mediaplayer.R
import kotlinx.android.synthetic.main.activity_main.*

class OtherTabsActivity : AppCompatActivity() {
    lateinit var ivMusic: ImageView
    lateinit var ivNav: ImageView
    lateinit var ivCall: ImageView
    lateinit var ivHome: ImageView
    lateinit var ivMeds: ImageView
    lateinit var ivCloud: ImageView
    lateinit var ivDrive: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_tabs)
        ivMusic = findViewById(R.id.ivMusic)
        ivNav = findViewById(R.id.ivNav)
        ivCall = findViewById(R.id.ivCall)
        ivHome = findViewById(R.id.ivHome)
        ivMeds = findViewById(R.id.ivMeds)
        ivCloud = findViewById(R.id.ivCloud)
        ivDrive = findViewById(R.id.ivDrive)
        setIconsColor()
        onBottomIconClicks()

    }
    private fun setIconsColor() {
        ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))

    }
    private fun onBottomIconClicks() {

        ivMusic.setOnClickListener{
            Toast.makeText(this, "Tapped on music", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        ivNav.setOnClickListener{
            Toast.makeText(this, "Tapped on Navigation", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        }
        ivCall.setOnClickListener{
            Toast.makeText(this, "Tapped on Phone", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        }
        ivHome.setOnClickListener{
            Toast.makeText(this, "Tapped on Home", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        }
        ivMeds.setOnClickListener{
            Toast.makeText(this, "Tapped on near by Medical Store", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        }
        ivCloud.setOnClickListener{
            Toast.makeText(this, "Tapped on Cloud", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        }
        ivDrive.setOnClickListener{
            Toast.makeText(this, "Tapped on Drive", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }

    }

}