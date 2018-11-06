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
public class CopyOfTreeOraJava implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id ; 
    private String pid ; 
    private String text ; 
    private String iconCls ;
    private String state ; 
    private String checked ; 
    private JSONObject attributes = new JSONObject() ; 
    private List<CopyOfTreeOraJava> children = new ArrayList<CopyOfTreeOraJava>() ;
    
    /******** setter and getter **********/

public static List<CopyOfTreeOraJava> formatTree(List<CopyOfTreeOraJava> list) {

        CopyOfTreeOraJava root = new CopyOfTreeOraJava();
        CopyOfTreeOraJava node = new CopyOfTreeOraJava();
        List<CopyOfTreeOraJava> treelist = new ArrayList<CopyOfTreeOraJava>();// 拼凑好的json格式的数据
        List<CopyOfTreeOraJava> parentnodes = new ArrayList<CopyOfTreeOraJava>();// parentnodes存放所有的父节点
        
        if (list != null && list.size() > 0) {
            root = list.get(0) ;
            //循环遍历oracle树查询的所有节点
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if(node.getPid().equals(root.getId())){
                    //为tree root 增加子节点
                    parentnodes.add(node) ;
                    root.getChildren().add(node) ;
                }else{//获取root子节点的孩子节点
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node) ;
                }
            }    
        }
        treelist.add(root) ;
        return treelist ;

    }

    private static void getChildrenNodes(List<CopyOfTreeOraJava> parentnodes, CopyOfTreeOraJava node) {
        //循环遍历所有父节点和node进行匹配，确定父子关系
        for (int i = parentnodes.size() - 1; i >= 0; i--) {
            
            CopyOfTreeOraJava pnode = parentnodes.get(i);
            //如果是父子关系，为父节点增加子节点，退出for循环
            if (pnode.getId().equals(node.getPid())) {
                pnode.setState("closed") ;//关闭二级树
                pnode.getChildren().add(node) ;
                return ;
            } else {
                //如果不是父子关系，删除父节点栈里当前的节点，
                //继续此次循环，直到确定父子关系或不存在退出for循环
                parentnodes.remove(i) ;
            }
        }
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public JSONObject getAttributes() {
		return attributes;
	}

	public void setAttributes(JSONObject attributes) {
		this.attributes = attributes;
	}

	public List<CopyOfTreeOraJava> getChildren() {
		return children;
	}

	public void setChildren(List<CopyOfTreeOraJava> children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
