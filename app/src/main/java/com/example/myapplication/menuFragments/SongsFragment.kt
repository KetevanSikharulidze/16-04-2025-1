package com.example.myapplication.menuFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.databinding.FragmentSongsBinding
import com.example.myapplication.songsFragments.BlankFragment
import com.example.myapplication.songsFragments.BlankFragment2
import com.google.android.material.tabs.TabLayoutMediator

class SongsFragment : Fragment() {

    private var _binding : FragmentSongsBinding? = null
    private val binding get() = _binding!!

    private val fList = listOf(
        BlankFragment(),
        BlankFragment2()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSongsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = ViewPagerAdapter(requireActivity(), fList)
        vp.adapter = viewPagerAdapter

        val tList = listOf(
            ContextCompat.getDrawable(requireContext(),R.drawable.ic_equalizer),
            ContextCompat.getDrawable(requireContext(),R.drawable.ic_forward_arrow)
        )

        TabLayoutMediator(tabLayout,vp) { tab, position ->
            tab.icon = tList[position]
        }.attach()

    }

    companion object {
        @JvmStatic
        fun newInstance() = SongsFragment()
    }
}