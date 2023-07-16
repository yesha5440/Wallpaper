package com.example.wallpaper

import android.content.Context
import android.provider.Contacts.Photos
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.PhotositemBinding

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {

    lateinit var photos : ArrayList<PhotosItem>
    lateinit var context: Context

    class WallpaperHolder(itemView : PhotositemBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context = parent.context
        var binding = PhotositemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WallpaperHolder(binding)
    }


    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder:WallpaperHolder, position: Int) {

        holder.binding.apply{
            photos.get(position).src.apply {
                Glide.with(context).load(this!!.portrait).into(imgphotos)
            }
        }

    }

   fun setPhotos(photos : List<PhotosItem>?){
       this.photos = (photos as ArrayList<PhotosItem>)
   }


}