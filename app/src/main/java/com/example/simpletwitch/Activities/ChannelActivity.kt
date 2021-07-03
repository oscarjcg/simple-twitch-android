package com.example.simpletwitch.Activities

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletwitch.Adapters.ChatAdapter
import com.example.simpletwitch.Models.Comment
import com.example.simpletwitch.R
import com.example.simpletwitch.ViewModels.ChannelViewModel
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONObject


const val CHANNEL_ID = "CHANNEL_ID"
const val CHAT_SOCKET = "http://st-node.oscarcatarigutierrez.com:3000"

class ChannelActivity : AppCompatActivity() {

    //private lateinit var webView: WebView
    private lateinit var chatRv: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var mSocket: Socket;
    private lateinit var totalConnections: TextView
    private lateinit var comment: EditText

    private var channelId: Int = 0

    private val model: ChannelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_channel)

        init()


        // Init chat list
        val comments = ArrayList<Comment>()
        chatAdapter = ChatAdapter(comments, this)
        chatRv.layoutManager = LinearLayoutManager(this)
        chatRv.adapter = chatAdapter

        // Get chat list
        val channelId = intent.getIntExtra(CHANNEL_ID, 0)
        model.comments.observe(this, Observer<List<Comment>> { comments ->
            chatAdapter = ChatAdapter(ArrayList(comments), this)
            chatRv.adapter = chatAdapter
        })
        model.getChat(channelId)
        model.channelId = channelId

        comment.setOnKeyListener { v, keyCode, event ->

            when {
                ((keyCode == KeyEvent.KEYCODE_ENTER) && (event.action == KeyEvent.ACTION_DOWN)) -> {
                    model.createComment("android", model.channelId, comment.text.toString())
                    comment.setText("")
                    return@setOnKeyListener true
                }
                else -> false
            }
        }



        //webView.loadUrl("https://models3d.oscarcatarigutierrez.com/")

        // Chat socket
        try {
            mSocket = IO.socket(CHAT_SOCKET)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mSocket.connect()

        mSocket.on("totalConnections", onTotalConnections)
        mSocket.on("newMessage", onNewMessage)

    }

    var onTotalConnections = Emitter.Listener {
        val total = it[0] as Int
        totalConnections.text = total.toString()
    }

    var onNewMessage = Emitter.Listener {
        val json = it[0] as JSONObject
        if (model.channelId == json.getInt("channel_id"))
            model.getChat(json.getInt("channel_id"))
    }


    private fun init() {
        //webView = findViewById(R.id.webView)
        chatRv = findViewById(R.id.chat)
        totalConnections = findViewById(R.id.totalConnections)
        comment = findViewById(R.id.comment)

        /*
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess= true
        webView.settings.allowContentAccess= true
        webView.settings.allowFileAccessFromFileURLs = true
        webView.settings.allowUniversalAccessFromFileURLs = true
        webView.settings.pluginState = WebSettings.PluginState.ON

         */

    }

    override fun onDestroy() {
        super.onDestroy()

        mSocket.disconnect()
    }
}