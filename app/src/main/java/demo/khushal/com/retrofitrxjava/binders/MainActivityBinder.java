package demo.khushal.com.retrofitrxjava.binders;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;

public class MainActivityBinder extends BaseObservable {
    private boolean isVisible;

    @Bindable
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
