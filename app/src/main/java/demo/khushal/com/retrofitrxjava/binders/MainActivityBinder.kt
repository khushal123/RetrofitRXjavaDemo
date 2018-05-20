package demo.khushal.com.retrofitrxjava.binders

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.databinding.Observable

class MainActivityBinder : BaseObservable() {
    @get:Bindable
    var isVisible: Boolean = false
}
