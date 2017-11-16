package br.com.desafioandroidconcrete;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import net.vidageek.mirror.dsl.Mirror;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import br.com.desafioandroidconcrete.data.network.api.ApiUtils;
import br.com.desafioandroidconcrete.data.network.service.ListRepositoryService;
import br.com.desafioandroidconcrete.home.activity.HomeActivity;
import br.com.desafioandroidconcrete.mock.MockHome;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by alison on 27/09/17.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTestRequestSuccess {

    private MockWebServer server;

    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule<>(HomeActivity.class, false, false);

    // Serão executados antes da activity ser iniciada
    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
        setupServerUrl();
    }

    @Test
    public void whenResultWithSuccess() {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(MockHome.SUCCESS));
        mActivityRule.launchActivity(new Intent());
        onView(withId(R.id.rvListRepository)).check(matches(isDisplayed()));
    }

    // Serão executados ao final de cada teste
    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }

    private void setupServerUrl() {
        ListRepositoryService listRepositoryService = ApiUtils.getListRepositoryService();
        setField(listRepositoryService, "listRepositoryService");
    }

    private void setField(Object target, String fieldName) {
        new Mirror()
                .on(target)
                .set()
                .field(fieldName);
    }
}
