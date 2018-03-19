package iceblood.computercomponents.model.objects;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Ignore;

/**
 * POJO
 */
@Entity
public class Assembly {
    @PrimaryKey
    private int id;
    private String name;
    private int cpuID;
    @Ignore
    private String cpuName;
    private int motherboardID;
    @Ignore
    private String motherboardName;
    private int gpuID;
    @Ignore
    private String gpuName;
    private int gpu2ID;
    @Ignore
    private String gpu2Name;
    private int gpu3ID;
    @Ignore
    private String gpu3Name;
    private int gpu4ID;
    @Ignore
    private String gpu4Name;
    private int gpu5ID;
    @Ignore
    private String gpu5Name;
    private int gpu6ID;
    @Ignore
    private String gpu6Name;
    private int gpuColumn;
    private int ramSize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpuID() {
        return cpuID;
    }

    public void setCpuID(int cpuID) {
        this.cpuID = cpuID;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getMotherboardID() {
        return motherboardID;
    }

    public void setMotherboardID(int motherboardID) {
        this.motherboardID = motherboardID;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public int getGpuID() {
        return gpuID;
    }

    public void setGpuID(int gpuID) {
        this.gpuID = gpuID;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public int getGpu2ID() {
        return gpu2ID;
    }

    public void setGpu2ID(int gpu2ID) {
        this.gpu2ID = gpu2ID;
    }

    public String getGpu2Name() {
        return gpu2Name;
    }

    public void setGpu2Name(String gpu2Name) {
        this.gpu2Name = gpu2Name;
    }

    public int getGpu3ID() {
        return gpu3ID;
    }

    public void setGpu3ID(int gpu3ID) {
        this.gpu3ID = gpu3ID;
    }

    public String getGpu3Name() {
        return gpu3Name;
    }

    public void setGpu3Name(String gpu3Name) {
        this.gpu3Name = gpu3Name;
    }

    public int getGpu4ID() {
        return gpu4ID;
    }

    public void setGpu4ID(int gpu4ID) {
        this.gpu4ID = gpu4ID;
    }

    public String getGpu4Name() {
        return gpu4Name;
    }

    public void setGpu4Name(String gpu4Name) {
        this.gpu4Name = gpu4Name;
    }

    public int getGpu5ID() {
        return gpu5ID;
    }

    public void setGpu5ID(int gpu5ID) {
        this.gpu5ID = gpu5ID;
    }

    public String getGpu5Name() {
        return gpu5Name;
    }

    public void setGpu5Name(String gpu5Name) {
        this.gpu5Name = gpu5Name;
    }

    public int getGpu6ID() {
        return gpu6ID;
    }

    public void setGpu6ID(int gpu6ID) {
        this.gpu6ID = gpu6ID;
    }

    public String getGpu6Name() {
        return gpu6Name;
    }

    public void setGpu6Name(String gpu6Name) {
        this.gpu6Name = gpu6Name;
    }

    public int getGpuColumn() {
        return gpuColumn;
    }

    public void setGpuColumn(int gpuColumn) {
        this.gpuColumn = gpuColumn;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

}
