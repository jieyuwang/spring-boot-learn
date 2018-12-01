package com.serialize.test.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class DxPackRecv  implements Serializable {
    private String packId;

    private String packType;

    private String channelId;

    private String routeHist;

    private String packRecvStat;

    private String stateTime;

    public DxPackRecv() {
    }

    public DxPackRecv(String packId, String packType, String channelId, String routeHist, String packRecvStat, String stateTime) {
        this.packId = packId;
        this.packType = packType;
        this.channelId = channelId;
        this.routeHist = routeHist;
        this.packRecvStat = packRecvStat;
        this.stateTime = stateTime;
    }
    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId == null ? null : packId.trim();
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType == null ? null : packType.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getRouteHist() {
        return routeHist;
    }

    public void setRouteHist(String routeHist) {
        this.routeHist = routeHist == null ? null : routeHist.trim();
    }

    public String getPackRecvStat() {
        return packRecvStat;
    }

    public void setPackRecvStat(String packRecvStat) {
        this.packRecvStat = packRecvStat == null ? null : packRecvStat.trim();
    }

    public String getStateTime() {
        return stateTime;
    }

    public void setStateTime(String stateTime) {
        this.stateTime = stateTime == null ? null : stateTime.trim();
    }
}