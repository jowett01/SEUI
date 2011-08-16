package com.candzen.productguide;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends ActivityGroup{
	final String TAG = ProductsActivity.class.getSimpleName();

	ImageView btnHome;
	TabHost tabHost;
	TableLayout homeShowLayout;
	FrameLayout tabFrame;
	TabWidget tabWidget;
	Button prdCateButton;
	
	final String PRODUCTS = "products";
	final String BUY = "buy";
	final String NEWS = "news";
	final String SHOPS = "shops";
	final String MORE = "more";
	final String HOME = "home";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);        
        setContentView(R.layout.main);
        
        tabHost = (TabHost)findViewById(R.id.tabhostMain);         
        tabHost.setup(this.getLocalActivityManager()); 
        tabFrame = tabHost.getTabContentView();
        tabWidget = tabHost.getTabWidget();
  
        
        tabHost.addTab(tabHost.newTabSpec(PRODUCTS)
                .setIndicator(getResources().getString(R.string.products))
                .setContent(new Intent(this,ProductsActivity.class)));
        
        tabHost.addTab(tabHost.newTabSpec(BUY)
                .setIndicator(getResources().getString(R.string.buy))
                .setContent(new Intent(this,BuyActivity.class)));
        
        tabHost.addTab(tabHost.newTabSpec(NEWS)
                .setIndicator(getResources().getString(R.string.news))
                .setContent(new Intent(this,NewsActivity.class)));
        
        tabHost.addTab(tabHost.newTabSpec(SHOPS)
                .setIndicator(getResources().getString(R.string.shops))
                .setContent(new Intent(this,ShopActivity.class)));
        
        tabHost.addTab(tabHost.newTabSpec(MORE)
                .setIndicator(getResources().getString(R.string.more))
                .setContent(new Intent(this,MoreActivity.class)));
        
        tabHost.setOnTabChangedListener(new OnTabChangeListener(){
        	public void onTabChanged(String tabId) {
        		
//        		Log.d(TAG, "OnTab changed-----------------------------");
//      			TableLayout homeShowFrame = (TableLayout)MainActivity.this.findViewById(R.id.homeShowLayout);
//      			if(homeShowFrame != null)
//      			{
//      				tabFrame.removeView(homeShowFrame);
//      			    tabFrame.invalidate();	
//      			}      			
      			TableLayout homeShowFrame = (TableLayout)MainActivity.this.findViewById(R.id.homeShowLayout);
      			if(homeShowFrame != null)
      			{
      				homeShowFrame.setVisibility(View.GONE);      			    	
      			}
      			tabFrame.invalidate();
        	}          	
          }       	
       	
       	);     
        
//        TabClickListener clickListener = new TabClickListener();
//        tabWidget.getChildAt(0).setOnClickListener(clickListener);

		LayoutInflater.from(MainActivity.this).inflate(
				 R.layout.homeshow, tabHost.getTabContentView(), true);
		
		// When press home button or create main activity, show the products pics of main page
        btnHome = (ImageView)findViewById(R.id.homeButton);
        btnHome.setOnClickListener( new OnClickListener(){
			public void onClick(View v) {			
				TableLayout homeShowFrame = (TableLayout)MainActivity.this.findViewById(R.id.homeShowLayout);
				if(homeShowFrame != null)
				{
					 homeShowFrame.setVisibility(View.VISIBLE);
					 Log.d(TAG, "Set as visible.");					 
				}
				else
				{					
					LayoutInflater.from(MainActivity.this).inflate(
						 R.layout.homeshow, tabHost.getTabContentView(), true);
				}
			}        	
        });   
      
      //when press the products button, enter into the products tab
      prdCateButton = (Button)findViewById(R.id.prdCateButton);      
      prdCateButton.setOnClickListener(new OnClickListener(){  
    		public void onClick(View v) {    			
    			TableLayout homeShowFrame = (TableLayout)MainActivity.this.findViewById(R.id.homeShowLayout);
    			if(homeShowFrame != null)
    			{
    				Log.d(TAG, "Begin to remove homeshow Frame.");
    				homeShowFrame.setVisibility(View.GONE);			    
    			}
              
    			Log.d(TAG, "Prd category button is clicked.");
    			tabHost.setCurrentTab(0);   //TODO: improve to find the right index of products tab
    			tabFrame.invalidate();	
    		}
      });
      
      //search action
      AutoCompleteTextView searchBox = (AutoCompleteTextView)findViewById(R.id.searchBox);
      searchBox.setOnClickListener(new OnClickListener()
      {

		  public void onClick(View v) {
			 onSearchRequested();			
		  }
    	  
      });
      
      
//      ImageView pcImage = (ImageView)findViewById(R.id.pcImage);
//      pcImage.setOnTouchListener( new OnTouchListener(){
//
//		public boolean onTouch(View v, MotionEvent event) {
//
//			// TODO Auto-generated method stub
////			  AnimationSet animSet = new AnimationSet( 
////					  AnimationUtils.loadAnimator(MainActivity.this.getApplicationContext(),
////					    R.anim.property_animator));
//			  
//			  Animation translator = new TranslateAnimation(0.0f, 0.0f, 0.0f, -20f);
//			  translator.setInterpolator(new LinearInterpolator());
//			  translator.set
//			  
//			  
////			  Animation animBounce = new TranslateAnimation(0.0f, 0.0f, 0.0f, 20f);
////			  
////			  animBounce.setDuration(1000);
////			  animBounce.setRepeatCount(Animation.INFINITE);
////			  
////			  animBounce.setInterpolator(new BounceInterpolator());
//
//			  
////			  v.startAnimation(animBounce);
//			  return false;
//			  
//		}
//    });
    
    }
//    class TabClickListener implements OnClickListener{
//
//    	 public void onClick(View v)
//    	 {
//			TableLayout homeShowFrame = (TableLayout)MainActivity.this.findViewById(R.id.homeShowLayout);
//			if(homeShowFrame != null)
//			{
//				homeShowFrame.setVisibility(View.GONE);
//			    tabFrame.invalidate();	
//			}
//    	 }
//    	
//    }
    
    

}
