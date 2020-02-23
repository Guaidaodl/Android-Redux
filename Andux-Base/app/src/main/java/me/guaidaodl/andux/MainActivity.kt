package me.guaidaodl.andux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import me.guaidaodl.andux.counter.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.first_add).setOnClickListener {
            store.dispatch(FirstIncrement)
        }

        findViewById<View>(R.id.first_minus).setOnClickListener {
            store.dispatch(FirstDecrement)
        }

        findViewById<View>(R.id.second_add).setOnClickListener {
            store.dispatch(SecondIncrement)
        }

        findViewById<View>(R.id.second_minus).setOnClickListener {
            store.dispatch(SecondDecrement)
        }

        val firstNumberView: TextView = findViewById(R.id.first_number)
        store.observe(this, Observer {
            firstNumberView.text = "${it.firstNumber}"
        })

        val secondNumberView: TextView = findViewById(R.id.second_number)
        store.observe(this, Observer {
            secondNumberView.text = "${it.secondNumber}"
        })

        val sumView: TextView = findViewById(R.id.sum)
        store.observe(this, Observer {
            sumView.text = "${it.firstNumber + it.secondNumber}"
        })
    }
}
