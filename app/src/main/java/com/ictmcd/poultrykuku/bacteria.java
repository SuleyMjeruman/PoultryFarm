package com.ictmcd.poultrykuku;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class bacteria extends AppCompatActivity {
Toolbar toolbar;
RecyclerView recyclerView;
    ViewGroup container;
    ImageView imageView;
    List<ImageView> imageViewList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacteria);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Bacteria");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<data> mList = new ArrayList<>();

        mList.add(new data("HOMA KALI YA MATUMBO (FOWL TYPHOID)",R.drawable.fowl_typhoid,"Kuharisha kinyesi cha majimaji na cha rangi ya njano.","Vifo vya ghafla.","Kupauka kwa upanga na masikio kwa sababu ya kupungukiwa damu.","Manyoya hutimka, hushusha mbawa, hufumba macho na kuzubaa (kuvaa koti).","Vifaranga wanatotolewa wakiwa wamekufa au dhaifu.","Hujikusanya pamoja na kukosa hamu ya kula.","Kinyesi cha rangi ya njano na huganda kwenye manyoya ya sehemu ya kutolea haja.","Hupumua kwa haraka na kwa shida.","Vifo vingi huweza kutokea kuku wasipotibiwa.","","","","Hakikisha kwamba vifaranga wako wanatoka katika mashamba ambayo hayana huu ugonjwa.","Weka utaratibu wa kuhakikisha watu, wanyama, ndege wa aina nyingine na ndege wa porini hawazururi shambani","Panga utaratibu wa kuchunguza afya za kuku wako mara kwa mara na kuondoa/kuchinja kuku wanaoonyesha dalili za ugonjwa","Fanya usafi wa mabanda na mazingira mara kwa mara unapobadilisha makundi ya kuku kwa kutumia viuatilifu vilivyopendekezwa","","","","","Yapo madawa mengi aina ya antibiotiki ambayo yanaweza kupunguza vifo vinavyotokana na ugonjwa. Lakini madawa haya hayawezi kumaliza kabisa ugonjwa kutoka shambani.","Pata ushauri wa daktari.","",""));
        mList.add(new data("HOMA YA MATUMBO (AVIAN PARATYPHOID)",R.drawable.avian,"Vifo vya ghafla Kuharisha kinyesi cha majimaji na   cha rangi ya njano.","Kuku kuharisha","Kupungua kwa uzito","Kuku wa mayai hupunguza utagaji.","Kuku anaonekana mchovu.","Vifaranga wanatotolewa wakiwa wamekufa au mara tu baada ya kuanguliwa.","Hujikusanya pamoja karibu na joto.","Uharo kuganda kwenye manyoya ya sehemu ya kutolea haja.","Vifo kwenye vifaranga vinaweza kufikia hadi asilimia 50.","","","","Hakikisha kwamba vifaranga wako wanatoka katika mashamba ambayo hayana huu ugonjwa.","Panga utaratibu wa kuchunguza afya za kuku wako mara kwa mara na kuondoa/kuchinja kuku wanaonyesha dalili za ugonjwa.","Weka utaratibu wa kuhakikisha watu, wanyama, ndege wa aina nyingine na ndege wa porini hawazururi shambani.","Fanya usafi wa mabanda na mazingira mara kwa mara unapobadilisha makundi ya kuku kwa kutumia viuatilifu vilivyopendekezwa.","Mayai yakusanywe mara kwa mara","Hakikisha vifaranga wanapata joto la kutosha.","","","Yapo madawa mengi aina ya antibiotiki na sulfa ambayo yanaweza kupunguza vifo vinavyotokana naugonjwa. Lakini madawa haya hayawezi kumaliza kabisa ugonjwa kutoka shambani.","Pata ushauri wa daktari.","",""));
        mList.add(new data("KUHARISHA KINYESI CHEUPE (BACILLARY WHITE DIARRHOEA)",R.drawable.white_diarrhoea,"Vifo vya ghafla","Vifaranga wanatotolewa wakiwa wamekufa au   dhaifu","Hujikusanya pamoja karibu na taa kwa ajili ya kupata joto","Uharo wa rangi nyeupe kama chaki","Hupumua kwa shida","Uharo huganda kwenye manyoya ya sehemu ya kutolea haja","Vifaranga wanapiga sana kelele","Vifaranga wanaonyesha ulemavu","Kuvimba magoti","Kuku wakubwa huonyesha dalili za ugonjwa sugu","Kupauka kwa upanga na masikio kwa sababu ya kupungukiwa damu","Utagaji wa mayai hupungua","Hakikisha kwamba vifaranga wako wanatoka katika vyanzo vilivyothibitishwa kuwa havina huu ugonjwa","Tengeneza utaratibu wa kufanya usafi wa mabanda na mazingira mara kwa mara unapobadilisha makundi ya kuku kwa kutumia viuatilifu vilivyopendekezwa.","Panga utaratibu wa kuchunguza afya za kuku wote wenye umri zaidi ya miezi mitano (5) mpaka hapo kundi lote litakapoonyesha kwamba hakuna kuku mwenye maambukizi, kuku salama wahamishiwe katika mabanda safi","Weka utaratibu wa kuhakikisha watu, wanyama, ndege wa aina nyingine na ndege wa porini hawazururi shambani au bandani. ","","","","","Yapo madawa mengi aina ya antibiotiki ambayo yanaweza kupunguza vifo vinavyotokana na ugonjwa. Lakini madawa haya hayawezi kumaliza ugonjwa shambani kabisa.","Pata ushauri wa daktari.","",""));
        mList.add(new data("KIPINDUPINDU CHA KUKU (FOWL CHOLERA)",R.drawable.chorela,"Vifo vya ghafla vya idadi kubwa ya kuku waliokuwa   na afya","Kuku wanakonda","Kuku wanapumua kwa shida, wanakohoa na kupiga chafya","Uharo wa rangi ya kijivu, njano au kijani na unaonuka","Vifaranga wanaonyesha ulemavu","Kuvimba magoti na kifundo cha mbawa","Kichwa, upanga na undu hugeuka kuwa rangi nyeusi au zambarau","Vifo vya kuku vinaweza kufikia asilimia","","","","","Utaratibu ulio mzuri zaidi ni kuondoa kuku wote kutoka kwenye shamba/banda ambalo ugonjwa umethibitishwa, kupuliza dawa za viuatilifu kabla ya kuingiza vifaranga na kuku wapya.","Mabanda yote ya kuku yapuliziwe dawa za viuatilifu kabla ya kuingiza kuku wapya.","Kuku wapya watenganishwe na kuchunguzwa kwa muda wa angalau mwezi mmoja kabla ya kuwachanganya na kuku wengine.","Vifaranga visichanganywe na kuku wakubwa.","Hakikisha unafuata kanuni za ufugaji bora ili kuku wakue vizuri na wasiathirike","","","","Yapo madawa mengi aina ya antibiotiki na sulfa ambayo yanaweza kutumika kwa ajili ya tiba na kinga","Pata ushauri wa daktari.","",""));
        mList.add(new data("MAFUA YA KUKU (INFECTIOUS CORYZA)",R.drawable.coryza,"Makamasi mazito yenye usaha hutoka puani","Kuku anashindwa kupumua, hukohoa na kupiga chafya","Harufu mbaya kutoka kinywani na machoni","Uso mzima unavimba pamoja na upanga","Vifo vya kuku vinaweza kufikia asilimia 20","","","","","","","","Iwapo ndani ya shamba moja kuna kuku wa aina tofauti, k.m. vifaranga, kuku wazazi, kuku wakubwa, jaribu kuwatenganisha ili mabanda yao yasikaribiane","Pale inapowezekana, jaribu kupanga utaratibu wa kila kundi la kuku lishughulikiwe na mfanyakazi wake ili kuzuia kueneza maambukizi.","Hakikisha kuku wagonjwa wanatengwa na wale wazima","Tumia maji yaliyowekwa dawa aina ya klorini","Weka utaratibu wa kuhakikisha watu, wanyama, ndege wa aina nyingine na ndege wa porini ","","","","Madawa aina ya sulfa na antibiotiki yanaweza kutumika kwa ajili ya tiba na kinga.","Pata ushauri wa daktari","",""));
        //mList.add(new data("",R.drawable.nipple,"","","","","","","","","","","","","","","","","","","","","","","",""));


         Adapter adapter = new Adapter(this,mList);
        recyclerView.setAdapter(adapter);

    }


}
