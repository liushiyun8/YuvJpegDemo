package com.emptech;

public class TurrboJpegLib {

    static{
        System.loadLibrary("jni_jpeg");
    }

    public static native int yuv2jpeg(byte[] nv21,int w,int h,int subsample,byte[] jpeg ,int quality,int flags);

    public static native int yuvCrop2jpeg(byte[] nv21,int w,int h,int subsample,int x,int y,int cropW,int cropH,byte[] jpeg ,int quality,int flags);

    public static native int getjpegInfo(byte[] jpeg,int size,int[] info);

    public static native int jpeg2yuv(byte[] jpeg,int size,byte[] yuv,int w,int h);

    public static native int jpeg2argb(byte[] jpeg,int size,byte[] argb,int w,int h);

    public static native int yuv2argb(byte[] yuv,int size,int[] argb,int w,int h);

    public static native int yuv2rgb565(byte[] yuv,int size,byte[] rgb565,int w,int h);
}

