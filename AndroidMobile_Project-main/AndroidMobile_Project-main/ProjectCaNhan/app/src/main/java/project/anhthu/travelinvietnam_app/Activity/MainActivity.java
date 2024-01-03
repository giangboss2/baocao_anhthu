package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import project.anhthu.travelinvietnam_app.Adapter.CategoryAdapter;
import project.anhthu.travelinvietnam_app.Adapter.PopularAdapter;
import project.anhthu.travelinvietnam_app.Domain.CategoryDomain;
import project.anhthu.travelinvietnam_app.Domain.PopularDomain;
import project.anhthu.travelinvietnam_app.R;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPopular, adapterCat;
private EditText username ;
private RecyclerView recyclerViewPopular, recyclerViewCategory;
//private FirebaseAuth auth;
//private FirebaseUser user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        username = findViewById(R.id.username);
//        user = auth.getCurrentUser();
//        if(username != null)
//            username.setText(user.getEmail());
        initRecycleView();

    }

    private void initRecycleView(){
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Chùa Long Sơn", "4 Tháp Bà, đường 2/4, Nha Trang", "Explore the beauty and serenity of Chùa Long Sơn, a pagoda nestled in the heart of Nha Trang. Immerse yourself in its rich history and architectural marvels.", "view2", true, true, 1000, 4.8));
        items.add(new PopularDomain("Vinpearl Land", "đảo Vinpearl, Nha Trang", "Embark on an unforgettable adventure at Vinpearl Land, an entertainment paradise on an island. Enjoy thrilling rides, shows, and endless fun for the whole family.", "view5", true, true, 2000, 4.8));
        items.add(new PopularDomain("Nha Trang Beach", "Phạm Văn Đồng, Nha Trang", "Relax and rejuvenate at Nha Trang Beach, a pristine stretch of golden sand along the azure waters. Let the gentle waves and scenic views create lasting memories.", "view3", true, true, 0, 4.0));
        items.add(new PopularDomain("Luxurious Resort", "1 Nguyễn Khuyến, Vĩnh Ngọc, Nha Trang", "Indulge in luxury at a resort like no other. Experience world-class amenities, breathtaking views, and unparalleled hospitality at this idyllic retreat.", "view4", true, true, 3000, 4.6));
        items.add(new PopularDomain("Trần Phú Coastal Road", "Trần Phú, Nha Trang", "Take a leisurely stroll along the iconic Trần Phú Coastal Road. Enjoy panoramic views of the sea, vibrant street life, and the charming atmosphere of Nha Trang.", "view6", true, true, 0, 3.8));
// Additional suggestions: Cham Pa Ponagar, Vien Hai Duong Hoc, Nui Co Tien, Suoi Lach, Ba Ho...

// Chua Long Son, Cham Pa Ponagar, Vien Hai Duong Hoc, VinPearl Land, Nui Co tien, Suoi Lach, Ba Ho...
    recyclerViewPopular = findViewById(R.id.view_pop);
    recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    adapterPopular = new PopularAdapter(items);
    recyclerViewPopular.setAdapter(adapterPopular);

    ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches","cat_1"));
        catsList.add(new CategoryDomain("Moutains","cat_2"));
        catsList.add(new CategoryDomain("Island","cat_3"));
        catsList.add(new CategoryDomain("Pagoda","cat_4"));
        catsList.add(new CategoryDomain("Aquarium","cat_4"));
        catsList.add(new CategoryDomain("Fountain","cat_4"));

        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);

    }
}