# Stack Viewpager 
   
## Setup
Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven { 
            url 'https://jitpack.io'
        }
    }
}
```
#### Dependency
[![](https://jitpack.io/v/com.github.appsfeature/stack-view-pager.svg)](https://jitpack.io/#com.github.appsfeature/stack-view-pager)
```gradle
dependencies {
        implementation 'com.github.appsfeature:stack-view-pager:x.y'
}
```

#### Usage method
In your activity class:
```java 

    public class MainActivity extends AppCompatActivity {
    
        private OrientedViewPager mOrientedViewPager;
        private StackFragmentAdapter mContentFragmentAdapter;
        private List<Fragment> mFragments = new ArrayList<>();
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            mOrientedViewPager = (OrientedViewPager) findViewById(R.id.view_pager);
    
            for (int i = 0; i < 10; i++) {
                mFragments.add(CardFragment.newInstance(i + 1));
            }
    
            mContentFragmentAdapter = new
                    StackFragmentAdapter(getSupportFragmentManager(), mFragments);
            mOrientedViewPager.setOrientation(OrientedViewPager.Orientation.VERTICAL);
            mOrientedViewPager.setOffscreenPageLimit(3);
            mOrientedViewPager.setPageTransformer(true, new VerticalStackTransformer(getApplicationContext()));
            mOrientedViewPager.setAdapter(mContentFragmentAdapter);
    
        }
    }


```

 #### Usage method
 In your activity.xml file:
 ```xml  
     <com.stack.viewpager.OrientedViewPager
                 android:id="@+id/view_pager"
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:background="#F7F9FC" /> 
 
 ```
 #### Usage method
 In your fragment_card.xml file:
 ```xml  
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:card_view="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:focusable="false"
        android:orientation="vertical">
    
        <android.support.v7.widget.CardView
            android:id="@+id/card_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginLeft="20dp"
            android:layout_marginTop="20dp"
            android:layout_marginRight="20dp"
            android:layout_marginBottom="50dp"
            android:focusable="false"
            card_view:cardElevation="4dp">
    
            <TextView
                android:id="@+id/card_num_tv"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:autoSizeMaxTextSize="16sp"
                android:ellipsize="end"
                android:maxLines="25"
                android:paddingLeft="16dp"
                android:paddingTop="16dp"
                android:paddingRight="16dp"
                android:paddingBottom="20dp"
                android:text="@string/sample_data"
                android:textSize="16sp" />
    
        </android.support.v7.widget.CardView>
    
    
    </LinearLayout>
 
 ```