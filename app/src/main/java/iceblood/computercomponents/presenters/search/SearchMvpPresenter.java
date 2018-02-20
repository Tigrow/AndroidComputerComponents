package iceblood.computercomponents.presenters.search;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.presenters.base.Presenter;
import iceblood.computercomponents.view.search.SearchView;

/**
 * Created by Titan'ik on 11.02.2018.
 */

public interface SearchMvpPresenter extends Presenter<SearchView> {
    public void addData();
    public void loadData();
    public List<SimpleProcessor> getSimpleProcessors();
}
