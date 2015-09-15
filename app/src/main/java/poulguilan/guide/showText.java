package poulguilan.guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by arashrasoulzadeh on 15/7/27 AD.
 */
public class showText extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = View.inflate(container.getContext(),R.layout.showtext,null);

        WebView wv = (WebView) v.findViewById(R.id.webView);
        wv.loadUrl("file:///android_asset/intro.html");

        return  v;
    }
}
