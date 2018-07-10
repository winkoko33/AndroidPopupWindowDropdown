package com.globaltech.dropdownmenu.model;

import com.globaltech.dropdownmenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin2 on 10/Jul/2018.
 */

public class Category {
    public long id;
    public int iconRes;
    public String category;

    public Category(long id, int iconRes, String category){
        super();
        this.id = id;
        this.iconRes = iconRes;
        this.category = category;
    }

    public static List<Category> generateCategoryList(){
        List<Category> categories = new ArrayList<>();
        String[] programming = {"C++", "JAVA", "JAVASCRIPT", "C#", "Objective C", "SWIFT"};

        for(int i = 0; i < programming.length; i++){
            categories.add(new Category(i, R.drawable.ic_insert_emoticon_black_24dp, programming[i]));
        }
        return categories;
    }
}
