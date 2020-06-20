package com.example.studievolghsl;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[],s2[],s3[],s4[],s5[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //basic app met navbar
        FloatingActionButton fab = findViewById(R.id.FilterKnoppie);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notes)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        recyclerView = findViewById(R.id.GradeView);

        //gooi items uit strings.xml naar een array
        s1 = getResources().getStringArray(R.array.vakken);
        s2 = getResources().getStringArray(R.array.jaar);
        s3 = getResources().getStringArray(R.array.Grade);
        s4 = getResources().getStringArray(R.array.TypeOfModule);
        s5 = getResources().getStringArray(R.array.ECTS);
        //Geef alle data mee aan een adapter/handler, Die gooit het mooi in een Recycler view die je eerder heb aangemaakt.
        GradeViewAdapter myAdapter = new GradeViewAdapter(this, s1, s2, s3, s4, s5);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //main() bevat het volgende:
        //LoadMainScreen() = Geeft een loading screen

        //CheckIfProfileIsSet() = Kijk of je al personal preferences op dit appraat heb staan of niet. Beslist aan de hand daarvan of
        //het nog personal prefs moet gooien in een bestand of bestand uitleest voor personal prefs

        //if CheckIfProfileIsSet() == false
            //SetProfile() = Maak profiel aan in een lokaal bestand als deze nog niet is aangemaakt
        //elif CheckIfProfileIsSet() == true
            //LoadProfile() = Laad profiel uit lokaal bestand
        //else give error message?! beetje raar want boolean geeft maar twee waarden.

        //LoadNavBar() = Navigatie balk met daarin de knoppen voor vakken/cijferoverzicht, Gemiddeldes/analysis en notities
        //InitFilter() = Bedoelt voor de settings van de huidige view en wat algemene app info. Maak hierin onderscheid tussen leerjaren en normale/keuzevakken/projecten.

        //InitMainScreen() = Vul main screen met alle vakken cijfers uit het profiel
            //LoadModules()
            //LoadGrades()
            //ApplyFilter()
        //InitAnalysisScreen() = Vul het tweede scherm met alle grafieken van gemiddeldes en Piecharts waarop te zien is hoeveel ECTS nog te gaan zijn per jaar.
            //LoadGrades()
            //LoadGraphs()
            //ApplyFilter()
        //InitNotesScreen() = Vul het derde scherm met alle vakken + bijbehorende notities, geef optie om notes toe te voegen en realtime op te slaan in het profiel.
            //LoadModules()
            //LoadNotes()
            //AddNotes()
            //ApplyFilter()

}