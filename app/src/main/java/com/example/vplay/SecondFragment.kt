package com.example.vplay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.vplay.databinding.FragmentSecondBinding
import android.net.Uri
import android.net.Uri.*
import android.widget.VideoView
import android.widget.MediaController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var videoView: VideoView
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        videoView = findViewById(R.id.testView)
        videoView = requireView().findViewById(R.id.testView)
//        val mediaController = MediaController(this)
//        mediaController.setAnchorView(videoView)
        // specify location of media file
//        val uri: Uri = parse("android.resource://" + packageName + "/" + "raw/test")
//        val uri: Uri = parse("android.resource://" + packageName + "/" + "raw/test")
//        // setting media controller & URI, then starting the videoView
//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(uri)
//        videoView.requestFocus()
//        videoView.start()

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}