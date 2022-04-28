package com.example.androidsamples

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)

        tv_register.setOnClickListener {
           val  fragmentRegister = RegisterFragment()
            setCurrentFragment(fragmentRegister)
        }
        btn_login.setOnClickListener {
            val mail = et_mail.text.toString()
            val password = et_password.text.toString()
            val mailRegistered = sharedPreferences?.getString("mail", null)
            val passwordRegistered = sharedPreferences?.getString("password", null)
            if (mail == mailRegistered && password == passwordRegistered) {
                setCurrentFragment(HomeFragment())
            } else {
                Toast.makeText(requireContext(), "Wrong mail or password", Toast.LENGTH_SHORT).show()

            }

        }


    }

    private fun setCurrentFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fl_container, fragment)
            commit()
        }
    }

}