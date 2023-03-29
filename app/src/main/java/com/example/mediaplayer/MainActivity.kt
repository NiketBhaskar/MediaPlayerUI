package com.example.mediaplayer

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.databinding.ActivityMainBinding
import com.example.mediaplayer.model.DummySongs
import com.example.mediaplayer.model.Songs
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),IconsClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var ivMusic: ImageView
    lateinit var ivNav: ImageView
    lateinit var ivCall: ImageView
    lateinit var ivHome: ImageView
    lateinit var ivMeds: ImageView
    lateinit var ivCloud: ImageView
    lateinit var ivDrive: ImageView
    lateinit var playerTitle: TextView
    lateinit var playerLength: TextView
    lateinit var playerImage: ImageView
    lateinit var seekBar: SeekBar
    lateinit var playBtn: ImageView
    lateinit var playerSide: LinearLayout
    var progressSeek: Int = 0
    var handler = Handler()
    var runnable: Runnable? = null
    var isPlaying = false
    lateinit var songsRecyclerView: RecyclerView
    var songsList: ArrayList<Songs> = arrayListOf()
    var length :Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        ivMusic = findViewById(R.id.ivMusic)
        ivNav = findViewById(R.id.ivNav)
        ivCall = findViewById(R.id.ivCall)
        ivHome = findViewById(R.id.ivHome)
        ivMeds = findViewById(R.id.ivMeds)
        ivCloud = findViewById(R.id.ivCloud)
        ivDrive = findViewById(R.id.ivDrive)
        seekBar = findViewById(R.id.seekBar)
        playBtn = findViewById(R.id.btnPlay)
        playerSide = findViewById(R.id.playerSide)
        playerImage = findViewById(R.id.playerImage)
        playerTitle = findViewById(R.id.playerTitle)
        playerLength = findViewById(R.id.playerLength)
        songsRecyclerView = findViewById(R.id.recycler_view_teamview_leads)
        setIconsColor()
        onBottomIconClicks()
        songsList = getSongs()
        songsRecyclerView.adapter = SongsAdapter(
            this, songsList, this
        )
        songsRecyclerView.layoutManager = LinearLayoutManager(this)
        playerSide.background.alpha = 100

    }

    private fun setIconsColor() {
        ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.white))
        ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
        ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))

    }
    private fun startProgress() {
        // Create a new Runnable that will update the SeekBar progress
        runnable = Runnable {
            progressSeek += 1
            seekBar.progress = progressSeek
            // Update the progress again after a delay of 500ms
            runnable?.let { handler.postDelayed(it, 500) }
        }
        // Start the progress update
        handler.postDelayed(runnable!!, 500)
    }
    private fun startCountdown(length: Long) {
        val countdown = object : CountDownTimer(length, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingSeconds = millisUntilFinished / 1000
                val minutes = remainingSeconds / 60
                val seconds = remainingSeconds % 60
                playerLength.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                playerLength.text = "00:00"
            }
        }

        countdown.start()
    }
    private fun onBottomIconClicks() {
        btnPlay.setOnClickListener{
            if(!isPlaying) {
                isPlaying = true
                playBtn.setImageResource(R.drawable.ic_baseline_pause_24)
                startProgress()
                startCountdown(length)
            }else{
                runnable?.let { it1 -> handler.removeCallbacks(it1) }
                playBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                isPlaying = false
            }
        }


        ivMusic.setOnClickListener{
            Toast.makeText(this, "Tapped on music", Toast.LENGTH_SHORT).show()
            ivMusic.setColorFilter(ContextCompat.getColor(this, R.color.white))
            ivNav.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCall.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivMeds.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivCloud.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
            ivDrive.setColorFilter(ContextCompat.getColor(this, R.color.iconTint))
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

    override fun onCardClick(song: Songs) {
        playerTitle.text = song.title
        playerImage.setImageResource(song.imageView!!)
        playerSide.setBackgroundResource(song.imageViewBg!!)
      //  playerSide.background.alpha = 100
        val timeInMillis: Long = length
        val timeSeconds = timeInMillis / 1000
        val minutes = timeSeconds / 60
        val seconds = timeSeconds % 60
        val timeString = String.format("%d:%02d", minutes, seconds)
        playerLength.text = timeString
        length = song.length!!
    }
    fun getSongs():ArrayList<Songs>{
        var songA = Songs("Alpha","Alpha singer", 60000L, R.drawable.p2, R.drawable.b2 )
        var songB = Songs("Beta","Beta singer", 55000L, R.drawable.p3, R.drawable.b3)
        var songC = Songs("Cipher","Cipher singer", 80000L, R.drawable.p5, R.drawable.b5)
        var songD = Songs("Delta","Delta singer", 90000L, R.drawable.p1, R.drawable.b1)
        var songE = Songs("Enrique","Enrique singer", 90000L, R.drawable.p4, R.drawable.b4)
        var songF = Songs("Falcon","Falcon singer", 10000L, R.drawable.p6, R.drawable.b6)
        var songsList: ArrayList<Songs> = arrayListOf()
        songsList.add(songA)
        songsList.add(songB)
        songsList.add(songC)
        songsList.add(songD)
        songsList.add(songE)
        songsList.add(songF)
        return songsList
    }
}