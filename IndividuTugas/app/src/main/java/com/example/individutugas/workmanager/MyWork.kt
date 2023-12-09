package com.example.individutugas.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import timber.log.Timber

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        try {
            Timber.d("Pekerjaan latar belakang sedang berjalan...")

            Thread.sleep(5000)

            Timber.d("Pekerjaan latar belakang selesai.")

            return Result.success()
        } catch (e: Exception) {

            Timber.e(e, "Terjadi kesalahan saat menjalankan pekerjaan latar belakang.")
            return Result.failure()
        }
    }
}
