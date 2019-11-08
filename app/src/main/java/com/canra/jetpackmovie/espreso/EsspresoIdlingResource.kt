package com.canra.jetpackmovie.espreso

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EsspresoIdlingResource {
    private val RESOURCE = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    internal fun increment() {
        espressoTestIdlingResource.increment()
    }

    internal fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    internal fun getEspressoIdlingResourcey(): IdlingResource {
        return espressoTestIdlingResource
    }
}