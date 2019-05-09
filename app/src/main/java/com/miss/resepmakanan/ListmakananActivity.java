package com.miss.resepmakanan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListmakananActivity extends AppCompatActivity {

    String[] nama ={"donat",
            "nasiuduk",
            "soto",
            "kolakpisang",
            "goreng",
            "satepadang",
            "cotomakasar",
            "jalangkote",
            "rendang",
            "ayamgeprek"};

    String [] url = {"https://www.fimela.com/lifestyle-relationship/read/3773770/20-resep-cara-membuat-donat-gampang-dan-sederhana-dijamin-enak-dan-empuk",

    "https://www.merdeka.com/gaya/resep-dan-cara-membuat-nasi-uduk-enak-dan-spesial-serta-mudah-di-rumah-kln.html",

    "https://www.merdeka.com/gaya/4-resep-dan-cara-membuat-soto-ayam-bening-enak-dan-sederhana-kln.html",

    "https://www.idntimes.com/food/recipe/muda-creation/resep-kolak-pisang-yang-super-gampang-c1c2",

    "https://www.merdeka.com/gaya/cara-membuat-nasi-goreng-spesial-dan-rumahan-yang-enak-sederhana-serta-mudah-kln.html",

    "http://www.tokomesin.com/3-cara-membuat-sate-padang-lezat-yang-menggoda-selera.html",

    "https://id.tastemade.com/videos/coto-makassar",

    "https://widhiaanugrah.com/resep-jalakotek-yang-enak-banget/",

    "https://www.merdeka.com/gaya/resep-masak-rendang-daging-padang-kln.html",

    "http://www.nadipos.com/blog/resep-sambal-ayam-geprek/" };

    int[] gambar = {R.drawable.donat,R.drawable.nasiuduk,R.drawable.soto,R.drawable.kolakpisang,
            R.drawable.goreng,R.drawable.satepadang,R.drawable.cotomakasar,R.drawable.jalangkote,R.drawable.rendang,
            R.drawable.ayamgeprek};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listilmuan);

        ListView listView = findViewById(R.id.lstisi);
        CustomListviewAdapter customListviewAdapter = new CustomListviewAdapter();
        listView.setAdapter(customListviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new  Intent(ListmakananActivity.this, DetailmakananActivity.class);
                i.putExtra("putgambar" , gambar[position]);
                i.putExtra("putNama", nama[position]);
                i.putExtra("putUrl", url[position]);
                startActivity(i);
            }
        });
    }
    class CustomListviewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return gambar.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.activity_customlistviewactivity, null);

            ImageView imageView = convertView.findViewById(R.id.imgIlmuan);
            TextView textView = convertView.findViewById(R.id.txtIlmuan);

            imageView.setImageResource(gambar[position]);
            textView.setText(nama[position]);
            return convertView;
        }
    }

}
