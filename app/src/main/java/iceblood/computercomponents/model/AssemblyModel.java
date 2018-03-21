package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.ApplicationMVP;
import iceblood.computercomponents.model.database.AppDataBase;
import iceblood.computercomponents.model.objects.Assembly;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Titan'ik on 20.03.2018.
 */

public class AssemblyModel {
    AppDataBase appDataBase = ApplicationMVP.getInstance().getDatabase();
    public Single<List<Assembly>> getAssemblies(){
        return appDataBase.assemblyDao().getAll()
                .flatMapObservable(assemblies -> Observable.fromIterable(assemblies))
                .doOnNext(assembly ->
                        appDataBase.simpleProcessorDao().getById(assembly.getCpuID())
                                .doOnSuccess(simpleProcessor ->
                                        assembly.setCpuName(simpleProcessor.getName()))
                                .subscribe())
                .toList();
    }
}
