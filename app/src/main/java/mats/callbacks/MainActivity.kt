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
                    Toast.makeText(this@MainActivity, "test interface", Toast.LENGTH_SHORT).show()
                }
            })
        }

        lambda_btn.setOnClickListener {
            Logic.lambdaTest {
                Toast.makeText(this@MainActivity, "test lambda", Toast.LENGTH_SHORT).show()
            }
        }

        callable_btn.setOnClickListener {
            Logic.callableTest(Callable { Toast.makeText(this@MainActivity, "test callable", Toast.LENGTH_SHORT).show() })
        }

        livedata_btn.setOnClickListener {
            val liveData = MutableLiveData<Boolean>()
            liveData.observe(this, Observer<Boolean> {
                Toast.makeText(this@MainActivity, "test livedata", Toast.LENGTH_SHORT).show()
            })
            Logic.livedataTest(liveData)
        }
    }


}
