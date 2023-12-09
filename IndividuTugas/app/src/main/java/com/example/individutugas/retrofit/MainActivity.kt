package com.example.individutugas.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.individutugas.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.individutugas.retrofit.NetworkConfig
import com.example.individutugas.retrofit.ResultUsers
import com.example.individutugas.retrofit.UsersAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvUser = findViewById(R.id.rvUser) // Replace with your actual RecyclerView ID
        rvUser.layoutManager = LinearLayoutManager(this)

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<ResultUsers> {
                override fun onFailure(call: Call<ResultUsers>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResultUsers>, response: Response<ResultUsers>) {
                    if (response.isSuccessful) {
                        val resultUsers = response.body()
                        val users: List<ResultUsersItem> = resultUsers?.resultUsers.orEmpty().filterNotNull()
                        val usersAdapter = UsersAdapter(users)
                        rvUser.adapter = usersAdapter
                    } else {
                        Toast.makeText(this@MainActivity, "Request failed", Toast.LENGTH_SHORT).show()
                    }
                }
            })


    }
}
