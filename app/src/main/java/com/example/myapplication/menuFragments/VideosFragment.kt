package com.example.myapplication.menuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.RecyclerViewAdapterForRetrofit
import com.example.myapplication.databinding.FragmentVideosBinding
import com.example.myapplication.models.PostListItem
import com.example.myapplication.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideosFragment : Fragment() {

    lateinit var binding : FragmentVideosBinding

    lateinit var adapter: RecyclerViewAdapterForRetrofit

    private val postList = mutableListOf<PostListItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideosBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecyclerViewAdapterForRetrofit(postList)
        binding.recyclerView.adapter = adapter
        fetchPosts()

    }
    fun fetchPosts() {
        RetrofitInstance.api.getPosts().enqueue(object :
            Callback<List<PostListItem>> {
            override fun onResponse(call: Call<List<PostListItem>>, response:
            Response<List<PostListItem>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null) {
                        postList.clear()
                        postList.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    println("Error: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<PostListItem>>, t: Throwable) {
                println("Failed to fetch posts: ${t.message}")
            }
        })

    }
    companion object {
        @JvmStatic
        fun newInstance() = VideosFragment()
    }
}