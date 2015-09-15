package poulguilan.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by arashrasoulzadeh on 15/7/27 AD.
 */
public class notfound extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         TextView tv =new TextView(container.getContext());
        tv.setText("404 - Not Found!");

        return tv;

    }
}
