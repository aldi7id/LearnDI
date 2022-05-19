package com.ajgroup.learndi.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ajgroup.learndi.MoviesAdapter
import com.ajgroup.learndi.R
import com.ajgroup.learndi.data.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val progressDialog = ProgressDialog(this)
        viewModel.movies.observe(this){ resource ->
            when (resource.status) {
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }
                Status.SUCCESS -> {
                    resource.data?.movies?.let {
                        val adapter = MoviesAdapter(it)
                        recyclerView.adapter = adapter
                    }
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error get Data : ${resource.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }


        }
        viewModel.getAllPopularMovies()
    }
}