// Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
public class AndersonActivity8 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.matToolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.matDrawer_Layout);
        NavigationView navigationView = findViewById(R.id.matNav_View);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.matFragment_Container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    displayAlertDialog();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public void displayAlertDialog(){

        // 1. Instantiate an AlertDialog.Builder with its constructor.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Add the buttons.
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User taps OK button.
                finish();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancels the dialog.
                dialog.dismiss();
            }
        });

        builder.setIcon(R.drawable.baseline_home_24);

// 2. Chain together various setter methods to set the dialog characteristics.

        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        //android.R.drawable.ic_dialog_alert


        builder.setCancelable(false);

// 3. Get the AlertDialog.
        AlertDialog dialog = builder.create();

        dialog.show();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.matFragment_Container, new HomeFragment()).commit();
        } else if (item.getItemId() == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.matFragment_Container, new SettingsFragment()).commit();
        } else if (item.getItemId() == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.matFragment_Container, new ShareFragment()).commit();
        } else if (item.getItemId() == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.matFragment_Container, new AboutFragment()).commit();
        } else if (item.getItemId() == R.id.nav_logout) {
            displayAlertDialog();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}