package vcmsa.ci.flashcard


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set layout to welcome screen
        setContentView(R.layout.activity_main)

        // Handle the Start button to launch the quiz
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // Start Flashcard Activity when user clicks Start
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
        }
    }
}

