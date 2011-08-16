/*
 * Copyright (C) 2011 Candzen, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.candzen.productguide;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TabHost;



public class ProductsActivity extends Activity{
	
	EditText conditionHint;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        setContentView(R.layout.products);
    
        Resources res = getResources();
	    TabHost tabHost = (TabHost)findViewById(R.id.tabhostCategroy); 
	    tabHost.setup();
	
	    LayoutInflater.from(this).inflate(R.layout.tablayout, tabHost.getTabContentView(), true); 
	    
	    tabHost.addTab(tabHost.newTabSpec("prdGuide")
	            .setIndicator(res.getString(R.string.prdGuide))
	            .setContent(R.id.prdGuideLayout));
	    
	    conditionHint =(EditText)findViewById(R.id.conditionHint);
	    conditionHint.setHint(res.getString(R.string.paraDistance));
	    conditionHint.setEnabled(false);
    
	    tabHost.addTab(tabHost.newTabSpec("ParaSearch")
	            .setIndicator(res.getString(R.string.ParaSearch))
	            .setContent(R.id.paraLayout));
	    tabHost.addTab(tabHost.newTabSpec("allPrdlines")
	            .setIndicator(res.getString(R.string.allPrdlines))
	            .setContent(R.id.allPrdLinesLayout));
	    tabHost.addTab(tabHost.newTabSpec("Maximize")
	            .setIndicator("",res.getDrawable(R.drawable.maximize))
	            .setContent(R.id.maxize));
	    

    }
}