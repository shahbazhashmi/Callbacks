package mats.callbacks

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe
import java.util.concurrent.Callable

/**
 * Created by Shahbaz Hashmi on 2020-02-13.
 */
object Logic {

    val DELAY = 0L

    fun interfaceTest(listenerInterface: ListenerInterface) {
        delay {
            listenerInterface.onClick()
        }
    }

    fun lambdaTest(funOnClick : () -> Unit) {
        delay {
            funOnClick()
        }
    }

    fun callableTest(callable : Callable<Unit>) {
        delay {
            callable.call()
        }
    }

    fun livedataTest(liveData: MutableLiveData<Boolean>) {
        delay {
            liveData.value = liveData.value == null || !liveData.value!!
        }
    }

    fun rxTest() : Completable {
        return Completable.create(object : CompletableOnSubscribe {
            override fun subscribe(emitter: CompletableEmitter) {
                delay {
                    emitter.onComplete()
                }
            }
        })
    }


    private fun delay(funcDelay : () -> Unit) {
        Handler().postDelayed({
            funcDelay()
        }, DELAY)
    }

}