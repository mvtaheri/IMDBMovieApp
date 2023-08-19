package com.mohammad.imdbmovieapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammad.imdbmovieapp.databinding.ActivityMainBinding
import com.mohammad.imdbmovieapp.presentation.ViewModel
import com.mohammad.imdbmovieapp.presentation.ViewModelFactory
import com.mohammad.imdbmovieapp.presentation.di.Injector
import com.mohammad.movieapp.presentation.MovieAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var viewModel: ViewModel
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // assigning ID of the toolbar to a variable
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        // using toolbar as ActionBar
        setSupportActionBar(toolbar)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory)
            .get(ViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularMovie()
    }

    private fun displayPopularMovie() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility = View.GONE
            } else {
                binding.movieProgressbar.visibility = View.GONE
                Toast.makeText(applicationContext, "THERE IS NO DATA", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val responseLivedata = viewModel.updateMovies()
        responseLivedata.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility = View.GONE
            } else {
                binding.movieProgressbar.visibility = View.GONE
            }
        })
    }

}