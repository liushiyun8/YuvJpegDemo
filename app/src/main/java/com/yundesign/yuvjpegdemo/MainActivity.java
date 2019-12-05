package com.yundesign.yuvjpegdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.emp.xdcommon.common.io.FileUtils;
import com.emp.xdcommon.common.utils.FileUtil;
import com.emptech.TurrboJpegLib;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private int width=1280;
    private int height=720;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }
        iv = findViewById(R.id.iv);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File("/sdcard/yun/1.yuv"));
            int[] argb = new int[width * height];
            TurrboJpegLib.yuv2argb(bytes,bytes.length,argb,width,height);
            Bitmap bitmap = Bitmap.createBitmap(argb, width, height, Bitmap.Config.ARGB_8888);
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
