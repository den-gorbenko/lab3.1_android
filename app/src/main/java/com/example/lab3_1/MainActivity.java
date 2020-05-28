package com.example.lab3_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<Fruit> data = createList();
        ListView list = findViewById(R.id.list);

        // Create an adapter object
        MyAdapter adapter = new MyAdapter(this, data);

        // Pass it to the list widget
        list.setAdapter(adapter);

        // clicking on item
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //send data to second activity
                intent.putExtra("Name", ((Fruit)list.getItemAtPosition(i)).getName());
                intent.putExtra("origin", ((Fruit)list.getItemAtPosition(i)).getOrigin());
                intent.putExtra("description", ((Fruit)list.getItemAtPosition(i)).getDescription());
                intent.putExtra("image", ((Fruit)list.getItemAtPosition(i)).getAvatarId());

                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Fruit> createList() {

        List<Fruit> Fruits = new ArrayList<>();

        // putting data to list
        Fruits.add(new Fruit("Apple",
                R.drawable.apple,
                "An apple is a sweet, edible fruit produced by an apple tree (Malus domestica). Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe and were brought to North America by European colonists.",
                "China/USA/Poland"));
        Fruits.add(new Fruit(
                "Banana",
                R.drawable.banana,
                "A banana is an edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe. The fruits grow in clusters hanging from the top of the plant.",
                "Africa"));
        Fruits.add(new Fruit(
                "Grape",
                R.drawable.grape,
                "A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis.  Grapes can be eaten fresh as table grapes or they can be used for making wine, jam, grape juice, jelly, grape seed extract, raisins, vinegar, and grape seed oil. Grapes are a non-climacteric type of fruit, generally occurring in clusters.",
                "Algeria"));
        Fruits.add(new Fruit(
                "Mandarin",
                R.drawable.mandarin,
                "The mandarin orange (Citrus reticulata), also known as the mandarin or mandarine, is a small citrus tree with fruit resembling other oranges, usually eaten plain or in fruit salads. The tangerine is a group of orange-coloured citrus fruit consisting of hybrids of mandarin orange.  Mandarins are smaller and oblate, rather than spherical, like the common oranges (which are a mandarin hybrid). The taste is considered less sour, as well as sweeter and stronger.",
                "China"));
        return Fruits;
    }



    // class for list items
    class Fruit {
        private String Name;
        private String description;
        private int avatarId;
        private String origin;

        public Fruit(String Name,int avatarId, String description, String origin) {
            this.Name = Name;
            this.description = description;
            this.avatarId = avatarId;
            this.origin = origin;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getAvatarId() {
            return avatarId;
        }

        public void setAvatarId(int avatarId) {
            this.avatarId = avatarId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
    }
}





