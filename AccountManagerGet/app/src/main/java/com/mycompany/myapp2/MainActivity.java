package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.accounts.*;
import android.util.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity 
{
	AlertDialog.Builder builder;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
		
	public void onClick(View v) {
		
		AccountManager am = AccountManager.get(this);

		final Account[] accounts = am.getAccountsByType("com.google");
		Log.i("Account", accounts.length + "");
		
    final String[] accountsArray = new String[accounts.length];
	
	for(int i=0;i<accounts.length;i++){
		
		accountsArray[i]=accounts[i].name;
	}
	
	
    builder = new AlertDialog.Builder(this);
    builder.setTitle("Choose account")
	.setCancelable(false)

	.setNeutralButton("Back",
	new DialogInterface.OnClickListener() {
	public void onClick(DialogInterface dialog,
						int id) {
		dialog.cancel();
	}
	})
		.setPositiveButton("Ok",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
									int id) {
					dialog.cancel();
				}
			})
	
	
	.setSingleChoiceItems(accountsArray,-1,
	new DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface dialog,
						int item) {
		Toast.makeText(
			getApplicationContext(),
			"Choosen account: "
			+ accounts[item].name,
			Toast.LENGTH_SHORT).show();
			
			Log.d("CHOOSEN_ACCOUNT:",accounts[item].name);
			
	}
	});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
