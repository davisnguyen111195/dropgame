package io.github.dropGame

import com.badlogic.gdx.Game
import io.github.dropGame.screens.MainMenu

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class Main : Game() {
    override fun create() {
        setScreen(MainMenu(this))
    }


}
