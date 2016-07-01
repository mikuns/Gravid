package com.demo.gravid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends Activity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    private final int SPLASH_DISPLAY_LENGTH = 1500;
    /** Called when the activity is first created. */



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        StartAnimations();

    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    SharedPreferences sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
                    Boolean state = sharedPreferences.getBoolean("Status", false);
                    Boolean state2 = sharedPreferences.getBoolean("LoginStatus", false);

                    if(state.equals(true) && state2.equals(false)) {

                        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        finish();
                    }
                    else if(state.equals(true) && state2.equals(true)) {

                        Intent intent2 = new Intent(SplashScreen.this, MainActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        finish();
                    }
                    else
                    {
                        Intent intent1 = new Intent(SplashScreen.this, SelectActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        finish();
                    }

                SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
//super.onWindowFocusChanged(hasFocus);
        setVisible(true);
    }


}

