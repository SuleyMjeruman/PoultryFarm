package com.ictmcd.poultrykuku;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class virusi extends AppCompatActivity {
Toolbar toolbar;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virusi);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Virusi");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<data> mList = new ArrayList<>();

        mList.add(new data("MDONDO/KIDERI (NEWCASTLE DISEASE)",R.drawable.newcastle,"Vifo vya ghafla vya idadi kubwa ya kuku katika shamba/banda",
                "Kuku wanatetemeka na kushindwa kutembea",
                "Kuku hupooza miguu, mabawa na kupinda shingo,   na hujizungusha mahali alipo",
                "Kuku huharisha kinyesi cha kijani na wakati mwingine chenye mchanganyiko wa rangi ya njano",
                "Kuku huzubaa na kuacha kula","Kuku hukohoa, hupiga chafya na kupumua kwa shida",
                "Vifo vinaweza kufikia asilimia 100, kutegemea na umri na aina ya ndege",
                "Kutokwa ute mdomoni na puani","Kuharisha kijani","Kupoteza hamu ya kula",
                "Manyoya kuvurugika","Kuku wanaotaga hupunguza utagaji, hutaga mayai yenye ganda laini.",
                "Weka utaratibu wa kuhakikisha wafanyakazi, wageni na ndege hawaingii hovyo kwenye shamba/banda",
                "Angamiza mizoga yote kwa njia stahiki kwa kuchoma moto au kufukia kwenye shimo refu ardhini.",
                "Hakikisha banda la kuku lina hewa ya kutosha na epuka msongamano mkubwa wa kuku",
                "Fanya usafi wa mara kwa mara kwenye vyombo vya kuwekea maji na chakula, pamoja na mabanda ya kuku.",
                "Zuia uingizaji holela wa kuku wageni wasiochanjwa kwenye shamba/banda. Kuku wanaoingia shambani/bandani watoke maeneo yasiyokuwa na ugonjwa.",
                "Tenganisha kuku kufuatana na umri",
                "Maeneo yenye ugonjwa yawekwe chini ya karantini   na mabanda yapulizwe dawa",
                "Kuku wapewe Chanjo tangu vifaranga wa umri wa siku 3, baada ya wiki 3 – 4, na baadaye kila baada ya miezi 3.",
                "Mdondo hauna tiba kwa hiyo unakingwa kwa chanjo Kuku wachanjwe mara baada ya kutotolewa bila kusubiri mzunguko au ratiba ya chanjo inayofuata katika eneo husika.",
                "Pata ushauri wa daktari.","Japo chanjo ya I-2 Thermostable, ni muhimu ihifadhiwe sehemu kavu na yenye ubaridi wa kawaida isipate joto, la sivyo itaharibika na haitafaa tena kwa chanjo. Pia unaposafirisha dawa hii tumia chombo amacho hakitaruhusu dawa kupata joto. Vile vile wakat wa kuchanja shughuli hii ifanyie kivulini dawa isipate mionzi ya jua.",
                ""));

        mList.add(new data("GUMBORO (INFECTIOUS BURSAL DISEASE)",R.drawable.gumboro,"Uharo mweupe wenye maji","Kuku wanadonoana kwenye sehemu ya kupitishia haja, na sehemu hii huvimba","Kuku hulala kifudifudi","Kuku wanashindwa kutembea na wanatetemeka","Vifo vya kuku vinaweza kufikia hadi asilimia 30, na kupungua jinsi wanavyozeeka","","","","","","","","Mizoga, makapi na vifaa vingine vilivyochafuliwa na kuku wagonjwa vichomwe moto au kuzikwa.","Weka utaratibu madhubuti wa kupuliza dawa za viuatilifu vinavyofaa","Baada ya kumaliza kuwauza kuku wote, fanya usafi wa mabanda na kupuliza dawa","Weka utaratibu wa kuhakikisha wafanyakazi, wageni na ndege hawaingii hovyo kwenye shamba/banda","Kuku wapatiwe Chanjo katika maji ya kunywa     (angalia Ratiba)","","","","Hakuna tiba maalum","Kuku wapewe vitamini na maji kwa wingi","Antibiotiki husaidia maambukizi nyemelezi.","Pata ushauri wa daktari"));

        mList.add(new data("NDUI YA KUKU (FOWL POX)",R.drawable.fowl_pox,"Ugonjwa unapoathiri ngozi hutokea vidutu vikubwa vya rangi ya kijivu au kahawia kwenye upanga, undu, macho na mdomoni","Ugonjwa unapoathiri sehemu laini za mwili, mabaka madogo meupe hutokea kwenye kona za mdomo, kuzunguka ulimi, ndani ya mdomo na kwenye koo","Vifo vinaweza kufika hadi asilimia 50","","","","","","","","","","Kuku wote walioathirika waondolewe shambani/bandani.","Mizoga, makapi na vifaa vingine vilivyochafuliwa na kuku wagonjwa vichomwe moto au kuzikwa.","Pulizia kemikali za kuua wadudu","Weka utaratibu madhubuti wa kupuliza dawa za viuatilifu vinavyofaa japokuwa inawezekana visiuwe virusi wote","Kuku wapatiwe Chanjo wakiwa na wiki 6. Maeneo mengine chanjo inatakiwa kufanywa mapema zaidi. (Angalia Ratiba).","","","","Hakuna tiba","Kuku wanaweza kupewa vitamini na glucose kupunguza makali ya ugonjwa","Antibiotiki na maji yenye chumvi husaidia    maambukizi nyemelezi.","Pata ushauri wa daktari."));
        //mList.add(new data("",R.drawable.nipple,"","","","","","","","","","","","","","","","","","","","","","","",""));


        Adapter adapter = new Adapter(this,mList);
        recyclerView.setAdapter(adapter);
    }


}
