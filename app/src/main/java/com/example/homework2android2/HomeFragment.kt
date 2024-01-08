package com.example.homework2android2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2android2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding:FragmentHomeBinding get() = _binding!!
    private val natureAdapter = NaturesListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goClick()
        getArgs(view)

    }

    private fun getArgs(view: View) {
        try {
            val args: HomeFragmentArgs by navArgs()
            SafeList.natureList.add(args.natureModel)
            natureAdapter.setNaturesList(SafeList.natureList)
            binding.rvHFragment.adapter = natureAdapter
        }catch (exception: Exception) {
        }
    }

    private fun goClick() = with(binding) {
        btnPress.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}