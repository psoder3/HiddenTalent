/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2video;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class CameraActivity extends Activity {

    Camera2VideoFragment camera2;

    public static String mPreviousFileAbsolutePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        camera2 = Camera2VideoFragment.newInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, camera2)
                    .commit();
        }
        new AlertDialog.Builder(this)
                .setMessage(R.string.intro_message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public void swapCameras(View view)
    {
        if (Camera2VideoFragment.whichCamera.equals("0")) {
            Camera2VideoFragment.whichCamera = "1";
        }
        else
        {
            Camera2VideoFragment.whichCamera = "0";
        }

        setContentView(R.layout.activity_camera);
        getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2VideoFragment.newInstance())
                    .commit();
    }


    public void playVideo(View view)
    {
        String filename = CameraActivity.mPreviousFileAbsolutePath;
        //String filename = "/storage/emulated/0/Android/data/com.example.android.camera2video/files/1535736069464.mp4";
        File f = new File(filename);
        System.out.println(f.length());

        MediaPlayer mp=new MediaPlayer();
        try {
            camera2.closePreviewSession();
            mp.setDataSource(filename);
            mp.setScreenOnWhilePlaying(true);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
