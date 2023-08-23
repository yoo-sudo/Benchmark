package com.example.macrobenchmark.baseline

import androidx.benchmark.macro.MacrobenchmarkScope
import com.example.macrobenchmark.util.scrollComposeList

class ComposeListBaselineGenerator : BaselineGenerator() {

    override fun MacrobenchmarkScope.profileBlock() {
        scrollComposeList(this)
    }
}