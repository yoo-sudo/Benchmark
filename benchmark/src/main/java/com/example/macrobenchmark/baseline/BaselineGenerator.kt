package com.example.macrobenchmark.baseline

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.macrobenchmark.util.TARGET_PACKAGE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalBaselineProfilesApi::class)
@RunWith(AndroidJUnit4::class)
abstract class BaselineGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    abstract fun MacrobenchmarkScope.profileBlock()

    @Test
    fun profileGenerator() {
        rule.collectBaselineProfile(
            packageName = TARGET_PACKAGE,
        ) {
            profileBlock()
        }
    }
}