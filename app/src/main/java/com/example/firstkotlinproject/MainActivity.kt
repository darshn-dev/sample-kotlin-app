package com.example.firstkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firstkotlinproject.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONArray
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val URL: String = "https://jsonplaceholder.typicode.com/todos/"
    var binding:ActivityMainBinding?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_main)

        initUI(binding)


    }


    private fun initUI(binding: com.example.firstkotlinproject.databinding.ActivityMainBinding?) {

        binding!!.rvTodoList.layoutManager = LinearLayoutManager(this)
        var toDo: ArrayList<ToDo> = ArrayList<ToDo>()
        val adapter: RvAdapter = RvAdapter(todo = toDo, context = this)
        binding.rvTodoList.adapter = adapter
        getData()


    }


    private fun getData() {
        val response =  StringRequest(Request.Method.GET,URL, Response.Listener { response ->

            val gson = Gson()
            var jsonData : List<ToDo> = gson.fromJson(response,Array<ToDo>::class.java).toList()
            Log.d("Main","I think i got data")


            val adapter:RvAdapter= RvAdapter(todo = jsonData,context = this)
            binding!!.rvTodoList.adapter=adapter


          }, Response.ErrorListener {

                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                Log.d("Main",it.message)
        })

        Volley.newRequestQueue(this).add(response)

    }








//
//    val response = object : StringRequest(Request.Method.GET, URL, Response.Listener { response ->
//        try {
//            val gson = Gson()
//            var jsonData = gson.toJson(response)
//
//        } catch (e: Exception) {
//
//        }
//    }, Response.ErrorListener {
//
//        Toast.makeText(this,"Not found",Toast.LENGTH_LONG).show()
//    })
//
//    Volley.newRequestQueue(this).add(response)

}
