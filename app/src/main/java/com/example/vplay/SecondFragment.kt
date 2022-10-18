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
    private lateinit var mediaController : MediaController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoView = requireView().findViewById(R.id.testView)

        mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
//        videoView = findViewById(R.id.testView)
//        mediaController = MediaController(this)
//        mediaController.setAnchorView(videoView)



        // specify location of media file
//        val uri: Uri = parse("android.resource://" + packageName + "/" + "raw/test")
        val uri: Uri = parse("android.resource://" + MainActivity().packageName + "/" + "raw/test")


        // setting media controller & URI, then starting the videoView
//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(uri)
//        videoView.requestFocus()
//        videoView.start()
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}