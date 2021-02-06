package co.eventbox.event.view.activities

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import co.eventbox.event.Config
import java.util.*


open class BaseActivity: AppCompatActivity() {

    fun locate(locate: String) {
        val locale = Locale(locate)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val configuration: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale)
        }
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.getDisplayMetrics())
    }
}