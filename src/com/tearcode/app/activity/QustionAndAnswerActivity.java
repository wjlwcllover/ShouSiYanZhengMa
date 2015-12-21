package com.tearcode.app.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.tearcode.app.MainActivity;

import android.R.integer;
import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QustionAndAnswerActivity extends Activity {

	private TextView timeCounTextView;
	private TextView questionTextView;
	private List<ImageButton> imageButtons;
	private ImageButton oneImageButton;
	private ImageButton twoImageButton;
	private ImageButton threeImageButton;
	private ImageButton fourImageButton;
	private ImageButton fiveImageButton;
	private ImageButton sixImageButton;
	private ImageButton sevenImageButton;
	private ImageButton eightImageButton;

	int minutes = 0;
	int seconds = 0;
	String secondsString;
	String minutesString;

	// 当前选择的 图片NO
	private int selectedImageNo;
	// 当前的 题目编号
	private int qustionNo = 1;
	
	//暂停 变量 停止 计时器的计时
	private boolean cancel = false;// 保留当前时间
	private boolean reset = false ;//重置时间为00:00

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(com.tearcode.app.R.layout.game_page);

		imageButtons = new ArrayList<ImageButton>();
		timeCounTextView = (TextView) findViewById(com.tearcode.app.R.id.time_count);
		questionTextView = (TextView) findViewById(com.tearcode.app.R.id.qustion);

		// timer开始计时 应该在一个线程中计时
		 
				TimeCount();
		 

	 
		
		oneImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.first_image1);
		imageButtons.add(oneImageButton);
		oneImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a1);
		oneImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
				 
				 
			}
		});

		twoImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.first_image2);
		imageButtons.add(twoImageButton);
		twoImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a2);
		twoImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		threeImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.first_image3);
		imageButtons.add(threeImageButton);
		threeImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a3);
		oneImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		fourImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.second_parent1);
		imageButtons.add(fourImageButton);
		fourImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a4);

		fourImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		fiveImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.second_parent2);
		imageButtons.add(fiveImageButton);
		fiveImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a5);
		fiveImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		sixImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.second_parent3);
		imageButtons.add(sixImageButton);
		sixImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a6);
		sixImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		sevenImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.third_image1);
		imageButtons.add(sevenImageButton);
		sevenImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a7);
		sevenImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WrongAnswer();
			}
		});

		eightImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.third_image2);
		imageButtons.add(eightImageButton);
		eightImageButton.setBackgroundResource(com.tearcode.app.R.drawable.a8);
		eightImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CorrectAnswer();
				 
			}
		});

		
		
		

		questionTextView.setText("题目" + qustionNo + ":选出下列图片中所有的猫。（点两下确认）");

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {

			String timeString = (String) msg.obj;

			timeCounTextView.setText(timeString);

		};
	};

	public void WrongAnswer() {
		
		Toast.makeText(this, "你被撕了...", Toast.LENGTH_LONG).show();
	}
	
	public void CorrectAnswer() {
		Toast.makeText(this, "手撕高手", Toast.LENGTH_LONG).show();
	}

	public  void TimeCount( ) {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				TimeEclipse();
				// System.out.println(minutes + ":"+seconds);

				Message message = new Message();
				message.obj = minutesString + ":" + secondsString;
				handler.sendMessage(message);
			}
		};

		// 每个 一秒执行 task
		if(!cancel)
		timer.scheduleAtFixedRate(task, 0, 1000);
		else {
			timer.cancel();
		}

	}

	public void TimeEclipse() {

		if (seconds < 59 && minutes < 59) {
			seconds++;
		} else if (seconds == 59) {
			seconds = 0;
			if (minutes == 59)
				minutes = 0;
			else if (minutes < 59) {
				minutes++;
			}
		}

		// 构造字符串
		if (seconds < 10) {
			secondsString = "0" + seconds;
		} else {
			secondsString = "" + seconds;
		}

		if (minutes < 10) {
			minutesString = "0" + minutes;
		} else {
			minutesString = "" + minutes;
		}

	}
}
