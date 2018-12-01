package com.serialize.test.pojo;

public class DxPackSend {
    private String packId;

    private String packType;

    private String channelId;

    private String routeHist;

    private String packSendStat;

    private String stateTime;

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

    public String getPackSendStat() {
        return packSendStat;
    }

    public void setPackSendStat(String packSendStat) {
        this.packSendStat = packSendStat == null ? null : packSendStat.trim();
    }

    public String getStateTime() {
        return stateTime;
    }

    public void setStateTime(String stateTime) {
        this.stateTime = stateTime == null ? null : stateTime.trim();
    }
}