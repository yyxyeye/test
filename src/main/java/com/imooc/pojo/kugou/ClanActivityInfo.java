package com.imooc.pojo.kugou;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @Auther: aryaye
 * @Date: 2020/12/18
 */
@Table(name = "t_clan_activity_info")
public class ClanActivityInfo {
    @Id
    @Column(name = "activityId")
    private Long activityId;//活动ID
    @Column(name = "clanId")
    private Long clanId;//公会ID(官方活动公会ID为0)
    @Column(name = "name")
    private String name;//活动名称
    @Column(name = "stepNum")
    private Integer stepNum;//阶段赛总数
    @Column(name = "giftSet")
    private Integer giftSet;//是否有指定礼物（0：没有 1：有）
    @Column(name = "status")
    private Integer status;//活动状态（0还没开始 1：正在进行 -1：比赛结束）
    @Column(name = "starNum")
    private Integer starNum;//参赛主播数量
    @Column(name = "ticket")
    private Long ticket;//活动总票数
    @Column(name = "startTime")
    private Long startTime;//活动总开始时间
    @Column(name = "endTime")
    private Long endTime;//活动总结束时间
    @Column(name = "createTime")
    private Long createTime;//创建时间
    @Column(name = "createBy")
    private String createBy;//创建人
    @Column(name = "updateTime")
    private Long updateTime;//更新时间
    @Column(name = "updateBy")
    private String updateBy;//更新人

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getClanId() {
        return clanId;
    }

    public void setClanId(Long clanId) {
        this.clanId = clanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public Integer getGiftSet() {
        return giftSet;
    }

    public void setGiftSet(Integer giftSet) {
        this.giftSet = giftSet;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
