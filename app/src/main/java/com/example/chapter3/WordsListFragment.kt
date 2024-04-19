package com.example.chapter3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordsListFragment : Fragment() {
    private val args: WordsListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_words_list, container, false)
        Log.d("SIMPLE_TAG", "data ${args.arg}")
        val words = when (args.arg) {
            "A" -> listOf("Ayam", "Anjing")
            "B" -> listOf("Babi", "Beruang")
            "C" -> listOf("Cacing", "Cicak")
            "D" -> listOf("Domba", "Dinosaurus")
            "E" -> listOf("Elang", "Ekor")
            "F" -> listOf("Ferret", "Flamingo")
            "G" -> listOf("Gajah", "Gorila")
            "H" -> listOf("Harimau", "Hippopotamus")
            "I" -> listOf("Ikan", "Iguana")
            "J" -> listOf("Jerapah", "Jangkrik")
            "K" -> listOf("Kucing", "Kanguru")
            "L" -> listOf("Lebah", "Landak")
            "M" -> listOf("Monyet", "Marmut")
            "N" -> listOf("Naga", "Nyamuk")
            "O" -> listOf("Orangutan", "Ostrich")
            "P" -> listOf("Panda", "Penguin")
            "Q" -> listOf("Quail", "Quokka")
            "R" -> listOf("Rusa", "Rubah")
            "S" -> listOf("Singa", "Sapi")
            "T" -> listOf("Tikus", "Tupai")
            "U" -> listOf("Ular", "Udang")
            "V" -> listOf("Vampire bat", "Vicuna")
            "W" -> listOf("Walrus", "Wombat")
            "X" -> listOf("Xerus", "X-ray tetra")
            "Y" -> listOf("Yak", "Yaki")
            "Z" -> listOf("Zebra", "Zebu")

            else -> emptyList()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.wordsRecyclerView)
        val adapter = ListViewAdapter(words) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/search?q=$it"))
            activity?.startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)



        return view
    }
}
