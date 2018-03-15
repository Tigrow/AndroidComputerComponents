package iceblood.computercomponents.view.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import iceblood.computercomponents.model.Constants;
import iceblood.computercomponents.presenters.PresenterManager;
import iceblood.computercomponents.R;
import iceblood.computercomponents.presenters.search.SearchMvpPresenter;
import iceblood.computercomponents.presenters.search.SearchPresenter;
import iceblood.computercomponents.view.base.BaseActivity;

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView {

    private View searchView;
    private ProgressBar progressBar;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private SearchAdapter searchAdapter;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    private int firstVisibleItem,visibleItemCount,totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            presenter = new SearchPresenter();
        }else{
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }
        Intent intent = getIntent();
        presenter.setProductID(intent.getIntExtra(Constants.REQUEST_NAME,
                Constants.REQUEST_INTEL));

        setContentView(R.layout.activity_search);
        searchView = (View) findViewById(R.id.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.search_progressBar);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        searchAdapter = new SearchAdapter(presenter.getSimpleProcessors());
        recyclerView.setAdapter(searchAdapter);
        loadListeners();
    }
    private void loadListeners() {
        searchAdapter.setListener(new Listener() {
            @Override
            public void OnClickView(int id) {
                //Здесь будет переход по ID
            }

            @Override
            public void OnClickChechBox(int id, boolean cheked) {
                presenter.LikeData(id,cheked);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                if(loading){
                    if(totalItemCount> previousTotal){
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if(!loading && (totalItemCount - visibleItemCount)<=(firstVisibleItem + visibleItemCount)){
                    presenter.loadData();
                    loading = true;
                }
            }
        });
    }


    @Override
    public void showRecyclerViewData(){
        searchAdapter.notifyDataSetChanged();
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
