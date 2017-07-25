package com.csing1s.news2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends ListActivity{
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String  NEWS_FORCASR ="NEWS_FORCASR";
    public static final String  BBCNEWS ="BBC";
    public static final String  Busssiness ="Bussiness";
    public static final String  SPORTS ="Sports";
    public static final String  TIMES ="TIMES";
    private Forcast mForcast;
    private BBCNewshelper mhelper;
    private businesshelper mbusiness;
    private  SportsHelper msport;
    private TimesofindiaHelper timesofindiaHelper;


    private NewsData[]mNewsDatas;
    private RelativeLayout mButton;
    private Context context;
    ListView ls;

    private int[] image = {R.drawable.worldnews,
            R.drawable.business,
            R.drawable.technology1,
            R.drawable.sports,
            R.drawable.timesofindia,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getNews();
        getbbcnews();
        getBusiness();
        getSports();
        getTimesOfIndia();
        customAdapter customAdapter = new customAdapter(this,image);
        setListAdapter(customAdapter);
        Log.d(TAG, "UI is working dont worry!");
    }
    private void getNews() {
          String forcasturl ="https://newsapi.org/v1/articles?source=techcrunch&apiKey=f8c29e81b6ec435b80309b927d3676b6";
        if (IsNetworkAvailabel())
        {
            OkHttpClient client = new OkHttpClient();// this object will help to transfer datas and medias
            Request request = new Request.Builder().url(forcasturl).build();

            Call call = client.newCall(request);//call object will take data from
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //  ToogleRefresh();
                        }
                    });
                    AlertUsertError();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //ToogleRefresh();
                        }
                    });

                    try {
                        String jsondata = response.body().string();

                          Log.v(TAG, jsondata);

                          if (response.isSuccessful()) {
                            //    mCurrentWeather = getCurrentDetails(jsondata);
                            mForcast= parseForcasr(jsondata);
                             // getNewsDatas(jsondata);

                            runOnUiThread(new Runnable() {//this method giving direction of IsUpdate to Run on UI thread
                                @Override
                                public void run() {


                                }
                            });


                        } else {
                            AlertUsertError();
                        }
                    }
                    catch (IOException e)
                    {
                        Log.e(TAG, "Exeption Caught:", e);
                    }
                    catch (JSONException e) {
                        Log.e(TAG, "Exeption Caught:", e);
                    }

                }
            });
        } else {
            Toast.makeText(this, "Opps Network is not available", Toast.LENGTH_LONG).show();
        }
    }

private void getbbcnews() {
    String techurl ="https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=83b20969c34c4f4390afe507dbabb7d9";
    if (IsNetworkAvailabel())
    {
        OkHttpClient client = new OkHttpClient();// this object will help to transfer datas and medias
        Request request = new Request.Builder().url(techurl).build();

        Call call = client.newCall(request);//call object will take data from
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //  ToogleRefresh();
                    }
                });
                AlertUsertError();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //ToogleRefresh();
                    }
                });

                try {
                    String jsondata1 = response.body().string();

                    Log.v(TAG, jsondata1);

                    if (response.isSuccessful()) {
                        //    mCurrentWeather = getCurrentDetails(jsondata);
                        mhelper = BBcnewsfun(jsondata1);


                        runOnUiThread(new Runnable() {//this method giving direction of IsUpdate to Run on UI thread
                            @Override
                            public void run() {


                            }
                        });


                    } else {
                        AlertUsertError();
                    }
                }
                catch (IOException e)
                {
                    Log.e(TAG, "Exeption Caught:", e);
                }
                catch (JSONException e) {
                    Log.e(TAG, "Exeption Caught:", e);
                }

            }
        });
    } else {
        Toast.makeText(this, "Opps Network is not available", Toast.LENGTH_LONG).show();
    }
}


    public void getBusiness() {
        String forcasturl ="https://newsapi.org/v1/articles?source=business-insider&sortBy=top&apiKey=83b20969c34c4f4390afe507dbabb7d9";
        if (IsNetworkAvailabel())
        {
            OkHttpClient client = new OkHttpClient();// this object will help to transfer datas and medias
            Request request = new Request.Builder().url(forcasturl).build();

            Call call = client.newCall(request);//call object will take data from
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //  ToogleRefresh();
                        }
                    });
                    AlertUsertError();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //ToogleRefresh();
                        }
                    });

                    try {
                        String jsondata = response.body().string();

                        Log.v(TAG, jsondata);

                        if (response.isSuccessful()) {
                            //    mCurrentWeather = getCurrentDetails(jsondata);
                            mbusiness= Bussinesshelper(jsondata);
                            // getNewsDatas(jsondata);

                            runOnUiThread(new Runnable() {//this method giving direction of IsUpdate to Run on UI thread
                                @Override
                                public void run() {


                                }
                            });


                        } else {
                            AlertUsertError();
                        }
                    }
                    catch (IOException e)
                    {
                        Log.e(TAG, "Exeption Caught:", e);
                    }
                    catch (JSONException e) {
                        Log.e(TAG, "Exeption Caught:", e);
                    }

                }
            });
        } else {
            Toast.makeText(this, "Opps Network is not available", Toast.LENGTH_LONG).show();
        }
    }
    private void getSports() {
        String forcasturl ="https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=83b20969c34c4f4390afe507dbabb7d9";
        if (IsNetworkAvailabel())
        {
            OkHttpClient client = new OkHttpClient();// this object will help to transfer datas and medias
            Request request = new Request.Builder().url(forcasturl).build();

            Call call = client.newCall(request);//call object will take data from
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //  ToogleRefresh();
                        }
                    });
                    AlertUsertError();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //ToogleRefresh();
                        }
                    });

                    try {
                        String jsondata = response.body().string();

                        Log.v(TAG, jsondata);

                        if (response.isSuccessful()) {
                            //    mCurrentWeather = getCurrentDetails(jsondata);
                            msport= SportsnewsHelper(jsondata);
                            // getNewsDatas(jsondata);

                            runOnUiThread(new Runnable() {//this method giving direction of IsUpdate to Run on UI thread
                                @Override
                                public void run() {


                                }
                            });


                        } else {
                            AlertUsertError();
                        }
                    }
                    catch (IOException e)
                    {
                        Log.e(TAG, "Exeption Caught:", e);
                    }
                    catch (JSONException e) {
                        Log.e(TAG, "Exeption Caught:", e);
                    }

                }
            });
        } else {
            Toast.makeText(this, "Opps Network is not available", Toast.LENGTH_LONG).show();
        }
    }

    private void getTimesOfIndia() {
        String forcasturl ="https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=top&apiKey=83b20969c34c4f4390afe507dbabb7d9";
        if (IsNetworkAvailabel())
        {
            OkHttpClient client = new OkHttpClient();// this object will help to transfer datas and medias
            Request request = new Request.Builder().url(forcasturl).build();

            Call call = client.newCall(request);//call object will take data from
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //  ToogleRefresh();
                        }
                    });
                    AlertUsertError();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //ToogleRefresh();
                        }
                    });

                    try {
                        String jsondata = response.body().string();

                        Log.v(TAG, jsondata);

                        if (response.isSuccessful()) {
                            //    mCurrentWeather = getCurrentDetails(jsondata);
                            timesofindiaHelper= timesofindiax(jsondata);
                            // getNewsDatas(jsondata);

                            runOnUiThread(new Runnable() {//this method giving direction of IsUpdate to Run on UI thread
                                @Override
                                public void run() {


                                }
                            });


                        } else {
                            AlertUsertError();
                        }
                    }
                    catch (IOException e)
                    {
                        Log.e(TAG, "Exeption Caught:", e);
                    }
                    catch (JSONException e) {
                        Log.e(TAG, "Exeption Caught:", e);
                    }

                }
            });
        } else {
            Toast.makeText(this, "Opps Network is not available", Toast.LENGTH_LONG).show();
        }
    }



    private boolean IsNetworkAvailabel()// when this method will be called ,it will tell users about network before using this we have give permisson in Manifest   <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        boolean isAvailabel = false;
        if (network != null && network.isConnected()) {
            isAvailabel = true;
        }
        return isAvailabel;

    }


    private void AlertUsertError() // when this methods will be called the dialoge box will comeout on the screen
    {
        AlertDialog.Builder  builder = new AlertDialog.Builder(this).//this method will be called when we create dialoge
                setTitle("Opps! Sorry").
                setMessage("There was an error message,Please Try again").
                setCancelable(true);//pop up on the screen

    }
    private Forcast parseForcasr(String jsondata)throws JSONException
    {
        Forcast forcast = new Forcast();
        forcast.setNewsDatas(getNewsDatas(jsondata));
      //  forcast.setmTechNewsdata(getmTechNewsdata(jasondata1));


        return forcast;
    }
    private BBCNewshelper BBcnewsfun(String jsondata1)throws JSONException
    {
         BBCNewshelper mbbc = new BBCNewshelper();
        mbbc.setmBBc(getmBBc(jsondata1));
        return mbbc;
    }
    private businesshelper Bussinesshelper(String jasondata2) throws JSONException
    {
        businesshelper mhelper= new businesshelper();
        mhelper.setBusiness(getBusiness(jasondata2));
        return mhelper;

    }
    private SportsHelper SportsnewsHelper(String jasondata3) throws JSONException {
        SportsHelper msportds = new SportsHelper();
         msportds.setMsport(getMsport(jasondata3));
        return msportds;
    }
     private TimesofindiaHelper timesofindiax(String jasondata5) throws JSONException {
         TimesofindiaHelper timesofindiaHelper = new TimesofindiaHelper();
         timesofindiaHelper.setTimesofindias(getTimesofindias(jasondata5));
         return  timesofindiaHelper;
     }
    public NewsData[] getNewsDatas(String jasondata) throws  JSONException{
        JSONObject forcast = new JSONObject(jasondata);

        JSONArray dailyweather = forcast.getJSONArray("articles");

        NewsData[] news = new NewsData[dailyweather.length()];
        for (int i = 0; i < dailyweather.length(); i++) {
            JSONObject jasday = dailyweather.getJSONObject(i);
            NewsData newsData = new NewsData();

            newsData.setTitle(jasday.getString("title"));
            newsData.setDescription(jasday.getString("description"));
            newsData.setUrl(jasday.getString("url"));
            newsData.setimage(jasday.getString("urlToImage"));
            news[i] = newsData;

        }
        return news;

    }



    public BBCNews[] getmBBc(String jasondata) throws  JSONException{
        JSONObject forcast = new JSONObject(jasondata);

        JSONArray dailyweather = forcast.getJSONArray("articles");

        BBCNews[] bnews = new BBCNews[dailyweather.length()];
        for (int i = 0; i < dailyweather.length(); i++) {
            JSONObject jasday = dailyweather.getJSONObject(i);
            BBCNews mbbc = new BBCNews();

            mbbc.setTitle1(jasday.getString("title"));
            mbbc.setDescription1(jasday.getString("description"));
            mbbc.setUrl1(jasday.getString("url"));
            mbbc.setimage1(jasday.getString("urlToImage"));
            bnews[i] = mbbc;

        }
        return bnews ;

    }

    public businessnews[] getBusiness(String jasondata2) throws JSONException{
        JSONObject forcast = new JSONObject(jasondata2);

        JSONArray dailyweather = forcast.getJSONArray("articles");

        businessnews[] bnews = new businessnews[dailyweather.length()];
        for (int i = 0; i < dailyweather.length(); i++) {
            JSONObject jasday = dailyweather.getJSONObject(i);
            businessnews mbbc = new businessnews();

            mbbc.setTitle(jasday.getString("title"));
            mbbc.setDescription(jasday.getString("description"));
            mbbc.setUrl(jasday.getString("url"));
            mbbc.setimage(jasday.getString("urlToImage"));
            bnews[i] = mbbc;

        }
        return bnews ;

    }
    public Sports[] getMsport(String jasondata3) throws JSONException {
        JSONObject forcast = new JSONObject(jasondata3);

        JSONArray dailyweather = forcast.getJSONArray("articles");

        Sports[] bnews = new Sports[dailyweather.length()];
        for (int i = 0; i < dailyweather.length(); i++) {
            JSONObject jasday = dailyweather.getJSONObject(i);
            Sports mbbc = new Sports();

            mbbc.setTitle(jasday.getString("title"));
            mbbc.setDescription(jasday.getString("description"));
            mbbc.setUrl(jasday.getString("url"));
            mbbc.setimage(jasday.getString("urlToImage"));
            bnews[i] = mbbc;

        }
        return bnews ;
    }
    public Timesofindia[] getTimesofindias( String jasondata4) throws JSONException {
        JSONObject forcast = new JSONObject(jasondata4);

        JSONArray dailyweather = forcast.getJSONArray("articles");

        Timesofindia[] bnews = new Timesofindia[dailyweather.length()];
        for (int i = 0; i < dailyweather.length(); i++) {
            JSONObject jasday = dailyweather.getJSONObject(i);
            Timesofindia mbbc = new Timesofindia();

            mbbc.setTitle(jasday.getString("title"));
            mbbc.setDescription(jasday.getString("description"));
            mbbc.setUrl(jasday.getString("url"));
            mbbc.setimage(jasday.getString("urlToImage"));
            bnews[i] = mbbc;

        }
        return bnews ;
    }

   @Override
   protected void onListItemClick(ListView l, View v, int position, long id) {


       switch (position)
       {
           case 2:
               Intent intent = new Intent(this,Main2Activity.class);
               intent.putExtra(NEWS_FORCASR,mForcast.getNewsDatas());
               startActivity(intent);
               break;
           case 0:
                  Intent intent1 = new Intent(this, Main3Activity.class);
                   intent1.putExtra(BBCNEWS, mhelper.getmBBc());
                   startActivity(intent1);
               break;
           case 1:
               Intent intent2 = new Intent(this,Main4Activity.class);
               intent2.putExtra(Busssiness,mbusiness.getBusiness());
               startActivity(intent2);
               break;
           case 3:
               Intent intent3 = new Intent(this, Main5Activity.class);
               intent3.putExtra(SPORTS,msport.getMsport() );
               startActivity(intent3);
               break;
           case 4:
               Intent intent4 = new Intent(this, Main6Activity.class);
               intent4.putExtra(TIMES,timesofindiaHelper.getTimesofindias());
               startActivity(intent4);
               break;

       }

       //  super.onListItemClick(l, v, position, id);
   }
    protected void onResume() {
        super.onResume();
    }

}
