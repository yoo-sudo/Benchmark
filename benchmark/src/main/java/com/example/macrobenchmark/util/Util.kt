package com.example.macrobenchmark.util

import android.content.Intent
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until

const val TARGET_PACKAGE = "com.sample.benchmark"

fun scrollComposeList(macrobenchmarkScope: MacrobenchmarkScope) {
    macrobenchmarkScope.apply {
        startActivityAndWait(Intent().setAction("$TARGET_PACKAGE.ui.ComposeListViewActivity"))
        device.wait(Until.hasObject(By.scrollable(true)), 5_000)

        with(device) {
            findObject(By.res("myLazyColumn")).also {
                it.setGestureMargin(device.displayWidth / 10)
                it.fling(Direction.DOWN)
                it.fling(Direction.UP)
            }
        }
    }
}

fun scrollRecyclerView(macrobenchmarkScope: MacrobenchmarkScope) {
    macrobenchmarkScope.apply {
        startActivityAndWait(Intent().setAction("$TARGET_PACKAGE.ui.RecyclerViewActivity"))
        device.wait(Until.hasObject(By.scrollable(true)), 5_000)

        with(device) {
            findObject(By.res(packageName, "recycler")).also {
                it.setGestureMargin(device.displayWidth / 10)
                it.fling(Direction.DOWN)
                it.fling(Direction.UP)
            }
        }
    }
}