package io.github.dropGame.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.StretchViewport
import io.github.dropGame.Main.Companion.WORLD_HEIGHT
import io.github.dropGame.Main.Companion.WORLD_WIDTH
import io.github.dropGame.Main.Companion.random
import io.github.dropGame.characters.Bucket
import io.github.dropGame.characters.Drop
import java.util.LinkedList

class GameScreen(game: Game) : DropScreen(game) {

    private lateinit var batch: SpriteBatch
    private lateinit var camera: OrthographicCamera
    private lateinit var viewPort: StretchViewport
    var time = 0f
    private lateinit var bucket: Bucket
    private lateinit var bucketTextureRegion: TextureRegion

    private lateinit var dropTextureRegion: TextureRegion

    private var dropSpawnTimer = 0f
    private var timeBetweenDropSpawn = 0.5f

    private lateinit var drops: LinkedList<Drop>

    private lateinit var pos : Vector2
    override fun dispose() {
        super.dispose()
    }

    override fun show() {
        super.show()
        camera = OrthographicCamera()
        viewPort = StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)

        bucketTextureRegion = TextureRegion(Texture("bucket.png"))




        dropTextureRegion = TextureRegion(Texture("drop.png"))
        //drop = Drop(2f, 2f, 1f, 1f, dropTextureRegion, speedDrop)

        drops = LinkedList()

        batch = SpriteBatch()
        batch.projectionMatrix.setToOrtho2D(
            0f, 0f,
            WORLD_WIDTH,
            WORLD_HEIGHT
        )

    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        spawnDrop(delta)
        input()
        bucket = Bucket(pos.x, pos.y, 1f, 1f, bucketTextureRegion, 2f)

        batch.begin()

        bucket.draw(batch)
        detectCollisions()
        val dropListIterator = drops.listIterator()
        while (dropListIterator.hasNext()) {
            val drop = dropListIterator.next()
            if (drop.mBoundingBox.y < 0) {
                dropListIterator.remove()
            } else {
                moveDrop(drop, delta)
                drop.update(delta)
                drop.draw(batch)
            }
        }

        batch.end()
    }
    private fun input() {
        if(Gdx.input.isTouched) {

            val x = Gdx.input.x.toFloat()
            val y = Gdx.input.y.toFloat()
            pos = Vector2(x, y)
            println("${pos.x} / ${pos.y}")

            pos = viewPort.unproject(pos)
            println("${pos.x} / ${pos.y}")
        }
    }

    fun moveDrop(drop: Drop, delta: Float) {
        var yNew = drop.mBoundingBox.y
        if (drop.mBoundingBox.y > 0) {
            yNew = (drop.mBoundingBox.y - drop.mSpeed)

        }
        drop.translate(drop.mBoundingBox.x, yNew)
    }

    private fun spawnDrop(delta: Float) {
        dropSpawnTimer += delta
        if (dropSpawnTimer > timeBetweenDropSpawn) {
            dropSpawnTimer = 0f
            drops.add(
                Drop(
                    MathUtils.random(0f, WORLD_WIDTH - 1),
                    WORLD_HEIGHT - 1,
                    1f,
                    1f,
                    dropTextureRegion,
                    MathUtils.random(0.05f, 0.1f)
                )
            )

        }

    }
    fun detectCollisions() {
        val dropListIterator = drops.listIterator()
        while (dropListIterator.hasNext()){
            val drop = dropListIterator.next()
            if(drop.intersects(bucket.mBoundingBox)) {
                dropListIterator.remove()
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
        Gdx.app.debug("Drop", "dispose intro");
        batch.dispose();
        bucketTextureRegion.texture.dispose();
        dropTextureRegion.texture.dispose()
    }
}
