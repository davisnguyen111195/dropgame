package io.github.dropGame.characters

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle

class Drop(
    xPosition: Float,
    yPosition: Float,
    width: Float,
    height: Float,
    characterTextureRegion: TextureRegion,
    speed : Float
) : Character(
    xPosition,
    yPosition,
    width,
    height,
    characterTextureRegion,
    speed
) {
    var mSpeed = speed
        get() = field
    private var mTimeLast = 0f
    override fun update(delta: Float) {

    }
}
