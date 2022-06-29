package com.example.asd_ass5_shop.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asd_ass5_shop.adapters.MyCardRecycle
import com.example.asd_ass5_shop.databinding.FragmentMyCardBinding
import com.example.asd_ass5_shop.db.MyDataBase


class MyCardFragment : Fragment() {
    lateinit var binding: FragmentMyCardBinding

    lateinit var adapter: MyCardRecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCardBinding.inflate(layoutInflater)

        var productArray = MyDataBase(requireContext()).getAllProductInBag()
        //start Recycle Code
        binding.myProductRec.layoutManager = LinearLayoutManager(requireContext())
        adapter = MyCardRecycle(requireContext(), productArray)
        binding.myProductRec.adapter = adapter


        var itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    when (direction) {
                        ItemTouchHelper.LEFT -> {
                            adapter.deleteItem(
                                viewHolder.position,
                                productArray[viewHolder.position].id
                            )


                        }
                    }

                }
            }).attachToRecyclerView(binding.myProductRec)

        adapter.listen.observe(requireActivity(), object : Observer<Double> {
            override fun onChanged(t: Double?) {
                binding.totalPrice.text = t.toString()
            }
        })

        binding.totalPrice.setOnClickListener {

        }










        return binding.root
    }


}