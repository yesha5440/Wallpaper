package com.example.wallpaper

import android.net.SocketKeepalive.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.API.ApiClient
import com.example.wallpaper.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallpaperAdapter
    var auth = "whdkhwiriiduqgduqwdnadmjiqdhwq78ihiudhndiaIUDQ8OEY287HNJIWE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = WallpaperAdapter()
        binding.btnsearch.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {

        var txt = binding.edtsearch.text.toString()

        var api: APIinterface= ApiClient.getApiClient().create(APIinterface::class.java)
        api.getphotos(auth, txt).enqueue( {

            fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                if (response.isSuccessful) {
                    var photos = response.body()?.photos
                    adapter.setPhotos(photos as List<PhotosItem>?)
                    binding.rcvphotos.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.rcvphotos.adapter = adapter

                }

            }

            fun onFailure(call: Call<PhotoModel>, t: Throwable) {

            }

        })

    }

}

private fun Any.enqueue(any: Any) {


}
