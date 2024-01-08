package com.example.homework2android2

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.findNavController
import com.example.homework2android2.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {
    private var _binding:FragmentAddItemBinding? = null
    private val binding:FragmentAddItemBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToHomeFragment()
    }

    private fun goToHomeFragment() = with(binding){
        btnAp.setOnClickListener {
            val image = R.drawable.nature
            val descriptionText = tvNature.text.toString()
            val model = Nature(
                natureImage = image,
                descriptionOfNature = descriptionText
            )
            findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToHomeFragment(model))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}