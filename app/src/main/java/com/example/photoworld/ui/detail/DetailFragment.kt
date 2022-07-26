package com.example.photoworld.ui.detail

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.photoworld.R
import com.example.photoworld.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.item_card.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)

        binding.apply {
            val photo = args.photo

            Glide.with(this@DetailFragment)
                .load(photo.urls.full)
                .error(R.drawable.ic_launcher_foreground)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBarDetail.isVisible = false
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBarDetail.isVisible = false
                        textCreator.isVisible = true
                        textDescription.isVisible = photo.description != null
                        return false
                    }
                })
                .into(detailImageView)

            textDescription.text = photo.description

            val uri = Uri.parse(photo.user.attributionUrls)
            val intent = Intent(Intent.ACTION_VIEW, uri)

            textCreator.apply {
                text = "Photo by ${photo.user.name} Unsplash"
                setOnClickListener {
                    context.startActivity(intent)
                }
                paint.isUnderlineText = true
            }
        }
    }
}