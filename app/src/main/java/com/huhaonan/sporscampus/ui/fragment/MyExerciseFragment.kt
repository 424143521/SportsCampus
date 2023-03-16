package com.huhaonan.sporscampus.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapView
import com.huhaonan.sporscampus.util.SportsCampusApplication
import com.huhaonan.sporscampus.ui.viewmodel.MovementViewModel
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.FragmentMyExerciseBinding


class MyExerciseFragment : Fragment() {


    private lateinit var viewModel: MovementViewModel
    private lateinit var binding: FragmentMyExerciseBinding
    private lateinit var locationClient: LocationClient
    private lateinit var mMapView: MapView
    lateinit var baiduMap: BaiduMap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//初始化地图  第一句是防止闪退的 不加分分钟死给你看
        SDKInitializer.setAgreePrivacy(SportsCampusApplication.context,true)
        SDKInitializer.initialize(SportsCampusApplication.context)
        //这一句应该是地图坐标系  百度官方有
        SDKInitializer.setCoordType(CoordType.BD09LL)
//初始化轨迹服务
        // 轨迹服务ID
        // 轨迹服务ID
        val serviceId: Long = 0
// 设备标识
// 设备标识
        val entityName = "myTrace"
// 初始化轨迹服务
// 初始化轨迹服务

        binding = DataBindingUtil.inflate<FragmentMyExerciseBinding>(
            inflater,
            R.layout.fragment_my_exercise,
            container,
            false
        )
//        binding = FragmentMyExerciseBinding.inflate(layoutInflater)
        mMapView = binding.bmapView
        //把百度图丢在这个控件里binding.bmapView
        baiduMap = binding.bmapView.getMap()
        baiduMap.isMyLocationEnabled = true

      /*  val list:ArrayList<String> = ArrayList<String>()
        if (ContextCompat.checkSelfPermission(SportsCampusApplication.context,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            list.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (ContextCompat.checkSelfPermission(SportsCampusApplication.context,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            list.add(android.Manifest.permission.READ_PHONE_STATE)
        }
        if (ContextCompat.checkSelfPermission(SportsCampusApplication.context,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            list.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if(list.isNotEmpty()){
            val permissions : Array<String> = list.toArray() as Array<String>
            ActivityCompat.requestPermissions(requireActivity(),permissions,1)
        }else{
            requestLocation()

        }*/



     /*  locationClient =  LocationClient(SportsCampusApplication.context)
//       val locationInfo: TextView = binding.locationInfo
        locationClient.registerLocationListener(MyLocationListener())

        requestLocation()*/
        return binding.root
    }

   /* private fun requestLocation() {
       //初始化
        initLocation()
        //监听
        locationClient.start()
    }
*/
    private fun initLocation() {
        val option: LocationClientOption = LocationClientOption()
        //设置为高精度模式
        option.locationMode = LocationClientOption.LocationMode.Hight_Accuracy
        //设置百度的坐标模式
        option.setCoorType("bd0911")
        //发起请求的间隔
        option.setScanSpan(1000)
        //设置是否打开GPS
        option.setOpenGps(true)
//设置定位提醒
        option.isLocationNotify = true
        //在独立线程里是否杀死它
        option.setIgnoreKillProcess(true)
        option.isIgnoreCacheException = false
        option.setWifiCacheTimeOut(5 * 60 * 1000)
        option.setEnableSimulateGps(false)
        //设置地理位置
        option.setIsNeedAddress(true)
        locationClient.locOption = option
    }


    inner class MyLocationListener : BDAbstractLocationListener() {
        //收到定位信息要做什么
        override fun onReceiveLocation(location: BDLocation?) {


        }
    }

 /*   private fun navigateTo( location: BDLocation) {
//拿到经纬度
        val ll : LatLng = LatLng(location.latitude,location.longitude)
//更新地图
        var update: MapStatusUpdate = MapStatusUpdateFactory.newLatLng(ll)
        baiduMap.animateMapStatus(update)
//        缩放
        update = MapStatusUpdateFactory.zoomTo(16f)
        baiduMap.animateMapStatus(update)
    }*/

    //下面三个生命周期照抄
    override fun onResume() {
        super.onResume()
        binding.bmapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.bmapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()


        binding.bmapView.onDestroy()
        baiduMap.isMyLocationEnabled=false
    }

}