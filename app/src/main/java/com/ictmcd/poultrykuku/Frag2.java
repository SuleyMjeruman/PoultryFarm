package com.ictmcd.poultrykuku;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Frag2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

try {

    RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    List<fragement2_Item> mList = new ArrayList<>();
    mList.add(new fragement2_Item(R.drawable.vichanjaa,"Vichanja","Ni sehemu maalaum ya kuku kupumzikia na Kulala," +
            "Kwa asili kuku hupendelea zaidi kulala juu kama kwenye miti kwani hujisikia kuwa na usalama zaidi kuliko wakiwa katika sehemu isiyo na mahali pa kudanda.\n" +
            " Hivyo ili kuwafanya kuku wajisikie vizuri hapana budi kuwatengenezea vichanja sehemu ya nje wanaposhinda na kula chakula, na pia ndani ya banda ili kuwawezesha kulala vizuri nyakati za usiku."));
    mList.add(new fragement2_Item(R.drawable.nipple,"Chuchu","Chuchu ni kifaa ambacho kina wasaidia kuku kunywa maji kwa uraisi zaidi na pia bila ya kuchafua maji hayo.\n" +
            "Hunywesha maji kuku wengi.\n" +
            "Kuku hawachafui banda kwa kumwaga maji.\n" +
            "Kinyesi hakichanganyiki na maji hivyo maji huwa Safi muda wote.\n" +
            "Huepusha magonjwa yatokanayo na kuchanganyika kwa kinyesi na maji."));
    mList.add(new fragement2_Item(R.drawable.plat,"Sahani","Pia katuka kuifadhi chakula kwa muda, sahani hutumika kwa kazi hizo,\n" +
            "Unaweza kutumia sahani kwaajili ya kulishia kuku wa kubwa ama vifaranga"));
    mList.add(new fragement2_Item(R.drawable.vichanja,"Viota","Viota ni mahali ambapo kuku hutaga mayai, kuhatamia na kuangua vifaranga.\n" +
            " Hii inamaanisha kuwa viota ni sehemu muhimu sana ya kuzingatia ili kuweza kupata mayai mengi yaliyo salama pamoja na vifaranga."));
    mList.add(new fragement2_Item(R.drawable.drinker,"Bell drinkers","Hutumika kuwekea chakula cha kuku pamoja na maji."));

    mList.add(new fragement2_Item(R.drawable.chemli,"Taa ya chemli","Kutegemeana na hali ya hewa taa moja ya chemli inaweza kulea vifaranga 50 au zaidi.\n" +
            "Hakikisha kuwa unayo akiba ya mafuta ya taa ya kutosha, vioo, utambi n.k. Taa moja\n" +
            "hutumia debe moja la mafuta ya taa kwa muda wa siku 16 hadi 20. Unashauriwa uweke\n" +
            "mafuta kwenye taa asubuhi na kukagua jioni kama yanatosha kwa sababu taa ikizimika\n" +
            "usiku utapata hasara ya vifo kwa vifaranga kujikusanya na kukosa hewa"));
//    mList.add(new fragement2_Item(R.drawable.kifaa,"Title goes here","Description goes here"));
//    mList.add(new fragement2_Item(R.drawable.kifaa,"Title goes here","Description goes here"));
//    mList.add(new fragement2_Item(R.drawable.kifaa,"Title goes here","Description goes here"));
//    mList.add(new fragement2_Item(R.drawable.kifaa,"Title goes here","Description goes here"));
//    mList.add(new fragement2_Item(R.drawable.kifaa,"Title goes here","Description goes here"));


    fragment2_item_adapter frag2_adapter = new fragment2_item_adapter(getContext(),mList);
    recyclerView.setAdapter(frag2_adapter);
    //recyclerView.setItemAnimator(new DefaultItemAnimator());

}catch (Exception e){
    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
}



        return view;
    }


}
