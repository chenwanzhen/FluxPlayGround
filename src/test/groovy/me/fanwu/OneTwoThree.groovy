package me.fanwu

import io.reactivex.Observable
import org.junit.Test

/**
 *  fanwu 编写于 2017/7/25.
 */
class OneTwoThree {

    @Test
    void testOneTwoThree() {
        Observable.just("one", "two", "three").take(2).subscribe({ println(it) })
    }
}
