package com.example.fragmentscommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentscommunication.databinding.FragmentSecondBinding

class SecondFragment : Fragment(){
    private lateinit var fragmentSecondBinding: FragmentSecondBinding

    var text2 = ""
        set(value){
            field = value
            fragmentSecondBinding.edtCity.setText(value)
        }

    //way 3 - create an interface with a function inside it
    interface OnCitySetListener {
        fun onCitySet(text : String)
    }

    lateinit var onCitySetListener: OnCitySetListener           //reference of listener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSecondBinding = FragmentSecondBinding.inflate(layoutInflater)
        fragmentSecondBinding.btnSendDataToFirstFragment.setOnClickListener {

            /* way 1
            (parentFragmentManager.findFragmentById(R.id.fragmentFirst)
                    as FirstFragment).text1 = fragmentSecondBinding.edtCity.text.toString() */

            /* way 2
            (requireActivity() as MainActivity).sendDataToFirstFragment(
                fragmentSecondBinding.edtCity.text.toString()) */

            //way 3
            onCitySetListener.onCitySet(fragmentSecondBinding.edtCity.text.toString())

        }

        return fragmentSecondBinding.root
    }
}