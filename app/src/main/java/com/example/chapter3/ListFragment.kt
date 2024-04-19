package com.example.chapter3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.alphabetRecyclerView)
        val alphabet = ('A'..'Z').map { it.toString() }.toMutableList()

        val adapter = ListViewAdapter(alphabet) { item ->
            val bundle = Bundle().apply {
                putString("alphabet", item)
            }
            Log.d("SIMPLE_TAG", "INI LIST ${item.toString()}")
            val action = ListFragmentDirections.actionListFragmentToWordsListFragment(item)


            findNavController().navigate(action)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return view

    }


}