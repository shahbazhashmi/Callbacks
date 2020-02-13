package mats.callbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            val liveData = MutableLiveData<Boolean>()
            liveData.observe(this, Observer<Boolean> {
                showToast("test livedata")
            })
            Logic.livedataTest(liveData)
        }

        rxjava_btn.setOnClickListener {

        }
    }

    private fun showToast(msg : String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }


}
