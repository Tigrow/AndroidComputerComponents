package iceblood.computercomponents.model;

/**
 * Created by Titan'ik on 19.02.2018.
 */

class DataManager {
    private static final DataManager ourInstance = new DataManager();

    static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }
}
