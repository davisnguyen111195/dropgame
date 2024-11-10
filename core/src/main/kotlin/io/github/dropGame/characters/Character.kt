package io.github.dropGame.characters

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle

abstract class Character(
    xPosition: Float,
    yPosition: Float,
    width: Float,
    height: Float,

    characterTextureRegion: TextureRegion,
    speed: Float
) {
    val mBoundingBox: Rectangle =
        Rectangle(xPosition, yPosition, width, height)

    val mCharacterTextureRegion = characterTextureRegion

    fun intersects(otherRectangle: Rectangle): Boolean {
        return mBoundingBox.overlaps(otherRectangle)
    }

    abstract fun update(delta: Float)


    fun draw(batch: Batch) {
        batch.draw(
            mCharacterTextureRegion,
            mBoundingBox.x,
            mBoundingBox.y,
            mBoundingBox.width,
            mBoundingBox.height
        )
    }

    fun translate(xChange: Float, yChange: Float){
        mBoundingBox.setPosition(xChange, yChange)
    }
}
