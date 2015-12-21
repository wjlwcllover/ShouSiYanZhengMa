package com.tearcode.app;

import com.tearcode.app.activity.QustionAndAnswerActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.DownloadManager.Query;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageButton setImageButton;
	private ImageButton exitImageButton;
	private Button beginGameButton;
	private ImageButton screenImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		setImageButton = (ImageButton) findViewById(R.id.set);
		exitImageButton = (ImageButton) findViewById(R.id.exit);
		screenImageButton = (ImageButton) findViewById(R.id.screen);
		beginGameButton = (Button) findViewById(R.id.begin_game);

		setImageButton.setBackgroundResource(R.drawable.set);
		exitImageButton.setBackgroundResource(R.drawable.exit);

		screenImageButton.setBackgroundResource(R.drawable.screen);

		// ����������ImageButton���¼���Ӧ
		// ������ ����ť
		setImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//������ع��ܣ��Ѷȣ�����
				
			}
		});

		exitImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ͨ��finish()�����ٻ
				onDestroy();
				finish();
			}
		});
		
		screenImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//����ϵͳ�Ľ�������,������
				//ShareActivity
				
			}
		});
		
		//���忪ʼ��Ϸ�İ�ť�¼�
		beginGameButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//������Ϸ�����������
				Intent intent = new Intent(MainActivity.this,QustionAndAnswerActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//Toast.makeText(MainActivity.this, "�ǵ���˺Ŷ~", Toast.LENGTH_LONG).show();
	}

}
