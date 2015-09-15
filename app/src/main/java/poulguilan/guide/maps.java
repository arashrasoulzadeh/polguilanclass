package poulguilan.guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arashrasoulzadeh on 15/7/28 AD.
 */
public class maps extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(container.getContext(), R.layout.maps, null);

        return v;
    }
}
