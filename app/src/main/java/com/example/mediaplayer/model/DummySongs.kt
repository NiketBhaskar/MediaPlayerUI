package com.example.mediaplayer.model

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import com.example.mediaplayer.R

class DummySongs: AppCompatActivity() {
    fun getSongs():ArrayList<Songs>{
        var songA = Songs("Alpha","Alpha singer", 60000L, resources.getIdentifier("ic_p1_background", "drawable", packageName) )
        var songB = Songs("Beta","Beta singer", 55000L, resources.getIdentifier("ic_p6_background", "drawable", packageName))
        var songC = Songs("Cipher","Cipher singer", 80000L, resources.getIdentifier("ic_p2_background", "drawable", packageName))
        var songD = Songs("Delta","Delta singer", 90000L, R.drawable.ic_p5_background)
        var songE = Songs("Enrique","Enrique singer", 90000L, R.drawable.ic_p3_background)
        var songF = Songs("Falcon","Falcon singer", 10000L, R.drawable.ic_p4_background)
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