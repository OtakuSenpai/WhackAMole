package com.otakusenpai.whackamole.objects

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

open class Mole() {
    lateinit var moleSprite: Sprite
    var position: Vector2 = Vector2()
    var width = 0.0f
    var height = 0.0f

    fun render(batch: SpriteBatch) {
        moleSprite.draw(batch)
    }
}