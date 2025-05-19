package vcmsa.ci.flashcard


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The Great Wall of China is visible from South Africa",
        "The moon is not a planet",
        "Apartheid ended in 1990",
        "Huma beings were first discovered in Europe"
    )

    private val answers = arrayOf(true, false, false, true, true)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        val questionText: TextView = findViewById(R.id.questionText)
        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)
        val nextButton: Button = findViewById(R.id.nextButton)


        questionText.text = questions[currentQuestionIndex]

        trueButton.setOnClickListener {
            checkAnswer(true, feedbackText)
        }

        falseButton.setOnClickListener {
            checkAnswer(false, feedbackText)
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                // Load the next question
                questionText.text = questions[currentQuestionIndex]
                feedbackText.text = ""
            } else {
                // If all questions are answered, go to the score screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    // Function to check user's answer and update score
    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect!"
        }
    }
}
