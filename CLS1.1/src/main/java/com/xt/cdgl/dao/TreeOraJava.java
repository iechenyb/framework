package com.xt.cdgl.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
/**
 * easui中的tree_data.json数据,只能有一个root节点
 * [{   
    "id":1,   
    "text":"Folder1",   
    "iconCls":"icon-save",   
    "children":[{   
        "text":"File1",   
        "checked":true  
    }]   
}] 
 * 提供静态方法formatTree(List<TreeJson> list) 返回结果
 * TreeJson.formatTree(treeJsonlist) ;
 * @author lwb
 * 
 * sql:
 *     
<select id="queryATree" resultClass="treeJson" >  
       SELECT t.id,
            t.text,
            t.pid,
                  t.iconcls
     FROM table t
    start with t.pid= 0
    connect by t.pid= prior t.id
    ORDER SIBLINGS BY T.id
</select> 
 *
 */
public class TreeOraJava implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String text =""; 
    private String menubs="";
    
    private List<TreeOraJava> children = new ArrayList<TreeOraJava>() ;
    /******** setter and getter **********/
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public List<TreeOraJava> getChildren() {
		return children;
	}

	public void setChildren(List<TreeOraJava> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMenubs() {
		return menubs;
	}

	public void setMenubs(String menubs) {
		this.menubs = menubs;
	}
}
