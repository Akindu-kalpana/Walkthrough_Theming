import java.util.Scanner

class WalkthroughStep(val message: String)

class WalkthroughManager {
    private val steps = mutableListOf<WalkthroughStep>()
    private var currentStepIndex = 0

    fun addStep(step: WalkthroughStep) {
        steps.add(step)
    }

    fun getCurrentStep(): WalkthroughStep? {
        return if (currentStepIndex < steps.size) {
            steps[currentStepIndex]
        } else {
            null
        }
    }

    fun moveToNextStep() {
        if (currentStepIndex < steps.size - 1) {
            currentStepIndex++
        }
    }

    fun moveToPreviousStep() {
        if (currentStepIndex > 0) {
            currentStepIndex--
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val walkthroughManager = WalkthroughManager()

    // Add walkthrough steps
    walkthroughManager.addStep(WalkthroughStep("Step 1: Navigate to settings menu"))
    walkthroughManager.addStep(WalkthroughStep("Step 2: Select theme option"))

    // Start walkthrough
    println("Welcome to Walkthrough Theming")
    var userInput: String
    var currentStep: WalkthroughStep?

    do {
        currentStep = walkthroughManager.getCurrentStep()

        if (currentStep != null) {
            println(currentStep.message)
            println("Press Enter to continue or type 'back' to go to the previous step:")
            userInput = scanner.nextLine()

            if (userInput.equals("back", ignoreCase = true)) {
                walkthroughManager.moveToPreviousStep()
            } else {
                walkthroughManager.moveToNextStep()
            }
        }
    } while (currentStep != null)

    println("Walkthrough completed. Thank you!")
}
