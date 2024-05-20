# Mobile Automation Challenge

## Prerequisites
- Java 11
- Appium 2
- Android Emulator or Physical Device

## Setup
1. Clone the repository:
    ```bash
    git clone <repo_link>
    cd MobileAutomation
    ```

2. Install dependencies:
    ```bash
    ./gradlew build
    ```

3. Start Appium server:
    ```bash
    appium
    ```

4. Run tests:
    ```bash
    ./gradlew test
    ```

## Test Description
This project contains automated tests for theScore mobile app. It performs the following steps:
1. Opens a league page.
2. Verifies the page opens correctly.
3. Taps on the standings tab.
4. Verifies the standings tab and data.
5. Navigates back to the previous page.

## Rationale
The test approach focuses on ensuring that key navigational and data display functionalities work correctly. This is crucial for user experience as it validates the main features of the app.

## Coverage Assessment
The tests cover the basic navigation and data validation for league pages. Future tests can include more granular checks for different leagues, teams, and players.
