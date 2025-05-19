package vcmsa.ci.flashcard


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText: TextView = findViewById(R.id.scoreText)
        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val reviewButton: Button = findViewById(R.id.reviewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        val score = intent.getIntExtra("score", 0)
        
        scoreText.text = "You scored $score out of 5"
        
        feedbackText.text = when (score) {
            5 -> "Excellent!"
            in 3..4 -> "Good job!"
            in 1..2 -> "Keep practicing!"
            else -> "Better luck next time!"
        }
        
        exitButton.setOnClickListener {
            finishAffinity()
        }
        
        reviewButton.setOnClickListener {
        }
    }
}
