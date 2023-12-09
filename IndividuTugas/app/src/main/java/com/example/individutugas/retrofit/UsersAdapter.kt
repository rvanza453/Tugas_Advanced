package com.example.individutugas.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.individutugas.R
import com.example.individutugas.databinding.ItemUserBinding

class UsersAdapter(var data: List<ResultUsersItem>) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    class MyHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: ResultUsersItem) {
            binding.nama.text = user.name
            binding.email.text = user.email
            binding.notelp.text = user.phone
            val address = "${user.address?.street}, ${user.address?.city}, ${user.address?.suite}, ${user.address?.zipcode}"
            binding.alamat.text = address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data[position])
    }
}
