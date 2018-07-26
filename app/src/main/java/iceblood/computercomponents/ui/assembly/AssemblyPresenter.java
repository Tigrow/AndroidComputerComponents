package iceblood.computercomponents.ui.assembly;

import java.util.ArrayList;
import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.ui.base.BasePresenter;

/**
 * Created by Titan'ik on 15.03.2018.
 */

class AssemblyPresenter extends BasePresenter<AssemblyView> implements AssemblyMvpPresenter{
    private List<Assembly> assemblies;
    private AssemblyListener listener;
    AssemblyPresenter(){
        assemblies = new ArrayList<>();
        listener = new AssemblyListener() {
            @Override
            public void OnClickView(int position) {
                //
            }

            @Override
            public void OnClickDelete(int position) {

            }

            @Override
            public void OnClickButton() {

            }
        };
    }

    @Override
    public void updateView() {

    }

    @Override
    public List<Assembly> getAssembies() {
        return assemblies;
    }

    @Override
    public AssemblyListener getListener() {
        return listener;
    }
}
