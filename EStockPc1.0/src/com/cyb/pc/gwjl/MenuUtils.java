package com.cyb.pc.gwjl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.sf.json.JSONArray;

import com.cyb.pc.Contants;
import com.cyb.pc.event.MoreStockEvent;
import com.cyb.pc.event.MyMenuEvent;
import com.cyb.pc.study.BarCharts;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.FileUtils;
import com.cyb.utils.UrlUtils;

public class MenuUtils {
  public static List<JMenu> menusbars = null;
  public static JPanel getMenus(JFrame window,JPanel center){
	    JMenuBar menubarmain = new JMenuBar();
	    JPanel panel = new JPanel();
	    JMenu subMenuBar =null;
	    menusbars = new ArrayList<JMenu>();
	    //初始化一级菜单
	    for(String subMenuBarName:Contants.menusbar)
	    {
	    	subMenuBar = new JMenu(subMenuBarName);
	    	menubarmain.add(subMenuBar);
	    	menusbars.add(subMenuBar);
	    }
	    //初始化二级菜单
	    
	    //初始化大盘指数子菜单
	    JMenuItem hszsMenuItem = null;
	    for(String dpzsparams:Contants.dpzsLst)
	    {
	    	hszsMenuItem = new JMenuItem(dpzsparams.split("#")[1]);
	    	hszsMenuItem.setName(Contants.menusbar_hszs+"#"+dpzsparams.split("#")[0]);//code sh000001
	    	hszsMenuItem.addActionListener(new MyMenuEvent(window,center));
	    	menusbars.get(Contants.menusbar_hszs).addSeparator();
	    	menusbars.get(Contants.menusbar_hszs).add(hszsMenuItem);
	    }
	    JMenuItem zdtjItem = new JMenuItem("涨跌统计");
	    zdtjItem.setName(Contants.menusbar_hszs+"#zdtj");
	    menusbars.get(Contants.menusbar_hszs).addSeparator();
    	menusbars.get(Contants.menusbar_hszs).add(zdtjItem);
    	zdtjItem.addActionListener(new MyMenuEvent(window,center));
	    //初始化行业分类
	    String industys = FileUtils.readFileByLines(System.getProperty("user.dir")+ConfigUtils.get("HYFILEPATH")).toString();
	    JMenuItem hsflMenuItem = null;
	    String industy[] = industys.split(",");
	    for(int i=0;i<industy.length;i++)
	    {
	    	hsflMenuItem = new JMenuItem(industy[i].split("#")[1]);
	    	hsflMenuItem.setName(Contants.menusbar_hyfl+"#"+industy[i].split("#")[0]);//code sh000001
	    	hsflMenuItem.addActionListener(new MyMenuEvent(window,center));
	    	menusbars.get(Contants.menusbar_hyfl).addSeparator();
	    	menusbars.get(Contants.menusbar_hyfl).add(hsflMenuItem);
	    }
	    
	    //初始化涨跌分析
	    JMenuItem zdfxMenuItem = null;
	    for(String zdfxparams:Contants.zdfxLst)
	    {
	    	zdfxMenuItem = new JMenuItem(zdfxparams.split("#")[1]);
	    	zdfxMenuItem.setName(Contants.menusbar_zdfx+"#"+zdfxparams.split("#")[0]);//code sh000001
	    	zdfxMenuItem.addActionListener(new MyMenuEvent(window,center));
	    	menusbars.get(Contants.menusbar_zdfx).addSeparator();
	    	menusbars.get(Contants.menusbar_zdfx).add(zdfxMenuItem);
	    }
	    //初始化自选股票
	    if(Contants.username.equals("")){
			Contants.username= ConfigUtils.get("username");
		}
		String url=ConfigUtils.get("WebPath")+ConfigUtils.get("MYCONCERNS")+"?username="+Contants.username;
		
	    String content = UrlUtils.downJsonStrFromHttpUrl(url);
		JSONArray data = JSONArray.fromObject(content);
		JMenuItem zxgpMenuItem = null;
		int len = data.size();
		if(len>10){
			len = 10;
		}
		for(int i=0;i<len;i++){
			zxgpMenuItem = new JMenuItem(data.getJSONObject(i).getString("NAME_"));
			zxgpMenuItem.setName(Contants.menusbar_zxgp+"#"+data.getJSONObject(i).getString("CODE_"));
			zxgpMenuItem.addActionListener(new MyMenuEvent(window,center));
			menusbars.get(Contants.menusbar_zxgp).addSeparator();
	    	menusbars.get(Contants.menusbar_zxgp).add(zxgpMenuItem);
		}
		JMenuItem moreItem = new JMenuItem("More");
		moreItem.addActionListener(new MoreStockEvent("myconcern"));
		menusbars.get(Contants.menusbar_zxgp).addSeparator();
    	menusbars.get(Contants.menusbar_zxgp).add(moreItem);
		BorderLayout bord = new BorderLayout();
		panel.setLayout(bord);
		panel.add("North", menubarmain);
	    return panel;
  }
  
}
