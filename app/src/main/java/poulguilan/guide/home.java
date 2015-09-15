package poulguilan.guide;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;

/**
 * Created by arashrasoulzadeh on 15/7/27 AD.
 */
public class home extends android.support.v4.app.Fragment {
    FrameLayout b1, b2, b3, b4, b5, b6, b7, b8, b9, bgift, header;
    ImageView calldirect, telegram;
    ScrollView sv;
    public boolean iconsts;
    public MenuItem m1, m2;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        m1 = menu.add(0, 0, 0, "Option1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setIcon(R.drawable.phone);
        m2 = menu.add(0, 0, 0, "Option2");
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m2.setIcon(R.drawable.telegram);
        m1.setVisible(false);
        m2.setVisible(false);
        m1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:01333343030"));
                startActivity(callIntent);

                return false;
            }
        });
        m2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final String url = "https://telegram.me/poulgilan";

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);

                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(container.getContext(), R.layout.layout_home, null);
        setHasOptionsMenu(true);


        b1 = (FrameLayout) v.findViewById(R.id.btn_home_1);
        b2 = (FrameLayout) v.findViewById(R.id.btn_home_2);
        b3 = (FrameLayout) v.findViewById(R.id.btn_home_3);
        b4 = (FrameLayout) v.findViewById(R.id.btn_home_4);
        b5 = (FrameLayout) v.findViewById(R.id.btn_home_5);
        b6 = (FrameLayout) v.findViewById(R.id.btn_home_6);
        b7 = (FrameLayout) v.findViewById(R.id.btn_home_7);
        b8 = (FrameLayout) v.findViewById(R.id.btn_home_8);
        b9 = (FrameLayout) v.findViewById(R.id.btn_home_9);
        bgift = (FrameLayout) v.findViewById(R.id.btn_home_gift);
        header = (FrameLayout) v.findViewById(R.id.header);

        sv = (ScrollView) v.findViewById(R.id.scrview);

        sv.setOnTouchListener(new View.OnTouchListener() {
                                  @Override
                                  public boolean onTouch(View v, MotionEvent event) {
                                      Rect a = new Rect();
                                      sv.getDrawingRect(a);

                                      float top = header.getY();
                                      float bottom = header.getY() + header.getHeight();

                                      if (bottom < a.top) {

                                          try {
                                              iconsts = true;
                                              if ((!m1.isVisible()) && (!m2.isVisible())) {
                                                  m1.setVisible(true);
                                                  m2.setVisible(true);

                                              } else {
                                              }
                                          } catch (Exception err) {
                                              err.printStackTrace();

                                          }
                                      } else {

                                          iconsts = false;
                                          try {
                                              if ((m1.isVisible()) && (m2.isVisible())) {

                                                  m1.setVisible(false);
                                                  m2.setVisible(false);


                                              } else {
                                              }
                                          } catch (Exception err) {
                                              err.printStackTrace();

                                          }
                                      }

                                      return false;
                                  }
                              }

        );


        final FrameLayout[] layouts = {b1, b2, b3, b4, b5, b6, b7, b8, b9, bgift};
        for (
                int i = 0;
                i < layouts.length; i++)

        {
            layouts[i].setVisibility(View.INVISIBLE);
        }


        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(100);
        in.setFillAfter(true);


        AnimationSet as = new AnimationSet(true);
        as.setFillEnabled(true);
        as.setInterpolator(new

                        LinearInterpolator()

        );
        as.setFillAfter(true);
        ArrayList<Animation> anims = new ArrayList<>();
        for (
                int i = 0;
                i < layouts.length; i++)

        {
            final Animation in1 = new AlphaAnimation(0.0f, 1.0f);
            anims.add(in);
            in.setDuration(1000);
            in.setFillAfter(true);
            as.addAnimation(anims.get(i));
            layouts[i].setAnimation(anims.get(i));
            Log.v(getActivity().getPackageName(), i + "");
        }


        as.startNow();


        calldirect = (ImageView) v.findViewById(R.id.home_calldirect);
        telegram = (ImageView) v.findViewById(R.id.home_telegram);


        calldirect.setOnClickListener(new View.OnClickListener()

                                      {
                                          @Override
                                          public void onClick(View v) {
                                              Intent callIntent = new Intent(Intent.ACTION_CALL);
                                              callIntent.setData(Uri.parse("tel:01333343030"));
                                              startActivity(callIntent);

                                          }
                                      }

        );


        telegram.setOnClickListener(new View.OnClickListener()

                                    {
                                        @Override
                                        public void onClick(View v) {
                                            final String url = "https://telegram.me/poulgilan";

                                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                            startActivity(browserIntent);

                                        }
                                    }

        );


        b1.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View v) {
                                      // Create new fragment and transaction
                                      config.sectionno = config.sectionNumbers.intro;
                                      showText newFragment = new showText();
                                      FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                      transaction.setCustomAnimations(R.anim.slide_in_left,
                                              R.anim.slide_out_right, 0, 0);
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
                                      transaction.replace(R.id.container, newFragment);
                                      transaction.addToBackStack(null);

// Commit the transaction
                                      transaction.commit();

                                  }
                              }

        );

        b7.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View v) {
                                      // Create new fragment and transaction
                                      config.sectionno = config.sectionNumbers.maps;

                                      maps newFragment = new maps();
                                      FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                      transaction.setCustomAnimations(R.anim.slide_in_left,
                                              R.anim.slide_out_right, 0, 0);
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
                                      transaction.replace(R.id.container, newFragment);
                                      transaction.addToBackStack(null);

// Commit the transaction
                                      transaction.commit();

                                  }
                              }

        );

        return v;


    }


    private boolean isViewVisible(View myView) {

        if (myView.getVisibility() == View.VISIBLE) {
            // Its visible
            return true;
        } else {
            // Either gone or invisible
            return false;
        }

    }

    private void runAfter(FrameLayout[] framelayouts, Animation in, int index, int maxindex) {
        try {
            final Animation anim = in;
            final int ind = index;
            final int indmax = maxindex;
            final FrameLayout[] layouts = framelayouts;
            framelayouts[index].startAnimation(anim);

            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    if (ind < indmax) {
                        int i = ind;
                        i++;
                        Log.d(getActivity().getPackageName(), i + "/" + indmax);
                        runAfter(layouts, animation, i, indmax);
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        } catch (Exception err) {

            err.printStackTrace();
        }
    }


}
