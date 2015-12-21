package com.tearcode.app.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * 实现分享的功能
 * 
 * @author wanjiali
 *
 */
public class ShareActivity extends Activity {

	private ImageButton qqImageButton;
	private ImageButton weiboImageButton;
	private ImageButton weixinImageButton;
	private ImageButton elseImageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    setContentView(com.tearcode.app.R.layout.share_page_1);
		super.onCreate(savedInstanceState);
		
		qqImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.qq_image_button);
		weiboImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.weibo_image_button);
		weixinImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.weixin_image_button);
		elseImageButton = (ImageButton) findViewById(com.tearcode.app.R.id.else_image_button);
		
		//点击打开qq
		qqImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
	}
}
