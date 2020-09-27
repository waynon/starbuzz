package bjfu.it.liuchangxin.starbuzz

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import bjfu.it.liuchangxin.starbuzz.databinding.ActivityStarbuzzBinding
import bjfu.it.liuchangxin.starbuzz.utilities.InjectorUtils
import bjfu.it.liuchangxin.starbuzz.viewmodels.CartViewModel

class StarbuzzActivity : AppCompatActivity() {
    val viewModel: CartViewModel by viewModels {
        InjectorUtils.provideCartViewModelFactory(this)
    }
    lateinit var binding: ActivityStarbuzzBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarbuzzBinding.inflate(layoutInflater).apply {
            setContentView(root)
            bottomNavView.setupWithNavController(findNavController(R.id.nav_host_fragment))
        }
        viewModel.commodities.observe(this) {
            binding.bottomNavView.getOrCreateBadge(R.id.cartFragment).apply {
                when {
                    it.size == 0 -> {
                        isVisible = false
                    }
                    else -> {
                        isVisible = true
                        number = it.size
                    }
                }
            }

        }
    }
}
