package com.otakusenpai.whackamole.managers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.otakusenpai.whackamole.objects.Mole

class GameManager() {
    lateinit var moleList: MutableList<Mole>
    lateinit var moleTexture: Texture

    var moleVector: Vector2 = Vector2()

    val MOLE_RESIZE_FACOTR = 30f

    val mole_VERT_POS_FACTOR = 3f
    val mole1_HORI_POS_FACTOR = 5.8f
    val mole2_HORI_POS_FACTOR = 2.4f
    val mole3_HORI_POS_FACTOR = 1.5f

    constructor(width: Float, height: Float): this() {
        moleList = mutableListOf(Mole(),Mole(),Mole())

        moleTexture = Texture(Gdx.files.internal("mole.png"))

        moleList.get(0).position.set((width/mole1_HORI_POS_FACTOR),(height/mole_VERT_POS_FACTOR))
        println("Mole Position: Width is ${(width/mole1_HORI_POS_FACTOR)} n height is" +
                " ${(height/mole_VERT_POS_FACTOR)}")
        moleList.get(1).position.set((width/mole2_HORI_POS_FACTOR),(height/mole_VERT_POS_FACTOR))
        println("Mole Position: Width is ${(width/mole2_HORI_POS_FACTOR)} n height is " +
                "${(height/mole_VERT_POS_FACTOR)}")
        moleList.get(2).position.set((width/mole3_HORI_POS_FACTOR),(height/mole_VERT_POS_FACTOR))
        println("Mole Position: Width is ${(width/mole3_HORI_POS_FACTOR)} n height is " +
                "${(height/mole_VERT_POS_FACTOR)}")

        for(mole in moleList) {
            mole.moleSprite = Sprite(moleTexture)
            mole.width = mole.moleSprite.width * (width/MOLE_RESIZE_FACOTR)
            mole.height = mole.moleSprite.height * (height/MOLE_RESIZE_FACOTR)
            mole.moleSprite.setSize(mole.width,mole.height)
            mole.moleSprite.setPosition(mole.position.x,mole.position.y)
            println("Mole's widht is ${mole.width}")
            println("Mole's height is ${mole.height}")
        }
    }

    fun render(batch: SpriteBatch) {
        for(mole in moleList)
            mole.render(batch)
    }

    fun dispose() {
        moleTexture.dispose()
    }
}