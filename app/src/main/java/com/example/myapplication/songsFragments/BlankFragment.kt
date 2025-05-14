package com.example.myapplication.songsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.SongsRecyclerViewAdapter
import com.example.myapplication.databinding.FragmentBlankBinding
import com.example.myapplication.models.Song

class BlankFragment : Fragment() {

    lateinit var binding : FragmentBlankBinding
    lateinit var songsRVAdapter: SongsRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        songsRVAdapter = SongsRecyclerViewAdapter()
        songsRV.adapter = songsRVAdapter
        songsRV.layoutManager = LinearLayoutManager(requireContext())
        songsRVAdapter.submitList(listOf(
            Song("https://ichef.bbci.co.uk/ace/standard/976/cpsprodpb/4B19/production/_86352291_bohemianrhapsody.jpg","Bohemian Rhapsody","<Queen> 6:00"),
            Song("https://i.scdn.co/image/ab67616d0000b2731d856e66d33e22746c21a09c","Lose Control","<Teddy Swims> 3:30"),
            Song("https://upload.wikimedia.org/wikipedia/en/0/03/Corinne_Bailey_Rae_-_Put_Your_Records_On.png","Put Your Records On","<Corinne Bailey Rae> 3:34"),
            Song("https://upload.wikimedia.org/wikipedia/en/b/b6/The_official_cover_for_the_single_Chlorine.jpg","Chlorine","<twenty one pilots> 5:23"),
            Song("https://upload.wikimedia.org/wikipedia/en/d/d0/Catch-and-release-Matt-Simons-Deepend.jpg","Catch & Release","<Matt Simons> 3:16"),
            Song("https://i1.sndcdn.com/artworks-qkhnQAjp0sZH-0-t500x500.png","this is home","<unknown> 3:45"),
            Song("https://f4.bcbits.com/img/0008462194_25.jpg","Bedford Falls - COME.","<unknown> 4:02"),
            Song("https://i.ytimg.com/vi/psiILfa-G1c/hqdefault.jpg?sqp=-oaymwEmCOADEOgC8quKqQMa8AEB-AHUBoAC4AOKAgwIABABGGEgYShhMA8=&rs=AOn4CLAHIsTONfpgSazZentyZW61EsZFZQ","Daughter - \"Run\"","<unknown> 4:05")
        ))
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}