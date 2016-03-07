package config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import api.JSON_selectsql;
import www.HTML_selectsql;

public class APTConfing extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setViewType(ViewType.JSP);
		
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/html",HTML_selectsql.class);
		me.add("/json",JSON_selectsql.class);
	}	

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://192.168.1.89/agreept","agree","123456");
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		arp.addMapping("var_map_info", "var_zh_name", Map.class);
		
		/*C3p0Plugin cp = new C3p0Plugin("jdbc:oracle:thin:@localhost:1521:orcl",
                "pdcm", "pdcm");
        
        cp.setDriverClass("oracle.jdbc.driver.OracleDriver");
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);
        
        arp.setDialect(new OracleDialect());
        
        arp.setContainerFactory(new CaseInsensitiveContainerFactory());
        arp.addMapping("BLOG", "ID", Map.class);*/
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
}
