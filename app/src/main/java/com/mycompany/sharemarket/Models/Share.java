package com.mycompany.sharemarket.Models;

public class Share {
    String shareId, openPrice, closePrice, _52WeeksLow, _52WeeksHigh, currentPrice, volume, shareName,
            company;

    public Share(String shareId, String openPrice, String closePrice, String _52WeeksLow,
                 String _52WeeksHigh, String currentPrice, String volume, String shareName, String company) {
        this.shareId = shareId;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this._52WeeksLow = _52WeeksLow;
        this._52WeeksHigh = _52WeeksHigh;
        this.currentPrice = currentPrice;
        this.volume = volume;
        this.shareName = shareName;
        this.company = company;
    }

    public String getShareId() {
        return shareId;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public String get_52WeeksLow() {
        return _52WeeksLow;
    }

    public String get_52WeeksHigh() {
        return _52WeeksHigh;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public String getVolume() {
        return volume;
    }

    public String getShareName() {
        return shareName;
    }

    public String getCompany() {
        return company;
    }
}
