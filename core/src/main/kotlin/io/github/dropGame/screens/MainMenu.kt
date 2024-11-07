package io.github.dropGame.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion

class MainMenu(game: Game) : DropScreen(game) {
    private lateinit var background: TextureRegion
    private lateinit var batch: SpriteBatch
    var time = 0f

    override fun dispose() {
        super.dispose()

    }

    override fun show() {
        super.show()
        background = TextureRegion(Texture("background.png"))
        batch = SpriteBatch()
        batch.projectionMatrix.setToOrtho2D(
            0f,
            0f,
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
        )
    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()

        batch.draw(background, 0f, 0f)

        batch.end()

        time += delta
        if(time > 1){
            if(Gdx.input.justTouched() || Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
                mGame.screen = GameScreen(mGame)
            }
        }
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
    }

    override fun pause() {
        super.pause()
    }

    override fun resume() {
        super.resume()
    }

    override fun hide() {
        super.hide()
        Gdx.app.debug("Drop", "Dispose main menu")
        batch.dispose()
        background.texture.dispose()
    }
}
