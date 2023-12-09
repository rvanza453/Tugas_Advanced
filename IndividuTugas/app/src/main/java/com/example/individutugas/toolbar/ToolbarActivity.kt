package com.example.individutugas.toolbar

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.individutugas.R

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        editText = findViewById(R.id.editText)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_copy -> {
                copyText()
                return true
            }
            R.id.action_cut -> {
                cutText()
                return true
            }
            R.id.action_delete -> {
                deleteText()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun copyText() {
        val selectedText = editText.selectedText ?: ""
        if (selectedText.isNotEmpty()) {
            setClipboard(selectedText)
            showToast("Text copied")
        } else {
            showToast("No text selected")
        }
    }

    private fun cutText() {
        val selectedText = editText.selectedText ?: ""
        if (selectedText.isNotEmpty()) {
            setClipboard(selectedText)
            editText.text?.replace(editText.selectionStart, editText.selectionEnd, "")
            showToast("Text cut")
        } else {
            showToast("No text selected")
        }
    }

    private fun deleteText() {
        val selectedText = editText.selectedText ?: ""
        if (selectedText.isNotEmpty()) {
            editText.text?.replace(editText.selectionStart, editText.selectionEnd, "")
            showToast("Text deleted")
        } else {
            showToast("No text selected")
        }
    }

    private fun setClipboard(text: CharSequence) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private val EditText.selectedText: String
        get() {
            val start = selectionStart
            val end = selectionEnd
            return text.subSequence(start, end).toString()
        }
}
