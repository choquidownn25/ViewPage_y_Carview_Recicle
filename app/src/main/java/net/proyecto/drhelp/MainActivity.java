package net.proyecto.drhelp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import net.proyecto.drhelp.adaptador.CardAdapter;
import net.proyecto.drhelp.adaptador.GridViewAdapter;
import net.proyecto.drhelp.androidchat.MainActivityChat;
import net.proyecto.drhelp.entity.Movie;
import net.proyecto.drhelp.ui.GridAdapter;
import com.github.captain_miao.optroundcardview.OptRoundCardView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CardAdapter.Listener{


    //Creamos la vista de la actividad
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private SectionsPagerAdapter mSectionsPagerAdapters;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ViewPager mViewPagers;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    CardAdapter mAdapters;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> alName;
    ArrayList<Integer> alImage;


    //Dependencias de instancias globales
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    //Botom
    //private Button button;
    Context context;
    Activity contexts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = getApplicationContext();
        contexts = getParent();
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapters = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //
        mViewPagers = (ViewPager) findViewById(R.id.containers);
        mViewPagers.setAdapter(mSectionsPagerAdapters);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //com.github.captain_miao.optionroundcardview



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void subCarca(){
        Intent intent = new Intent(this, MainActivityChat.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            subCarca();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClicked(Movie movie) {
        if(movie != null){
            Toast.makeText(this, "You just selected " + movie.name + "!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        //Atributos
        RecyclerView mRecyclerView;
        //CardView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        RecyclerView.Adapter mAdapter;
        ArrayList<String> alName;
        ArrayList<Integer> alImage;


        //Atributos
        private GridView gridView;
        private GridViewAdapter gridViewAdapter;
        private ImageButton OrdenServicio;
        private ImageButton Auditoria;

        //Dependencias de instancias globales
        private RecyclerView recycler;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager lManager;

        Context context;
        Activity contexts;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int section = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            contexts = getActivity();
            OptRoundCardView roundCardView;
            context=getActivity();
            switch (section){
                case 1:
                    roundCardView = (OptRoundCardView) rootView.findViewById(R.id.bottom_card_view);
                    roundCardView.showCorner(false, false, false, false);
                    break;
                case 2:
                    roundCardView = (OptRoundCardView) rootView.findViewById(R.id.top_card_view);
                    roundCardView.showCorner(false, false, false, false);
                    break;
                default:
                    break;
            }


            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, section));

            Button  button = (Button)rootView.findViewById(R.id.actualizar);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


            alName = new ArrayList<>(Arrays.asList("Orden de Servicio", "Auditoria", "En construccion", "Posicion en el Mapa"));
            ///alName = new ArrayList<>(Arrays.asList("Orden de Servicio", "Auditoria", "En construccion"));
            alImage = new ArrayList<>(Arrays.asList(R.drawable.logo_sigti_192, R.drawable.logo_sigti_camara_192, R.drawable.ingeniero,
                    R.drawable.mapas_icono));



            // Calling the RecyclerView
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
            mRecyclerView.setHasFixedSize(true);

            // The number of Columns
            mLayoutManager = new GridLayoutManager(context, 2);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new GridAdapter(context, alName, alImage);
            mRecyclerView.setAdapter(mAdapter);



            return rootView;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Top corner";
                case 1:
                    return "Bottom corner";
                case 2:
                    return "Full corner";
            }
            return null;
        }
    }
}
