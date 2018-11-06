package com.xt.cdgl.po;

public class SysMenu {
	public String menuId = "";
	public String menuName = "";
	public String menuBs = "";
	public String parentId = "";
	public String url = "";
	public int level = -1;
	public int rank = -1;
	public String path = "";
	public String createTime = "";// 20150101123100
    public int isLeaf=-1;
    public String bz="";
    public String parentBs="";
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getMenuBs() {
		return menuBs;
	}

	public void setMenuBs(String menuBs) {
		this.menuBs = menuBs;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getParentBs() {
		return parentBs;
	}

	public void setParentBs(String parentBs) {
		this.parentBs = parentBs;
	}
}
