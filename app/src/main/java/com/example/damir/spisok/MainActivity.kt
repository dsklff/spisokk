package com.example.damir.spisok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.damir.spisok.R.drawable.ic_account_circle_black_24dp
import com.example.damir.spisok.R.drawable.ic_add_white_24dp
import kotlinx.android.synthetic.main.actor_list.view.*

class MainActivity : AppCompatActivity() {

    lateinit var actors:ArrayList<Actor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actors = ArrayList()
        if(savedInstanceState != null){
            actors = savedInstanceState.getParcelableArrayList("actors")
        }

        val adapter = ListAdapter(actors)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        button_add_actor.setOnClickListener {
            actors.add(Actor("Johnny Depp", "Pirates of the Caribbean", ic_account_circle_black_24dp))
            adapter.notifyDataSetChanged()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putParcelableArrayList("actors",actors)
    }
}

