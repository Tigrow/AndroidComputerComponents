package iceblood.computercomponents.view.search;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import iceblood.computercomponents.presenters.PresenterManager;
import iceblood.computercomponents.R;
import iceblood.computercomponents.presenters.search.SearchPresenter;

public class SearchActivity extends AppCompatActivity implements SearchView {

    private SearchPresenter searchPresenter;

    //private List<SimpleProcessor> mSimpleProcessors;

    private View searchView;
    private ProgressBar progressBar;

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private SearchAdapter mSearchAdapter;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    private int firstVisibleItem,visibleItemCount,totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            searchPresenter = new SearchPresenter();
        } else {
            searchPresenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        setContentView(R.layout.activity_search);
        searchView = (View) findViewById(R.id.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.search_progressBar);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mSearchAdapter = new SearchAdapter(this,searchPresenter.getSimpleProcessors());
        recyclerView.setAdapter(mSearchAdapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                if(loading){
                    if(totalItemCount> previousTotal){
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if(!loading && (totalItemCount - visibleItemCount)<=(firstVisibleItem + visibleItemCount)){
                    searchPresenter.loadData();
                    loading = true;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                searchPresenter.addData();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(searchPresenter, outState);
    }
    @Override
    protected void onPause() {
        super.onPause();

        searchPresenter.detachView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        searchPresenter.attachView(this);
     }

    public void showRecyclerViewData(){
        mSearchAdapter.notifyDataSetChanged();
    }

    @Override
    public void setVisibleProgressBar(boolean b) {
        if(b)
        progressBar.setVisibility(ProgressBar.VISIBLE);
        else progressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void showEmpty() {
//
    }

    @Override
    public void showError() {
        Snackbar.make(searchView, "Ошибочка соединения", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
