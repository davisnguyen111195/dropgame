package io.github.dropGame.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion

class GameScreen(game: Game) : DropScreen(game) {
    private lateinit var bucket: TextureRegion
    private lateinit var batch: SpriteBatch
    var time = 0f

    init {

    }

    override fun dispose() {
        super.dispose()
    }

    override fun show() {
        super.show()
        bucket = TextureRegion(Texture("bucket.png"))
        batch = SpriteBatch()
        batch.projectionMatrix.setToOrtho2D(
            0f, 0f,
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
        )
    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()

        batch.draw(bucket, 0f, 0f, bucket.regionWidth.toFloat(), bucket.regionHeight.toFloat())


        batch.end()
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
        Gdx.app.debug("Drop", "dispose intro");
        batch.dispose();
        bucket.getTexture().dispose();
    }
}
