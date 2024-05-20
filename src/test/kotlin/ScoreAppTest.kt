package com.thescore

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class ScoreAppTest {

    companion object {
        private lateinit var driver: AppiumDriver<MobileElement>

        @BeforeAll
        @JvmStatic
        fun setUp() {
            val capabilities = DesiredCapabilities()
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0")
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
            capabilities.setCapability(MobileCapabilityType.APP, "/path/to/thescore.apk") // Replace with actual path to the APK
            driver = AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), capabilities)
        }

        @AfterAll
        @JvmStatic
        fun tearDown() {
            driver.quit()
        }
    }

    @Test
    fun testOpenLeaguePage() {
        // Open league page
        val leagueButton = driver.findElementByAccessibilityId("league_button_id")
        leagueButton.click()

        // Verify the league page opens
        val leagueTitle = driver.findElementById("league_title_id")
        assert(leagueTitle.text.contains("League"))

        // Tap on a sub-tab
        val standingsTab = driver.findElementByAccessibilityId("standings_tab_id")
        standingsTab.click()

        // Verify the correct tab and data
        val standingsTitle = driver.findElementById("standings_title_id")
        assert(standingsTitle.text.contains("Standings"))

        // Back navigation
        driver.navigate().back()
        val homeTitle = driver.findElementById("home_title_id")
        assert(homeTitle.text.contains("Home"))
    }

    @Test
    fun testSearchFunctionality() {
        // Open search page
        val searchButton = driver.findElementByAccessibilityId("search_button_id")
        searchButton.click()

        // Perform a search
        val searchInput = driver.findElementById("search_input_id")
        searchInput.sendKeys("team name")
        val searchResult = driver.findElementByAccessibilityId("search_result_id")
        searchResult.click()

        // Verify search result page opens
        val resultTitle = driver.findElementById("result_title_id")
        assert(resultTitle.text.contains("team name"))
    }

    @Test
    fun testNavigateToTeamPage() {
        // Open teams section
        val teamsButton = driver.findElementByAccessibilityId("teams_button_id")
        teamsButton.click()

        // Select a team
        val teamItem = driver.findElementByAccessibilityId("team_item_id")
        teamItem.click()

        // Verify team page opens
        val teamTitle = driver.findElementById("team_title_id")
        assert(teamTitle.text.contains("Team Name"))
    }

    @Test
    fun testPlayerStatistics() {
        // Open player statistics page
        val playerStatsButton = driver.findElementByAccessibilityId("player_stats_button_id")
        playerStatsButton.click()

        // Verify player statistics page opens
        val statsTitle = driver.findElementById("stats_title_id")
        assert(statsTitle.text.contains("Player Statistics"))

        // Verify specific statistic is displayed
        val playerStat = driver.findElementById("player_stat_id")
        assert(playerStat.text.contains("Statistic Value"))
    }
}
