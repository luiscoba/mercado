package com.mercado.a.domicilio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mercado.a.domicilio.config.bar_main.ViewPagerAdapter;
import com.mercado.a.domicilio.config.utils.Permiso;
import com.mercado.a.domicilio.modulos.producto.Producto;
import com.mercado.a.domicilio.navigation.bottom.categoria.CategoriaFragment;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.SubCategoriaFragment;
import com.mercado.a.domicilio.navigation.bottom.categoria.categoria.subCategoria.subCategoria.ContenidoSubCategoria;
import com.mercado.a.domicilio.navigation.bottom.mercado.dummy.DummyContent;
import com.mercado.a.domicilio.navigation.bottom.mercado.listasFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import pedidos_a_domicilio.BeanCategoria;

public class MainActivity extends AppCompatActivity implements CategoriaFragment.OnListFrgInteractionListenerCategoria
                                                                ,listasFragment.OnListFragmentInteractionListener
                                                                , SubCategoriaFragment.OnListFrgInteractionListenerSubCategoria {

    private MenuItem prevMenuItem;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            toolbar.setTitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_categorias:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_carrito:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snack_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_show_snack_bar:
                showSnackBar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSnackBar() {
        Snackbar.make(bottomNavigationView, "Some text", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);//setContentView(R.layout.activity_main);

        Permiso.ejecutar_dispositivos_sdk_int_9();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setClipToPadding(false);//para que no se quede a la mitad el viewPager
        viewPager.setPadding(40,0,40,0);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bindNavigationDrawer();
        initTitle();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                // nos fijamos que si se selecciona la pagina indicada
                // Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager();
    }

    // cargamos el bottoBar
    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Creacion de los 3 fragments del bottomBar
        Fragment listasFragment1 = listasFragment.newInstance(2);
        Fragment itemFragment2 = CategoriaFragment.newInstance(2);
        Fragment itemFragment3 = CategoriaFragment.newInstance(3);

        adapter.addFragment(listasFragment1);
        adapter.addFragment(itemFragment2);
        adapter.addFragment(itemFragment3);

        viewPager.setAdapter(adapter);
        // para que no se carguen los 3 fragmentos en memoria sino 2 fragmentos
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
    }

    private void initTitle() {
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                toolbar.setTitle(bottomNavigationView.getMenu().getItem(0).getTitle());
            }
        });
    }

    private void bindNavigationDrawer() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_notificaciones) {
                    showToolSnackBar();
                } else if (id == R.id.nav_compras) {
                    showGallerySnackBar();
                } else if (id == R.id.nav_favoritos) {
                    showSendSnackBar();
                } else if (id == R.id.nav_cuenta) {
                    showShareSnackBar();
                } else if (id == R.id.nav_cerrar) {
                    Intent intent = new Intent(MainActivity.this, Producto.class);
                    startActivity(intent);
                }
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }


        });
    }

    private void showSendSnackBar() {
        Snackbar.make(bottomNavigationView, "Send", Snackbar.LENGTH_SHORT).show();
    }

    private void showGallerySnackBar() {
        Snackbar.make(bottomNavigationView, "Gallery", Snackbar.LENGTH_SHORT).show();
    }

    private void showToolSnackBar() {
        Snackbar.make(bottomNavigationView, "Tool", Snackbar.LENGTH_SHORT).show();
    }

    private void showShareSnackBar() {
        Snackbar.make(bottomNavigationView, "Share", Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public void onListFrgInteractionCategoria(BeanCategoria beanCategoria) {

    }
    @Override
    public void onListFrgInteractionSubCategoria(ContenidoSubCategoria.DummyItem item) {

    }
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }


}
