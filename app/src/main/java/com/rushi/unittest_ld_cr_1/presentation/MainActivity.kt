package com.rushi.unittest_ld_cr_1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.rushi.unittest_ld_cr_1.R
import com.rushi.unittest_ld_cr_1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var _activityMainBinding: ActivityMainBinding? = null
    val activityMainBinding: ActivityMainBinding
        get() = _activityMainBinding!!

    val mainViewModel : MainViewModel by viewModels()
    val adapter1 = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initViews()
        subscribeObservers()
    }

    fun initViews(){
        activityMainBinding.mainRV.apply {
            adapter = adapter1
            setHasFixedSize(true)
        }
    }

    fun subscribeObservers(){
        mainViewModel.also {
            it.channelLiveData.observe(this){
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }

            it.postsLiveData.observe(this){
                adapter1.submitList(it)
            }
        }
    }
}