package com.example.fragmentscommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragmentscommunication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var fragmentFirstBinding: FragmentFirstBinding
    private lateinit var edtName : EditText
    private lateinit var btnSendDataToSecondFragment : Button

    var text1 = ""
        set(value) {
            field = value
            fragmentFirstBinding.edtName.setText(value)
        }

    //way 3 - create an interface with a function inside it
    interface OnNameSetListener{
        fun onNameSet(text : String)
    }

    lateinit var onNameSetListener: OnNameSetListener   //reference of listener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFirstBinding = FragmentFirstBinding.inflate(layoutInflater)
        fragmentFirstBinding.btnSendDataToSecondFragment.setOnClickListener {

            /* way 1
           (parentFragmentManager.findFragmentById(R.id.fragmentSecond)
                   as SecondFragment).text2 = fragmentFirstBinding.edtName.text.toString() */

            /* way 2
           (requireActivity() as MainActivity).sendDataToSecondFragment(
                fragmentFirstBinding.edtName.text.toString()) */

            //way 3
            onNameSetListener.onNameSet(fragmentFirstBinding.edtName.text.toString())

        }
        return fragmentFirstBinding.root
    }

}