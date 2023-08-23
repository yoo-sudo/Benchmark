package com.example.macrobenchmark.baseline

import androidx.benchmark.macro.MacrobenchmarkScope
import com.example.macrobenchmark.util.scrollRecyclerView

class RecyclerViewBaselineGenerator : BaselineGenerator() {

    override fun MacrobenchmarkScope.profileBlock() {
       scrollRecyclerView(this)
    }
}