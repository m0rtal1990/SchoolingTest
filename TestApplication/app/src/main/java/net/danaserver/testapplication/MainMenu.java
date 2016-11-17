package net.danaserver.testapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button callButton, googleButton, logoutButton, notificationButton;
    private NotificationManager mNotificationManager;
    private Notification.Builder firstNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        firstNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.faucheuse)
                .setContentTitle("This is a Notification")
                .setContentText("This is my first Notification (Hope you like it :D)");
        mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        // Setting Call Click Listener for the main menu
        callButton = (Button)findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);                         // Creating the Intent with the Action_Dial Function (works without permissions)
                callIntent.setData(Uri.parse("tel:+352621000000"));                         // Setting Data for the Intent with the URI.parse argument to pass on a phone number
                startActivity(callIntent);                                                  // Start the Call Intent
            }
        });

        // Setting the Google Maps Click Listener for the main menu
        googleButton = (Button)findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent googleIntent = new Intent(Intent.ACTION_VIEW);                       // Creating the Intent with the Action_View Function (to display the Internet Page)
                googleIntent.setData(Uri.parse("http://maps.google.com"));                  // Setting Data for the Intent with the URI.parse argument to pass on an internet site
                startActivity(googleIntent);                                                // Start the Browser Intent
            }
        });

        // Setting the Logout Click Listener for the main menu
        logoutButton = (Button)findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(view.getContext(),Login_Activity.class);   // Creating the Intent with the Context of Login_Activity in order to open it
                startActivity(logoutIntent);                                                // Start the Login_Activity
            }
        });

        // Setting the Notification Click Listener for the main menu
        notificationButton = (Button)findViewById(R.id.notificationButton);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNotificationManager.notify(0, firstNotification.build());
            }
        });
    }
}
