package com.example.simplemobileapp.addition;

import android.widget.ImageView;

import com.example.simplemobileapp.SpinnerData;

public class ImageViewChange {

    public ImageViewChange() {
    }

    public void setImage(ImageView imageView, String str) {
        if (SpinnerData.imageData.get(str) != null) {
            imageView.setImageResource(SpinnerData.imageData.get(str));
        }
    }
}
