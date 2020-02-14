package mats.callbacks

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Callable


class MainActivity : AppCompatActivity() {

    val liveData = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveData.observe(this, Observer<Boolean> {
            showToast("test livedata")
        })


        interface_btn.setOnClickListener {
            Logic.interfaceTest(object : ListenerInterface {
                override fun onClick() {
                    showToast("test interface")
                }
            })
        }

        lambda_btn.setOnClickListener {
            Logic.lambdaTest {
                showToast("test lambda")
            }
        }

        callable_btn.setOnClickListener {
            Logic.callableTest(Callable { showToast("test callable") })

        }

        livedata_btn.setOnClickListener {
            Logic.livedataTest(liveData)
        }

        rxkotlin_btn.setOnClickListener {
            Logic.rxTest().observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver {
                    override fun onComplete() {
                        showToast("test rx")
                    }

                    override fun onSubscribe(d: Disposable) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onError(e: Throwable) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
        }
    }

    private fun showToast(msg : String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }


}
