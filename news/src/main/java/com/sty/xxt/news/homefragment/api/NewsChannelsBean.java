package com.sty.xxt.news.homefragment.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sty.xxt.network.beans.TencentBaseResponse;

import java.util.List;

public class NewsChannelsBean extends TencentBaseResponse {
    @SerializedName("showapi_res_body")
    @Expose
    public ShowapiResBody showapiResBody;

    public class ChannelList {
        @SerializedName("channelId")
        @Expose
        public String channelId;
        @SerializedName("name")
        @Expose
        public String name;
    }

    public class ShowapiResBody {
        @SerializedName("totalNum")
        @Expose
        public Integer totalNum;
        @SerializedName("ret_code")
        @Expose
        public Integer retCode;
        @SerializedName("channelList")
        @Expose
        public List<ChannelList> channelList = null;
    }
}
