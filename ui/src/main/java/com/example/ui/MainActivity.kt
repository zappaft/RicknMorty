package com.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cafe.adriel.dalek.*
import com.example.domain.models.Character
import com.example.ui.adapters.CharacterListItem
import com.example.ui.databinding.ActivityMainBinding
import com.example.ui.viewmodels.MainActivityViewModel
import com.xwray.groupie.GroupieAdapter
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance


class MainActivity: AppCompatActivity(), DIAware {

    private lateinit var binding: ActivityMainBinding
    override val di by closestDI()
    private val viewModel by instance<MainActivityViewModel>()
    private val adapter = GroupieAdapter()
    private val scrollListener: RecyclerView.OnScrollListener by lazy {
        object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = binding.characterList.layoutManager as LinearLayoutManager
                if(manager.findLastVisibleItemPosition() == adapter.groupCount - 1) {
                    loadList()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setup()
    }

    private fun ActivityMainBinding.setup() {
        characterList.adapter = adapter
        loadList()
        characterList.addOnScrollListener(scrollListener)
    }

    private fun loadList(){
        viewModel.getCharacters().collectIn(lifecycleScope) { event ->
            when(event) {
                is Start -> setLoading(true)
                is Success -> addCharacters(event.value)
                is Failure -> showError(event.exception)
                is Finish -> setLoading(false)
            }
        }
    }

    private fun addCharacters(characters: List<Character>) {
        if(characters.isNotEmpty()) adapter.addAll(characters.map{ CharacterListItem(it) })
    }

    private fun setLoading(showAsLoading: Boolean){
        if(showAsLoading) {
            println("loading data")
            binding.characterList.removeOnScrollListener(scrollListener)
        } else {
            println("done loading")
            binding.characterList.addOnScrollListener(scrollListener)
        }
    }

    private fun showError(exception: Throwable) {
        println("CARAMBOLAS")
        println(exception)
    }
}