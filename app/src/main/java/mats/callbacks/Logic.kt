package mats.callbacks

import android.os.Handler
import java.util.concurrent.Callable

/**
 * Created by Shahbaz Hashmi on 2020-02-13.
 */
object Logic {

    val DELAY = 1500L

    fun itnterfaceTest(listenerInterface: ListenerInterface) {
        Handler().postDelayed({
            listenerInterface.onClick()
        }, DELAY)
    }

    fun lambdaTest(funOnClick : () -> Unit) {
        Handler().postDelayed({
            funOnClick()
        }, DELAY)
    }

    fun callableTest(callable : Callable<Unit>) {
        Handler().postDelayed({
            callable.call()
        }, DELAY)
    }

}