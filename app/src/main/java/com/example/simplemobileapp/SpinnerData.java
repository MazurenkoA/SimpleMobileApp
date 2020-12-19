package com.example.simplemobileapp;

import android.util.ArrayMap;

public class SpinnerData {

    public static ArrayMap<String, Integer> imageData = new ArrayMap<>();

    static {
        imageData.put("Ничего не выбрано :(", R.drawable.rick);
        imageData.put("Обычный пользователь ಥ_ಥ", R.drawable.shrek);
        imageData.put("Студент ༼ つ ◕_◕ ༽つ", R.drawable.student);
        imageData.put("Киану Ривз ( •_•)>⌐■-■", R.drawable.keanu);
        imageData.put("Тот-Чьё-Имя-Нельзя-Называть", R.drawable.voland);
    }
}
