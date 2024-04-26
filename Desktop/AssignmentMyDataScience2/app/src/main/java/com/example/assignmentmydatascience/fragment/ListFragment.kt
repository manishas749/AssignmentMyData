package com.example.assignmentmydatascience.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentmydatascience.adapter.ItemAddAdapter
import com.example.assignmentmydatascience.data.SaveData
import com.example.assignmentmydatascience.data.SaveDataItem
import com.example.assignmentmydatascience.databinding.FragmentListBinding
import com.example.assignmentmydatascience.paging.ItemPagingAdapter
import com.example.assignmentmydatascience.viewModel.GetDataViewModel
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: GetDataViewModel
    private lateinit var list:MutableList<SaveDataItem>
    lateinit var adapter:ItemAddAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[GetDataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = mutableListOf()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)



        viewModel.getResponseData()
        viewModel.responseData.observe(viewLifecycleOwner)
        {call->
            call?.enqueue(object :
                Callback<SaveData> {
                override fun onResponse(
                    call: Call<SaveData>,
                    response: Response<SaveData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("msdmsjdkdkjk", "onResponse: "+response.body())
                        for (i in 0 until response.body()!!.size) {
                            list.add(response.body()!![i])
                        }
                        adapter = ItemAddAdapter(requireContext(),list)
                        binding.recyclerView.adapter = adapter


                    } else {
                        Toast.makeText(context, response.code().toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<SaveData>, t: Throwable) {

                }

            })
        }

    }


}