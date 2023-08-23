package com.example.macrobenchmark.baseline

import androidx.benchmark.macro.MacrobenchmarkScope

class StartupBaselineGenerator : BaselineGenerator() {

    override fun MacrobenchmarkScope.profileBlock() {
        startActivityAndWait()
    }
}