package com.globaltech.dropdownmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.globaltech.dropdownmenu.model.Category;

public class MainActivity extends AppCompatActivity {
    AppCompatTextView tvPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPicker = findViewById(R.id.tvPicker);
        tvPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCategoryMenu();
            }
        });
    }

    private void showCategoryMenu(){
        final CategoryDropdownMenu menu = new CategoryDropdownMenu(this);
        menu.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        menu.setWidth(getPxFromDp(200));
        menu.setOutsideTouchable(true);
        menu.setFocusable(true);
        menu.showAsDropDown(tvPicker);
        menu.setCategorySelectedListener(new CategoryDropdownAdapter.CategorySelectedListener() {
            @Override
            public void onCategorySelected(int position, Category category) {
                menu.dismiss();
                Toast.makeText(MainActivity.this, "Your favourite programming language : "+ category.category, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Convert DP to Pixel
    private int getPxFromDp(int dp){
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}
