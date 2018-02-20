package iceblood.computercomponents.view.search;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.view.base.BaseView;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public interface SearchView extends BaseView {

    void showRecyclerViewData();

    void setVisibleProgressBar(boolean b);

    void showEmpty();

    void showError();

}
