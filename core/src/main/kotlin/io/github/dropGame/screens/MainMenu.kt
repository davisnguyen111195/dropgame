package io.github.dropGame.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.dropGame.Main.Companion.WORLD_HEIGHT
import io.github.dropGame.Main.Companion.WORLD_WIDTH

class MainMenu(game: Game) : DropScreen(game) {
    private lateinit var background: TextureRegion
    private lateinit var batch: SpriteBatch
    private lateinit var viewPort : StretchViewport
    private lateinit var camera : OrthographicCamera

    var time = 0f

    override fun dispose() {
        super.dispose()

    }

    override fun show() {
        super.show()
        camera = OrthographicCamera()
        viewPort = StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)

        background = TextureRegion(Texture("background.png"))
        batch = SpriteBatch()
        batch.projectionMatrix.setToOrtho2D(
            0f,
            0f,
            WORLD_WIDTH,
            WORLD_HEIGHT
        )
    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()

        batch.draw(background, 0f, 0f, WORLD_WIDTH, WORLD_HEIGHT)

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
        viewPort.update(width, height, true)
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
