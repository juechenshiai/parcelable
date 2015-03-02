package com.example.parcelabletest;


import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableMap implements Parcelable
{
	public Map<String, Object> map;
   
	public Map<String, Object> getMap()
	{
		return map;
	}
	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}
	@Override
	public int describeContents()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		// TODO Auto-generated method stub
		dest.writeMap(map);
	}
	
	 public static final Parcelable.Creator<ParcelableMap> CREATOR = new Creator<ParcelableMap>() {  
	        public ParcelableMap createFromParcel(Parcel source) {  
	        	ParcelableMap pm = new ParcelableMap();  
	        	pm.map = source.readHashMap(HashMap.class.getClassLoader());   
	            return pm;  
	        }  
	        public ParcelableMap[] newArray(int size) {  
	            return new ParcelableMap[size];  
	        }  
	    };  
}
