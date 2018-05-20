package demo.khushal.com.retrofitrxjava


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Binder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import demo.khushal.com.retrofitrxjava.adapter.MainRvAdapter
import demo.khushal.com.retrofitrxjava.binders.MainActivityBinder
import demo.khushal.com.retrofitrxjava.databinding.ActivityMainBinding
import demo.khushal.com.retrofitrxjava.viewModels.MainViewModel
import java.util.*
import android.support.v7.widget.DividerItemDecoration



class MainActivity : AppCompatActivity(), Observer {
    override fun update(o: Observable?, arg: Any?) {
        Log.e("observable", "called")
        binder.isVisible = true
        if (o is MainViewModel && o.userList != null){
            Log.e("dapter", o.userList.size.toString())

            var layoutmanager = LinearLayoutManager(this)
            layoutmanager.orientation = LinearLayoutManager.VERTICAL
            val dividerItemDecoration = DividerItemDecoration(this,
                    layoutmanager.getOrientation())
            binding.rvRepos.addItemDecoration(dividerItemDecoration)
            binding.rvRepos.layoutManager  = layoutmanager
            var adapter = MainRvAdapter(o.userList)
            binding.rvRepos.adapter = adapter
        }else{

            Toast.makeText(this, "Error no data found", Toast.LENGTH_LONG).show()
        }
    }

    lateinit var binding:ActivityMainBinding;
    lateinit var viewModel:MainViewModel;
    lateinit var binder:MainActivityBinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        viewModel.addObserver(this)
        binder = MainActivityBinder()
        binder.isVisible = false
        binding.binder = binder
        viewModel.getData()

    }

    override fun onStop() {
        super.onStop()
        viewModel.reset()
    }
}
