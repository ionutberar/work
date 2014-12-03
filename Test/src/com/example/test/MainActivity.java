package com.example.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static String hello;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.mesaj)
		.setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				final Button button = (Button) findViewById(R.id.hit);
				final EditText nume=(EditText)findViewById(R.id.nume);
				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Context context=getApplicationContext();

						if(nume.getText().length()!=0)
						{	
							hello="Salut "+nume.getText().toString()+"!\nSa ai o zi buna!";


							Intent intent = new Intent(MainActivity.this, Pagina1Activity.class);
							startActivity(intent);}
						else
						{Toast toast=Toast.makeText(context,"Incearca sa scrii ceva la nume...  trebuie neaparat!",Toast.LENGTH_LONG);
						toast.show();
						}
					}
				});
			}
		})
		.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				finish();
				System.exit(0); // User cancelled the dialog
			}
		});

		builder.create();
		builder.show();


	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{ MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu, menu);
	return true;

	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		Context context=getApplicationContext();
		switch (item.getItemId()) {
		case R.id.about:
		{Toast toast=Toast.makeText(context,"Ai selectat butonul de About!",Toast.LENGTH_LONG);
		toast.show();
		return true;}
		case R.id.help:
		{Toast toast=Toast.makeText(context,"Ai selectat butonul de Help!",Toast.LENGTH_LONG);
		toast.show();
		return true;}
		case R.id.dialog:
		{
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

