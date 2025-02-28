package com.fantasy.PrimierLeague.player;

import jakarta.persistence.*;

@Entity
@Table(name = "player_stats")
public class Player {
    @Id
    @Column(name = "name", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String nation;
    private String position;
    private Integer age;
    private Integer mp;
    private Double min;
    private Double gls;
    private Double asts;
    private Double pens;
    private Double yc;
    private Double rc;
    private Double xg;
    private Double xa;
    @Column(name="Team")
    private String teamName;

    public Player() {
    }

    public Player(String name, String nation, String posision, Integer age, Integer mp, Double min, Double gls, Double asts, Double penalties, Double yc, Double rc, Double xg, Double xa, String teamName) {
        this.name = name;
        this.nation = nation;
        this.position = posision;
        this.age = age;
        this.mp = mp;
        this.min = min;
        this.gls = gls;
        this.asts = asts;
        this.pens = penalties;
        this.yc = yc;
        this.rc = rc;
        this.xg = xg;
        this.xa = xa;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosision() {
        return position;
    }

    public void setPosision(String posision) {
        this.position = posision;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getGls() {
        return gls;
    }

    public void setGls(Double gls) {
        this.gls = gls;
    }

    public Double getAsts() {
        return asts;
    }

    public void setAsts(Double asts) {
        this.asts = asts;
    }

    public Double getPenalties() {
        return pens;
    }

    public void setPenalties(Double penalties) {
        this.pens = penalties;
    }

    public Double getYc() {
        return yc;
    }

    public void setYc(Double yc) {
        this.yc = yc;
    }

    public Double getRc() {
        return rc;
    }

    public void setRc(Double rc) {
        this.rc = rc;
    }

    public Double getXg() {
        return xg;
    }

    public void setXg(Double xg) {
        this.xg = xg;
    }

    public Double getXa() {
        return xa;
    }

    public void setXa(Double xa) {
        this.xa = xa;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
