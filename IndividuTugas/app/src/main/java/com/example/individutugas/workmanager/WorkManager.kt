package com.example.individutugas.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkInfo
import com.example.individutugas.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        Timber.plant(Timber.DebugTree())

        val workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .build()

        WorkManager.getInstance(applicationContext).enqueue(workRequest)

        Timber.d("Pekerjaan telah dijadwalkan...")

        val workInfoLiveData = WorkManager.getInstance(applicationContext)
            .getWorkInfoByIdLiveData(workRequest.id)

        workInfoLiveData.observe(this, { workInfo ->
            if (workInfo != null) {
                when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> Timber.d("Pekerjaan selesai dengan sukses.")
                    WorkInfo.State.FAILED -> Timber.e("Pekerjaan gagal.")
                    WorkInfo.State.CANCELLED -> Timber.w("Pekerjaan dibatalkan.")
                    else -> Timber.d("Status pekerjaan: ${workInfo.state}")
                }
            }
        })
    }
}
