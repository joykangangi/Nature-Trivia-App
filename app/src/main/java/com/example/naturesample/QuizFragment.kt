package com.example.naturesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.naturesample.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (or better yet, not define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "Where are you likely to see the wildebeest migration?",
            answers = listOf("Kenya", "Italy", "Germany", "Paris")),
        Question(text = "Where is Matira Beach found?",
            answers = listOf("Bora Bora", "Kerugoya", "Spain", "Hawaii")),
        Question(text = "Where is the largest amphitheatre located?",
            answers = listOf("Italy", "Egypt", "South Africa", "USA")),
        Question(text = "Home for famous artworks?",
            answers = listOf("Paris", "Israel", "Costa Rica", "Bali")),
        Question(text = "Place that will suite a zoologist?",
            answers = listOf("Bali", "Guatemala", "Indonesia", "Bora Bora"))   )

     lateinit var currentQuestion: Question
   lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = ((questions.size + 1) / 2/3/4/5)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game=this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener  @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController().navigate(R.id.action_quizFragment_to_gameWonFragment)
                        // We've won!  Navigate to the gameWonFragment.
                    }
                } else {
                    view.findNavController().navigate(R.id.action_quizFragment_to_gameOverFragment2)
                    // Game over! A wrong answer sends us to the gameOverFragment.
                }
            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }
    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentQuizBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_nature_trivia_question,questionIndex + 1, numQuestions)
    }
}