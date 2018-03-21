package iceblood.computercomponents.ui.search;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.ui.base.Presenter;

/**
 * interface for SearchPresenter
 */

public interface SearchMvpPresenter extends Presenter<SearchView> {
    void loadData();
    List<SimpleProcessor> getSimpleProcessors();
    void setProductID(int productID);
    void LikeData(int position,boolean cheked);
}
