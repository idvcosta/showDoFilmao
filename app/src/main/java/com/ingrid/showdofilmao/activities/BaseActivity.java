package com.ingrid.showdofilmao.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class BaseActivity extends AppCompatActivity {
    protected void replace(int containerId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(containerId, fragment).commit();
    }
}
