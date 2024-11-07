package io.github.dropGame.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen

abstract class DropScreen(protected val mGame: Game) : Screen {
    override fun dispose() {
    }

    override fun show() {
    }

    override fun render(delta: Float) {
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }
}
