package com.demo.gravid;

import java.util.ArrayList;
import java.util.List;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.demo.adapters.NavListAdapter;
import com.demo.fragments.Baby;
import com.demo.fragments.Health;
import com.demo.fragments.Medications;
import com.demo.fragments.QandA;
import com.demo.fragments.Complications;
import com.demo.fragments.MyHome;
import com.demo.fragments.Nutrition;
import com.demo.models.NavItem;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	DrawerLayout drawerLayout;
	RelativeLayout drawerPane;
	ListView lvNav;
	TextView tView;

	String dueDateView;
	public static final String DEFAULT = "N/A";
	private Toast toast;
	private long lastBackPressTime = 0;

	List<NavItem> listNavItems;
	List<Fragment> listFragments;

	ActionBarDrawerToggle actionBarDrawerToggle;
	FloatingActionButton fab;

	NotificationCompat.Builder notification;
	private static final int uniqueID = 234234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		notification = new NotificationCompat.Builder(this);
		notification.setAutoCancel(true);

		SharedPreferences sharedPreferences1;

		sharedPreferences1= getSharedPreferences("Account", Context.MODE_PRIVATE);
		String name = sharedPreferences1.getString("FullName", DEFAULT);
		String email = sharedPreferences1.getString("Email", DEFAULT);

		Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(topToolBar);
		topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));

		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, ForumActivity.class);
				startActivity(intent);
			}
		});



		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
 		drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);

		lvNav = (ListView) findViewById(R.id.nav_list);

		//Navigation list Menu

		listNavItems = new ArrayList<NavItem>();
		listNavItems.add(new NavItem("Welcome" + " " + name , "Overview, Dashboard", R.drawable.ic_action_home));
		listNavItems.add(new NavItem("Nutrition", "Diet and Chart, Food", R.drawable.ic_action_nutrition));
		listNavItems.add(new NavItem("Stay Healthy", "Safe Health, Exercise, Oral ealth", R.drawable.icon_action_exercise));
		listNavItems.add(new NavItem("Medications", "Drugs, Herbs", R.drawable.ic_action_med));
		listNavItems.add(new NavItem("Complications", "Health Problems, Defects", R.drawable.ic_action_qanda));
		listNavItems.add(new NavItem("Baby Development", "Week 1-40", R.drawable.ic_action_baby));
		listNavItems.add(new NavItem("Questions and Answers", "", R.drawable.ic_question_answer));

		NavListAdapter navListAdapter = new NavListAdapter(
				getApplicationContext(), R.layout.item_nav_list, listNavItems);

		lvNav.setAdapter(navListAdapter);

		listFragments = new ArrayList<Fragment>();
		listFragments.add(new MyHome());
		listFragments.add(new Nutrition());
		listFragments.add(new Health());
		listFragments.add(new Medications());
		listFragments.add(new Complications());
		listFragments.add(new Baby());
		listFragments.add(new QandA());


		// load first fragment as default:
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.main_content, listFragments.get(0)).commit();

		setTitle(listNavItems.get(0).getTitle());
		lvNav.setItemChecked(0, true);
		drawerLayout.closeDrawer(drawerPane);

		// set listener for navigation items:
		lvNav.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// replace the fragment with the selection correspondingly:
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager
						.beginTransaction()
						.replace(R.id.main_content, listFragments.get(position))
						.commit();

				setTitle(listNavItems.get(position).getTitle());
				lvNav.setItemChecked(position, true);
				drawerLayout.closeDrawer(drawerPane);

			}
		});

		// create listener for drawer layout
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.string.drawer_opened, R.string.drawer_closed) {

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				invalidateOptionsMenu();
				super.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				invalidateOptionsMenu();
				super.onDrawerClosed(drawerView);
			}

		};

		drawerLayout.setDrawerListener(actionBarDrawerToggle);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the MyHome/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_settings){
			Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
			startActivity(intent);
		}
		if(id == R.id.action_search){
			Intent intent = new Intent(MainActivity.this, SearchActivity.class);
			startActivity(intent);
					}
		if(id == R.id.action_about){
			Intent intent = new Intent(MainActivity.this, About.class);
			startActivity(intent);
		}
		if(id == R.id.action_signOut){
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setMessage("Are you sure you want to sign out of Your Account.");
			builder1.setCancelable(true);

			builder1.setPositiveButton(
					"Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							SharedPreferences sharedPreferences1 = getSharedPreferences("Account", Context.MODE_PRIVATE);
							SharedPreferences.Editor editor = sharedPreferences1.edit();
							editor.putBoolean("LoginStatus", false);
							editor.commit();

							Intent intent = new Intent(MainActivity.this, LoginActivity.class);
							startActivity(intent);
						}
					});

			builder1.setNegativeButton(
					"No",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}
		if(id == R.id.action_reset){
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setMessage("Are you sure you want  to RESET Your Account.");
			builder1.setCancelable(true);

			builder1.setPositiveButton(
					"Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							SharedPreferences sharedPreferences, sharedPreferences1;
							sharedPreferences = getSharedPreferences("Account", Context.MODE_PRIVATE);
							sharedPreferences1 = getSharedPreferences("dueDate_pref", Context.MODE_PRIVATE);

							SharedPreferences.Editor editor = sharedPreferences.edit();
							SharedPreferences.Editor editor1 = sharedPreferences1.edit();
							editor.clear();
							editor.commit();
							editor1.clear();
							editor1.commit();

							Intent i = new Intent(MainActivity.this, RegisterActivity.class);
							startActivity(i);
						}
					});

			builder1.setNegativeButton(
					"No",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}

			if (actionBarDrawerToggle.onOptionsItemSelected(item))
			return true;

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}
	private long lastTime = 0;

	@Override
	public void onBackPressed()
	{
		if(System.currentTimeMillis() - lastTime < 2000)
		{
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		}
		else
		{
			lastTime = System.currentTimeMillis();
			Snackbar.make(drawerPane, "Press back again to close Gravid", Snackbar.LENGTH_SHORT).show();

			notification.setSmallIcon(R.drawable.logo);
			notification.setTicker("Out So Soon");
			notification.setWhen(System.currentTimeMillis());
			notification.setContentTitle("Gravid Care");
			notification.setContentText("Tap to get back");

			Intent intent = new Intent(this, LoginActivity.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
			notification.setContentIntent(pendingIntent);

			//Builds notification and issues it
			NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			nm.notify(uniqueID, notification.build());
		}
//
	}


}
