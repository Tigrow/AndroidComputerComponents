package iceblood.computercomponents.ui.search;

import iceblood.computercomponents.ui.base.BaseView;

/**
 * interface for SearchActivity
 */

public interface SearchView extends BaseView {

    void showRecyclerViewData();

    void setVisibleProgressBar(boolean b);

    void showEmpty();

    void showError();

}
