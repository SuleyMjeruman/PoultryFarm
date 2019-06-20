package com.ictmcd.poultrykuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class protozoa extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protozoa);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Protozoa");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<data> mList = new ArrayList<>();

        mList.add(new data("KUHARA DAMU (COCCIDIOSIS)",R.drawable.coccidiosis,"Kuhara damu","Mbawa kushuka","Kuzubaa na kuacha kutaga","Kukosa hamu ya kula","Kupunguza kasi ya ukuaji na uzito","Kwa kawaida vifo ni vingi","","","","","","","Maranda na aina nyingine za malalo yawe makavu wakati wote.","Fuga kuku kwenye mabanda yenye sakafu isiyo na matundu","Vyombo vya chakula na maji visiwekwe chini, vining’inie juu ya sakafu kuzuia kuchafuliwa na kinyesi","Banda lisiwe na msongamano mkubwa wa kuku","Weka utaratibu wa kuhakikisha wafanyakazi, wageni na ndege hawaingii hovyo kwenye shamba/banda","Angamiza mizoga yote kwa njia stahiki kwa kuchoma moto au kufukia kwenye shimo refu ardhini. Pia na maranda na vifaa vilivyochafuliwa vichomwe.","Kutumia dawa za tiba kwa ajili ya kinga. Hii ifanyike kwa muda mfupi kuepuka kuleta usugu wa vimelea","Pata ushauri wa daktari","Amprolium hydrochloride","Sulfa","Pata ushauri wa daktari",""));
        //mList.add(new data("",R.drawable.nipple,"","","","","","","","","","","","","","","","","","","","","","","",""));

        Adapter adapter = new Adapter(this,mList);
        recyclerView.setAdapter(adapter);


    }
}
