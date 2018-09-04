package com.otakusenpai.whackamole

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.otakusenpai.whackamole.managers.GameManager

class WhackaMole() : ApplicationAdapter() {
    internal lateinit var batch: SpriteBatch
    lateinit var gameManager: GameManager

    lateinit var camera: OrthographicCamera

    var width = 0f
    var height = 0f

    override fun create() {
        batch = SpriteBatch()
        width = Gdx.graphics.width.toFloat()
        height = Gdx.graphics.height.toFloat()
        camera = OrthographicCamera(width,height)
        camera.setToOrtho(false)
        gameManager = GameManager(width,height)
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined

        batch.begin()
        gameManager.render(batch)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        gameManager.dispose()
    }
}