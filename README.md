# Life Hack or Urban Myth? - Android App

## Purpose
This application is a flashcard-style game designed to help users distinguish between genuine productivity life hacks and viral internet urban myths. It tests common sense while providing safe, real-world shortcuts.

## Design Considerations
*   **UI/UX:** The app uses a simple, high-contrast, 3-screen flow (Welcome -> Quiz -> Score) to ensure ease of use.
*   **Feedback:** Immediate visual feedback is provided via Toasts upon answering.
*   **Review System:** A dialog on the score screen allows users to review all questions and their explanations to reinforce learning.
*   **Logging:** Extensive `Log.d` and `Log.i` statements are used throughout the activities to track user flow and state changes for debugging purposes.

## Technical Implementation
*   Built using **Kotlin** in Android Studio.
*   Utilizes `Intent` and `putExtra` for state management and data passing between activities.
*   Uses a data class `Question` to model the flashcards.

## GitHub and GitHub Actions
*   **Version Control:** The project is managed via GitHub. Commits are made regularly to track progress.
*   **CI/CD:** GitHub Actions is utilized to automate the build process. Every push to the `main` branch triggers a workflow to compile the app and run automated tests, ensuring the code is always in a buildable state.

## Video Presentation
[INSERT YOUR YOUTUBE UNLISTED LINK HERE]

## App Screenshots
*(Add screenshots here from your emulator)*
