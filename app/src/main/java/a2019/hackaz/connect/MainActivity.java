package a2019.hackaz.connect;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Information.OnFragmentInteractionListener,
        HomeScreen.OnFragmentInteractionListener,
        Events.OnFragmentInteractionListener,
        EnrollmentGuideHub.OnFragmentInteractionListener,
        EnrollmentGuidePage1.OnFragmentInteractionListener,
        EnrollmentGuidePage2.OnFragmentInteractionListener,
        EnrollmentGuidePage3.OnFragmentInteractionListener,
        GalleryFragment.OnFragmentInteractionListener
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        switchFragment(new HomeScreen());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeScreen();
        } else if (id == R.id.nav_information) {
            fragment = new Information();
        } else if (id == R.id.nav_events) {
            fragment = new Events();
        } else if (id == R.id.nav_gallery) {
            fragment = new GalleryFragment();
        } else if (id == R.id.nav_enrollment_guide) {
            fragment = new EnrollmentGuideHub();
        }

        if(fragment != null) {
            switchFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onInformationButtonClicked(View view) {
        switchFragment(new Information());
    }

    public void onEnrollmentClicked(View view) {
        switchFragment(new EnrollmentGuideHub());
    }

    public void onNewClicked(View view) {
        launchBrowser("http://www.admissions.arizona.edu/");
    }
    public void onEventsClicked(View view) {
        switchFragment(new Events());
    }

    public void onVetsWebsiteClicked(View view) {
        launchBrowser("http://vets.arizona.edu/");
    }
    public void onQuickGuideClicked(View view) {
        switchFragment(new EnrollmentGuidePage1());

    }
    public void onDetailedInformationClicked(View view) {
        launchBrowser("http://vets.arizona.edu/future-students");
    }
    public void onAdmissionsClicked(View view) {
        launchBrowser("http://www.admissions.arizona.edu/");
    }
    public void onGIBillClicked(View view) {
        launchBrowser("http://www.gibill.va.gov/");
    }
    public void onTranscriptClicked(View view) {
        launchBrowser("https://jst.doded.mil/");
    }
    public void onFasfaClicked(View view) {
        launchBrowser("http://www.fafsa.ed.gov/");
    }
    public void onStep1NextClicked(View view) {
        switchFragment(new EnrollmentGuidePage2());
    }
    public void onStep2NextClicked(View view) {
        switchFragment(new EnrollmentGuidePage3());
    }

    //Next Steps is U of A Orientation stuff
    public void onNextStepsClicked(View view) {
        launchBrowser("http://nextsteps.arizona.edu/");
    }
    public void onResidencyStatusClicked(View view) {
        launchBrowser("http://registrar.arizona.edu/residency");
    }

    public void onFindCollegeAdvisorClicked(View view) {
        launchBrowser("http://advising.arizona.edu/content/academic-advisor-directory");
    }
    public void onScheduleAdvisementAppointmentClicked(View view) {
        launchBrowser("https://sbs.arizona.edu/advising/student/login.php");
    }
    public void onUAccessClicked(View view) {
        launchBrowser("http://uaccess.arizona.edu/");
    }
    public void onRegistrarCertGuideClicked(View view) {
        launchBrowser("http://www.registrar.arizona.edu/vets/OnlineCertGuide");
    }

    public void onResourceReevaluationClicked(View view) {
        launchBrowser("http://bit.ly/1lYAbZ5");
    }
    public void onEbenefitsClicked(View view) {
        launchBrowser("https://www.ebenefits.va.gov/");
    }

    public void onAboutUsClicked(View view) {
        launchBrowser("http://vets.arizona.edu/about");
    }
    public void onCrisisHotlineClicked(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002738255"));
        startActivity(callIntent);
    }
    public void onJobsClicked(View view) {
        launchBrowser("http://vets.arizona.edu/jobs");
    }
    public void onFemaleVetsClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","alozoya050312@email.arizona.edu",null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Women's Out Reach");
        startActivity(intent);
    }
    public void onSchoolMapClicked(View view) {
        launchBrowser("https://map.arizona.edu/");
    }
    public void onFinancialAidClicked(View view) {
        launchBrowser("http://vets.arizona.edu/financial-resources");
    }
    public void onPalsClicked(View view) {
        launchBrowser("http://vets.arizona.edu/PALS");
    }
    public void onTopClicked(View view) {
        launchBrowser("http://vets.arizona.edu/top");
    }
    public void launchBrowser(String uri) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(browserIntent);
    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
