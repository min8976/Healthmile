package kr.ac.tukorea.healthmile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main_tool.*
import kr.ac.tukorea.healthmile.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


import kotlinx.android.synthetic.main.activity_main.*

private const val TAG_HOME = "home_fragment"
private const val TAG_COMMUNITY = "community_fragment"
private const val TAG_RUNNINGMATE = "runningmate_fragment"



class MainToolActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setFragment(TAG_HOME, MainFragment())




    }

    fun setFragment(tag: String, fragment: Fragment){
        val manager : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = manager.beginTransaction()

        if(manager.findFragmentByTag(tag) == null){
            ft.add(R.id.mainNaviFragmentContainer, fragment, tag)
        }

        val community = manager.findFragmentByTag(TAG_COMMUNITY)
        val home = manager.findFragmentByTag(TAG_HOME)
        val runningMate = manager.findFragmentByTag(TAG_RUNNINGMATE)

        if (community != null){
            ft.hide(community)
        }
        if(home!=null){
            ft.hide(home)
        }
        if(runningMate!=null){
            ft.hide(runningMate)
        }

        if(tag == TAG_COMMUNITY){
            if(community!=null){
                ft.show(community)
            }
        }
        else if(tag == TAG_HOME){
            if(home!=null){
                ft.show(home)
            }
        }
        else if(tag == TAG_RUNNINGMATE){
            if(runningMate!=null){
                ft.show(runningMate)
            }
        }
        ft.commitAllowingStateLoss()
    }
}