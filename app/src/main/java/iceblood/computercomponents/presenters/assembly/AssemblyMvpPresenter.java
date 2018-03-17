package iceblood.computercomponents.presenters.assembly;

import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.presenters.base.Presenter;
import iceblood.computercomponents.view.assembly.AssemblyView;

/**
 *
 */

public interface AssemblyMvpPresenter extends Presenter<AssemblyView> {
    List<Assembly> getAssemblyList();
}
