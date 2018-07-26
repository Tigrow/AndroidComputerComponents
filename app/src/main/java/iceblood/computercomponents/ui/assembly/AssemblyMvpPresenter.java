package iceblood.computercomponents.ui.assembly;

import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.ui.base.Presenter;

/**
 *
 */

interface AssemblyMvpPresenter extends Presenter<AssemblyView> {
    List<Assembly> getAssembies();
    AssemblyListener getListener();

}
