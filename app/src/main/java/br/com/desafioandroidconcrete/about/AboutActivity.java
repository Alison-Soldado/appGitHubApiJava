package br.com.desafioandroidconcrete.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.LinearLayout;

import br.com.desafioandroidconcrete.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alison on 27/09/17.
 */

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.linearFacebook)
    LinearLayout linearFacebook;

    @BindView(R.id.linearLinkedin)
    LinearLayout linearLinkedin;

    @BindView(R.id.linearInstagram)
    LinearLayout linearInstagram;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(AboutActivity.this);
    }

    @OnClick(R.id.linearFacebook)
    public void getFacebook(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/alison.soldado")));
    }

    @OnClick(R.id.linearLinkedin)
    public void getLinkedin(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/alisonsoldado")));
    }

    @OnClick(R.id.linearInstagram)
    public void getInstagram(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/alison_soldado")));
    }
}
