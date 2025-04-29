package com.example.oneid_pension_system

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ApplicationStatusActivity : AppCompatActivity() {

    private lateinit var iconList: List<ImageView>
    private val sharedPrefKey = "PensionStatusStage"
    private val notifiedKey = "NotifiedStage"
    private val totalStages = 4
    private val notificationRequestCode = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_status)

        val back = findViewById<TextView>(R.id.AS_btnBack)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
            finish()
        }

        createNotificationChannel()

        requestNotificationPermission()

        iconList = listOf(
            findViewById(R.id.step1Icon),
            findViewById(R.id.step2Icon),
            findViewById(R.id.step3Icon),
            findViewById(R.id.step4Icon)
        )

        val currentStage = getSavedStage()

        updateStageStatus(currentStage)

        iconList.forEachIndexed { index, imageView ->
            imageView.setOnLongClickListener {
                val nextStage = (index + 1).coerceAtMost(totalStages)
                saveStage(nextStage)
                updateStageStatus(nextStage)
                Toast.makeText(this, "Moved to stage $nextStage", Toast.LENGTH_SHORT).show()
                true
            }
        }

        // if (hasNotificationPermission()) {
        //     sendNotification("Test Notification", "This is a test!")
        // }
    }

    private fun updateStageStatus(stage: Int) {
        val completedIcon = R.drawable.greentick
        val sharedPref = getSharedPreferences("OneIDPrefs", Context.MODE_PRIVATE)
        val lastNotified = sharedPref.getInt(notifiedKey, 0)

        val messages = listOf(
            "Your application for the XYZ pension scheme has been submitted.",
            "Your documents for the XYZ pension are verified.",
            "Your application for the XYZ pension has been approved.",
            "Your pension has been successfully disbursed."
        )

        iconList.forEachIndexed { index, icon ->
            if (index < stage) {
                icon.setImageResource(completedIcon)

                if (index + 1 > lastNotified && hasNotificationPermission()) {
                    sendNotification("Pension Update", messages[index])
                    with(sharedPref.edit()) {
                        putInt(notifiedKey, index + 1)
                        apply()
                    }
                }
            }
        }
    }

    private fun saveStage(stage: Int) {
        val sharedPref = getSharedPreferences("OneIDPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt(sharedPrefKey, stage)
            apply()
        }
    }

    private fun getSavedStage(): Int {
        val sharedPref = getSharedPreferences("OneIDPrefs", Context.MODE_PRIVATE)
        return sharedPref.getInt(sharedPrefKey, 1)
    }

    private fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!hasNotificationPermission()) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    notificationRequestCode
                )
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "PensionChannel"
            val descriptionText = "Notifications for pension status updates"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("pension_channel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(title: String, message: String) {
        try {
            val intent = Intent(this, ApplicationStatusActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

            val pendingIntent: PendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val builder = NotificationCompat.Builder(this, "pension_channel")
                .setSmallIcon(R.drawable.greentick)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                notify((System.currentTimeMillis() % 10000).toInt(), builder.build())
            }
        } catch (e: SecurityException) {
            Toast.makeText(this, "Notification permission denied", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == notificationRequestCode) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "Notification permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notification permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
