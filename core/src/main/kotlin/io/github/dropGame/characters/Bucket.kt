package io.github.dropGame.characters

import com.badlogic.gdx.graphics.g2d.TextureRegion

class Bucket(
    xPosition: Float,
    yPosition: Float,
    width: Float,
    height: Float,
    characterTextureRegion: TextureRegion,
    speed: Float
) : Character(
    xPosition,
    yPosition,
    width,
    height,
    characterTextureRegion,
    speed,
) {
    override fun update(delta: Float) {

    }
}
