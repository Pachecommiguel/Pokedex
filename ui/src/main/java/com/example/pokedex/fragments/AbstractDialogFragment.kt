package com.example.pokedex.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.pokedex.R

abstract class AbstractDialogFragment : DialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
    }

    override fun getTheme(): Int = R.style.Dialog_Fullscreen
}