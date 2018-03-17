package iceblood.computercomponents.presenters.assembly;

import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.view.assembly.AssemblyView;

/**
 * Created by Titan'ik on 15.03.2018.
 */

public class AssemblyPresenter extends BasePresenter<AssemblyView> implements AssemblyMvpPresenter{

    public AssemblyPresenter(){

    }
    @Override
    public List<Assembly> getAssemblyList() {
        return null;
    }

    @Override
    public void updateView() {

    }
}
