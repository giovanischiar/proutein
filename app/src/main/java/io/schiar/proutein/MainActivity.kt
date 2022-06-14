package io.schiar.proutein

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.schiar.proutein.view.FoodsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FoodsFragment.newInstance())
                .commitNow()
        }
    }
}