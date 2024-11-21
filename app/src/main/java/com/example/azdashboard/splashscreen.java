package com.example.azdashboard;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;
import android.window.SplashScreenView;



import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        // Delay for the splash screen
        new Handler().postDelayed(() -> {
            if (isInternetAvailable()) {
                // Proceed to the main activity
                Intent intent = new Intent(splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Show a toast message and close the app
                Toast.makeText(splashscreen.this, "No Internet Connection!", Toast.LENGTH_LONG).show();
                // Redirect to Splashscreen activity if no connection
                Intent intent = new Intent(splashscreen.this, NoConectionActivity.class);
                startActivity(intent);
//                finish();
            }
        }, 5000); // Delay in milliseconds (3 seconds)
    }
    // Method to check internet connection
    private boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}