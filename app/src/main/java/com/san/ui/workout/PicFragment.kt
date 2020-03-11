package com.san.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.san.R
import com.san.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pic.*

class PicFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(PicViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_exercise.setOnClickListener {
            //TODO open new fragment where you choose exercise
        }

        btn_stop_workout.setOnClickListener {
            //TODO navigate back to homeFragment
        }

        vm.liveData.observe(viewLifecycleOwner, Observer {
            //Picasso.get().load(it.url).centerCrop().fit().into(imageView)
        })
    }
}
