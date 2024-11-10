package io.github.dropGame

import com.badlogic.gdx.Game
import io.github.dropGame.screens.MainMenu
import java.util.Random

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class Main : Game() {
    override fun create() {
        setScreen(MainMenu(this))
    }

    companion object{
        val WORLD_WIDTH = 16f
        val WORLD_HEIGHT = 9f
        var random : Random = Random()
    }
}
