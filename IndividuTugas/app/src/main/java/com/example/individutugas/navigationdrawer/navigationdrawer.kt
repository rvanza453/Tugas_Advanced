package com.example.individutugas.navigationdrawer

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Images.ImageColumns
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.individutugas.R
import com.example.individutugas.toolbar.MainActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var btnOpenDrawer: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationdrawer)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        btnOpenDrawer = findViewById<ImageButton>(R.id.btnOpenDrawer)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.toolbar -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.toolbar.MainActivity::class.java
                        )
                    )
                    true
                }

                R.id.recyclerView -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.recyclerview.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.alarmManager -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.alarmmanager.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.animation -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.animation.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.bottomNavigation -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.bottomnavigation.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.brainTrainer -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.braintrainerapp.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.retrofit -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.retrofit.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.sharedPreference -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.sharedpreference.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.tabLayout -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.tablayout.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.viewModel -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.viewmodel.MainActivity::class.java
                        )
                    )
                    true
                }
                R.id.workManager -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            com.example.individutugas.workmanager.MainActivity::class.java
                        )
                    )
                    true
                }
                else -> false
            }
        }
        btnOpenDrawer.setOnClickListener()
        {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView)
            } else {
                drawerLayout.openDrawer(navigationView)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}