package com.example.androidsamples

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        btn_sign_up.setOnClickListener {
            val mail = et_mail.text.toString()
            val password = et_password.text.toString()
            if(isPasswordProper(password) && isMailProper(mail)) {
                editor?.apply {
                    putString("mail", mail)
                    putString("password", password)
                    apply()
                }
                setCurrentFragment(HomeFragment())
            }


        }
    }

    private fun isPasswordProper(password: String): Boolean {
        if(password.length > 4) {
            return true
        } else {
            Toast.makeText(requireContext(), "Password is short", Toast.LENGTH_LONG).show()
            return false
        }
    }

    private fun isMailProper(mail: String): Boolean {
        if(mail.length < 4) {
            Toast.makeText(requireContext(), "Mail is short", Toast.LENGTH_LONG).show()
            return false
        } else if(!mail.endsWith(".com")) {
            Toast.makeText(requireContext(), "Mail doesnt end with : .com" , Toast.LENGTH_LONG).show()
            return false
        } else if(!mail.contains('@')) {
            Toast.makeText(requireContext(), "Mail doesnt contain: @ " , Toast.LENGTH_LONG).show()
            return false
        } else {
            return true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fl_container, fragment)
            commit()
        }
    }


}