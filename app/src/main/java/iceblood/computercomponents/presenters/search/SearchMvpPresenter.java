package iceblood.computercomponents.presenters.search;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.presenters.base.Presenter;
import iceblood.computercomponents.view.search.SearchView;

/**
 * Created by Titan'ik on 11.02.2018.
 */

public interface SearchMvpPresenter extends Presenter<SearchView> {
    void loadData();
    List<SimpleProcessor> getSimpleProcessors();
    void setProductID(int productID);
    void LikeData(int position,boolean cheked);
}
